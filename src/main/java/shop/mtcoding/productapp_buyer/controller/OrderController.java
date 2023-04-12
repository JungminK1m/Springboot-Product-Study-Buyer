package shop.mtcoding.productapp_buyer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @GetMapping("/order")
    public String orderListForm() {
        return "order/orderListForm";
    }

}
