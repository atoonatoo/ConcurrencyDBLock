package com.project.concurrencydblock.optimistic;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OptimisticStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantity;
    @Version
    private Long version;

    public OptimisticStock(Long quantity) {
        this.quantity = quantity;
    }

    public void decrease(Long amount) {
        if (this.quantity < amount) {
            throw new OptimisticStockException.OutOfStock();
        }
        this.quantity -= amount;
    }
}