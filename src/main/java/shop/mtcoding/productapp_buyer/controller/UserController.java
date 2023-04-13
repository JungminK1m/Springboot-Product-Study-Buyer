package shop.mtcoding.productapp_buyer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.productapp_buyer.dto.user.LoginDto;
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
            System.out.println("username : " + userPS.getUserPassword());

            System.out.println("로그인 됨");
            return "redirect:/product";
        } else {

            System.out.println("로그인 안 됨");
            return "redirect:/";
        }

    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }
}
