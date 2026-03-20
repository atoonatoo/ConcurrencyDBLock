package com.project.concurrencydblock.pessimistic;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
public class ConcurrencyTestRunner implements CommandLineRunner {
    private final PessimisticStockService stockService;
    private final PessimisticStockRepository stockRepository;

    @Override
    public void run(String... args) throws InterruptedException {
        Long stockId = stockRepository.save(new PessimisticStock(100L)).getId();
        int threadCount = 1000;
        AtomicInteger successCount = new AtomicInteger();
        AtomicInteger failCount = new AtomicInteger();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new PessimisticStockWorker(
                    stockService, stockId, successCount, failCount
            ));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        StockResultReporter.print(stockRepository, stockId, successCount, failCount);
    }
}