package com.project.concurrencydblock.pessimistic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PessimisticStockService {
    private final PessimisticStockRepository stockRepository;

    @Transactional
    public void decreaseStock(Long id, Long amount) {
        PessimisticStock stock = stockRepository.findByIdWithLock(id)
                .orElseThrow(PessimisticStockException.NotFound::new);
        stock.decrease(amount);
    }
}