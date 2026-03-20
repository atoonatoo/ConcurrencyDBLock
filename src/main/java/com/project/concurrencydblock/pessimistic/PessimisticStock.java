package com.project.concurrencydblock.pessimistic;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PessimisticStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantity;

    public PessimisticStock(Long quantity) {
        this.quantity = quantity;
    }

    public void decrease(Long amount) {
        if (this.quantity < amount) {
            throw new PessimisticStockException.OutOfStock();
        }
        this.quantity -= amount;
    }
}