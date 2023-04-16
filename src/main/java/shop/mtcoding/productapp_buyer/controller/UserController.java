package shop.mtcoding.productapp_buyer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.productapp_buyer.dto.user.JoinDto;
import shop.mtcoding.productapp_buyer.dto.user.LoginDto;
import shop.mtcoding.productapp_buyer.handler.ex.CustomException;
import shop.mtcoding.productapp_buyer.model.user.User;
import shop.mtcoding.productapp_buyer.model.user.UserRepository;

@Controller
public class UserController {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserRepository userRepository;

    // 메인페이지가 로그인 페이지
    @GetMapping("/")
    public String loginForm() {
        return "user/loginForm";
    }

    @PostMapping("/login")
    public String login(LoginDto loginDto) {
        User userPS = userRepository.findByUsernameAndPassword(loginDto);

        if (userPS != null) {
            session.setAttribute("principal", userPS);

            System.out.println("username : " + userPS.getUserName());
            System.out.println("password : " + userPS.getUserPassword());

            System.out.println("로그인 됨");
            return "redirect:/product";
        } else {

            System.out.println("로그인 안 됨");
            throw new CustomException("로그인에 실패하였습니다.", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(JoinDto joinDto) {

        // 유효성 체크
        if (joinDto.getUserName().isEmpty()) {
            throw new CustomException("username을 입력해 주세요.", HttpStatus.BAD_REQUEST);
        }
        if (joinDto.getUserPassword().isEmpty()) {
            throw new CustomException("password를 입력해 주세요.", HttpStatus.BAD_REQUEST);
        }
        if (joinDto.getUserEmail().isEmpty()) {
            throw new CustomException("email을 입력해 주세요.", HttpStatus.BAD_REQUEST);
        }

        // 기존 동일 유저 확인 (username,email만)
        if (userRepository.findByUserName(joinDto.getUserName()) != null) {
            throw new CustomException("이미 가입된 유저입니다.", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.findByUserEmail(joinDto.getUserEmail()) != null) {
            throw new CustomException("이미 가입된 이메일입니다.", HttpStatus.BAD_REQUEST);
        }

        userRepository.insert(joinDto);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }
}
