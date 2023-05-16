package com.levnergroup.repositories;

import org.springframework.data.repository.CrudRepository;

import com.levnergroup.entity.OrderProduct;
import com.levnergroup.entity.OrderProductPK;

public interface OrderProductRepo extends CrudRepository<OrderProduct, OrderProductPK> {
    
}
