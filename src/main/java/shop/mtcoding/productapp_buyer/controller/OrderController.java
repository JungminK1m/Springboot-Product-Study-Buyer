package shop.mtcoding.productapp_buyer.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.mtcoding.productapp_buyer.dto.orders.OrdersDto;
import shop.mtcoding.productapp_buyer.model.orders.Orders;
import shop.mtcoding.productapp_buyer.model.orders.OrdersRepository;
import shop.mtcoding.productapp_buyer.model.product.ProductRepository;
import shop.mtcoding.productapp_buyer.model.user.User;

@Controller
public class OrderController {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private HttpSession session;

    // 구매 목록 페이지
    @GetMapping("/orderListForm/{userId}")
    public String orderListForm(@PathVariable Integer userId, Model model) {

        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/";
        }

        List<Orders> ordersList = ordersRepository.findAll(userId);
        model.addAttribute("orderedProduct", ordersList);

        return "order/orderListForm";
    }

    // 상품 구매하기
    // 어떤 상품을 구매했는 지 알아야해서 주소에 productId가 필요함(?) <--확인하기
    @PostMapping("/order/{productId}")
    public String order(@PathVariable Integer productId, OrdersDto ordersDto) {

        // 로그인 한 사람만 구매할 수 있음
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/";
        }
        // System.out.println(ordersDto.getOrdersName());

        // 구매를 하면 product qty가 차감되어야 함
        productRepository.productQtyUpdate(ordersDto);

        // System.out.println("프로덕트 레파지토리 : " + ordersDto.getOrdersName());

        // principal.getUserId() 너무 길어서 변수로 만듦
        int userId = principal.getUserId();
        /*
         * 구매버튼 누르면 insert 됨
         * 누가 구매했는 지 필요하기 때문에 userId도 같이 insert 해야 함
         */
        ordersRepository.insert(ordersDto, userId);

        // System.out.println("오더 레파지토리 : " + ordersDto.getOrdersName());

        return "redirect:/orderListForm/" + userId;
    }
}
