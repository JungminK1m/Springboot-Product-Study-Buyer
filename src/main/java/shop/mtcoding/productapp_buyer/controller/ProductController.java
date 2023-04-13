package shop.mtcoding.productapp_buyer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import shop.mtcoding.productapp_buyer.model.product.Product;
import shop.mtcoding.productapp_buyer.model.product.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public String productList(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("product", productList);
        return "product/productList";
    }

    @GetMapping("/product/{productId}")
    public String productDetail(@PathVariable Integer productId, Model model) {
        Product product = productRepository.findById(productId);
        model.addAttribute("product", product);

        return "product/productDetail";
    }

}
