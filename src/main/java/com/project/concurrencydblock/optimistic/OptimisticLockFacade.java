package com.project.concurrencydblock.optimistic;

import lombok.RequiredArgsConstructor;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OptimisticLockFacade {
    private final OptimisticStockService stockService;

    public void decrease(Long id, Long amount) {
        while (true) {
            try {
                stockService.decreaseStock(id, amount);
                break;
            } catch (ObjectOptimisticLockingFailureException e) {
                try { Thread.sleep(50); } catch (InterruptedException ignored) {}
            }
        }
    }
}