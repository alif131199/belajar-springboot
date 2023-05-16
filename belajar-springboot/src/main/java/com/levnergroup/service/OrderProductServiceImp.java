package com.levnergroup.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.levnergroup.entity.OrderProduct;
import com.levnergroup.repositories.OrderProductRepo;

@Service
@Transactional
public class OrderProductServiceImp implements OrderProductService {

    private OrderProductRepo repo;

    public OrderProductServiceImp(OrderProductRepo repo) {
        this.repo= repo;
    }

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return this.repo.save(orderProduct);
    }
}
