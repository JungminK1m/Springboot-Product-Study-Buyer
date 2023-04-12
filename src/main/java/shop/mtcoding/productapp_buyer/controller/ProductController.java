package shop.mtcoding.productapp_buyer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/product")
    public String productList() {
        return "product/productList";
    }

    @GetMapping("/product/1")
    public String productDetail() {
        return "product/productDetail";
    }

}
