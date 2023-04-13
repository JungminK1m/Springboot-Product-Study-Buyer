package shop.mtcoding.productapp_buyer.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.productapp_buyer.dto.orders.OrdersDto;
import shop.mtcoding.productapp_buyer.model.orders.Orders;
import shop.mtcoding.productapp_buyer.model.orders.OrdersRepository;
import shop.mtcoding.productapp_buyer.model.user.User;

@Controller
public class OrderController {

    @Autowired
    private OrdersRepository ordersRepository;

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
    @PostMapping("/order/{productId}")
    public String order(@PathVariable Integer userId, OrdersDto ordersDto) {

        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/";
        }

        ordersRepository.insert(ordersDto, principal.getUserId());

        return "redirect:/order/orderListForm";
    }
}
