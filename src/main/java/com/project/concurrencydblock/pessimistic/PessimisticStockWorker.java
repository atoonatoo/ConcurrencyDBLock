package com.project.concurrencydblock.pessimistic;

import java.util.concurrent.atomic.AtomicInteger;

public class PessimisticStockWorker implements Runnable {
    private final PessimisticStockService stockService;
    private final Long stockId;
    private final AtomicInteger successCount;
    private final AtomicInteger failCount;

    public PessimisticStockWorker(PessimisticStockService stockService, Long stockId,
                                  AtomicInteger successCount, AtomicInteger failCount) {
        this.stockService = stockService;
        this.stockId = stockId;
        this.successCount = successCount;
        this.failCount = failCount;
    }

    @Override
    public void run() {
        try {
            stockService.decreaseStock(stockId, 1L);
            successCount.getAndIncrement();
        } catch (PessimisticStockException.OutOfStock e) {
            failCount.getAndIncrement();
        }
    }
}