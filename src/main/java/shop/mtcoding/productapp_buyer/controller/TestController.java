package shop.mtcoding.productapp_buyer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import shop.mtcoding.productapp_buyer.model.Product;
import shop.mtcoding.productapp_buyer.model.ProductRepository;

@Controller
public class TestController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String test(Model model) {
        List<Product> productList = (List<Product>) productRepository.findAll();
        model.addAttribute("productList", productList);

        return "test";
    }
}
