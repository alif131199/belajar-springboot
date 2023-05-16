package com.levnergroup.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.levnergroup.entity.Order;
import com.levnergroup.repositories.OrderRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImp implements OrderService{

    private OrderRepo repo;

    public OrderServiceImp(OrderRepo repo){
        this.repo = repo;
    }

   @Override
   public Iterable<Order> getAllOrders(){
        return this.repo.findAll();
   }

   @Override
   public Order create(Order order){
        order.setDateCreated(LocalDate.now());

        return this.repo.save(order);
   }

   @Override
   public void update(Order order){
        this.repo.save(order);
   }
}
