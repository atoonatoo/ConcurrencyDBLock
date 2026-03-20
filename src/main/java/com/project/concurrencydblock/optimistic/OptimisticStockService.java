package com.project.concurrencydblock.optimistic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OptimisticStockService {
    private final OptimisticStockRepository stockRepository;

    @Transactional
    public void decreaseStock(Long id, Long amount) {
        OptimisticStock stock = stockRepository.findById(id)
                .orElseThrow(OptimisticStockException.NotFound::new);
        stock.decrease(amount);
    }
}