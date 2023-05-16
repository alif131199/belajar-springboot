package com.levnergroup.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.levnergroup.entity.Order;
import com.levnergroup.entity.OrderProduct;
import com.levnergroup.service.OrderProductService;
import com.levnergroup.service.OrderService;
import com.levnergroup.service.ProductService;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/order")
public class OrderController {

    ProductService productService;
    OrderService orderService;
    OrderProductService orderProductService;

    public OrderController(ProductService productService, OrderService orderService, OrderProductService orderProductService){
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }

    
    @GetMapping
    public String welcome(Model model){
        model.addAttribute("orders", orderService.getAllOrders());
        return "order";
    }

    @GetMapping("/createorder")
    public String createorder(Order order, Model orderProduct, Model productlist){
        order = new Order();
        orderProduct.addAttribute("order", new OrderProduct(order, null, null));
        productlist.addAttribute("products", productService.findAll());
        return "createorder";
    }

    @PostMapping("/saveorder")
    public String save (OrderProduct orderProduct, Model model){
        orderProductService.create(orderProduct);
        return "redirect:/order";
    }

}
