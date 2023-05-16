package com.levnergroup.repositories;

import org.springframework.data.repository.CrudRepository;

import com.levnergroup.entity.Order;

public interface OrderRepo extends CrudRepository<Order,Long>{
    
}
