package com.project.concurrencydblock.optimistic;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
public class OptimisticTestRunner implements CommandLineRunner {
    private final OptimisticStockRepository stockRepository;
    private final OptimisticLockFacade optimisticLockFacade;

    @Override
    public void run(String... args) throws InterruptedException {
        Long stockId = stockRepository.save(new OptimisticStock(100L)).getId();
        int threadCount = 1000;
        AtomicInteger successCount = new AtomicInteger();
        AtomicInteger failCount = new AtomicInteger();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new OptimisticStockWorker(
                    optimisticLockFacade, stockId, successCount, failCount
            ));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        OptimisticResultReporter.print(stockRepository, stockId, successCount, failCount);
    }
}