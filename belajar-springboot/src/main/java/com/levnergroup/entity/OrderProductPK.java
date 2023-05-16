package com.levnergroup.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
public class OrderProductPK {
    @JsonBackReference
    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;
}
