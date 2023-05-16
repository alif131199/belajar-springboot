package com.levnergroup.repositories;

import org.springframework.data.repository.CrudRepository;

import com.levnergroup.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
    
}
