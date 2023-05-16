package com.levnergroup.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class OrderProduct {
    @EmbeddedId
    @JsonIgnore
    private OrderProductPK pk;

    @Column(nullable = true)
    private Integer quantity;

    public OrderProduct(Order order,Product product,Integer quantity){
        pk = new OrderProductPK();
        pk.setOrder(order);
        pk.setProduct(product);
        this.quantity=quantity;
    }

    @Transient
    public Product getProduct(){
        return this.pk.getProduct();
    }

    @Transient
    public Double getTotalPrice(){
        return getProduct().getPrice() * getQuantity();
    }
}


