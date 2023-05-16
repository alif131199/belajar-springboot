package com.levnergroup.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levnergroup.entity.Product;
import com.levnergroup.repositories.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepo repo;

    public Iterable<Product> findAll(){
        return repo.findAll();
    }

    public void addProduct(Product product){
        repo.save(product);
    }

    public void delProduct(long Id){
        repo.deleteById(Id);
    }

    public Optional<Product> findProduct(long Id){
        return repo.findById(Id);
    }

    public void updateProduct(Product product){
        repo.save(product);
    }
}
