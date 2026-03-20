package com.project.concurrencydblock.pessimistic;

import java.util.concurrent.atomic.AtomicInteger;

public class StockResultReporter {
    public static void print(PessimisticStockRepository repository, Long id,
                             AtomicInteger success, AtomicInteger fail) {

        PessimisticStock finalStock = repository.findById(id).orElseThrow();

        System.out.println("# 비관적 락 결과 보고서");
        System.out.println("- 성공 유저: " + success.get());
        System.out.println("- 실패 유저: " + fail.get());
        System.out.println("- 남은 재고: " + finalStock.getQuantity());
    }
}