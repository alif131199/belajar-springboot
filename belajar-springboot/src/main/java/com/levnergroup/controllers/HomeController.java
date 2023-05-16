package com.levnergroup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.levnergroup.entity.Product;
import com.levnergroup.service.ProductService;


@Controller
@RequestMapping("")
public class HomeController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public String welcome(Model model){
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/addproduct")
    public String add(Model model){
        model.addAttribute("product", new Product());
        return "addproduct";
    }

    @PostMapping("/save")
    public String save(Product product, Model model){
        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("deleteproduct/{id}")
    public String delete(@PathVariable("id") Long id){
        productService.delProduct(id);
        return "redirect:/";
    }

    @GetMapping("editproduct/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("product", productService.findProduct(id));
        return "editproduct";
    }

    @PostMapping("/update")
    public String update(Product product, Model model){
        productService.updateProduct(product);
        return "redirect:/";
    }

}
