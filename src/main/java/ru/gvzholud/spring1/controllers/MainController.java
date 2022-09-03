package ru.gvzholud.spring1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gvzholud.spring1.domain.Product;
import ru.gvzholud.spring1.service.ProductService;

@Controller
public class MainController {

    private ProductService productService;

    @Autowired
    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String infoAboutAllProducts(Model model) {
        model.addAttribute("product", productService.getAll());
        return "products_page";
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public String infoAboutProductById(@PathVariable int id) {
        return productService.getProduct(id).toString();
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("id",id);
        return "update_page";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, @RequestParam String name, @RequestParam int price) {
        Product product = new Product(id,name,price);
        productService.updateProduct(product,id);
        return "redirect:/products";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "create_page";
    }

    @PostMapping("/create")
    public String createProduct(@RequestParam String name, @RequestParam int price) {
        Product product = new Product(name, price);
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String showDeleteForm() {
        return "delete_page";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }
}
