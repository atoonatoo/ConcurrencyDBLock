package com.project.concurrencydblock.optimistic;

import java.util.concurrent.atomic.AtomicInteger;

public class OptimisticStockWorker implements Runnable {
    private final Long stockId;
    private final AtomicInteger successCount;
    private final AtomicInteger failCount;
    private final OptimisticLockFacade optimisticLockFacade;

    public OptimisticStockWorker(OptimisticLockFacade optimisticLockFacade, Long stockId,
                                 AtomicInteger successCount, AtomicInteger failCount) {
        this.optimisticLockFacade = optimisticLockFacade;
        this.stockId = stockId;
        this.successCount = successCount;
        this.failCount = failCount;
    }

    @Override
    public void run() {
        try {
            optimisticLockFacade.decrease(stockId, 1L);
            successCount.getAndIncrement();
        } catch (OptimisticStockException.OutOfStock e) {
            failCount.getAndIncrement();
        }
    }
}