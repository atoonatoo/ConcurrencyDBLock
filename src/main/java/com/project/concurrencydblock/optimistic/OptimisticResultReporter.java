package com.project.concurrencydblock.optimistic;

import java.util.concurrent.atomic.AtomicInteger;

public class OptimisticResultReporter {
    public static void print(OptimisticStockRepository repository, Long id,
                             AtomicInteger success, AtomicInteger fail) {

        OptimisticStock finalStock = repository.findById(id).orElseThrow();

        System.out.println("# 낙관적 락 결과 보고서");
        System.out.println("- 구매 성공 재고 합계 : " + success.get());
        System.out.println("- 재고 부족 합계 : " + fail.get());
        System.out.println("- 최종 데이터 버전 : " + finalStock.getVersion());
        System.out.println("- 남은 재고 : " + finalStock.getQuantity());

        if (finalStock.getQuantity() == 0 && success.get() == 100) {
            System.out.println("- 결과 : 성공");
        } else {
            System.out.println("- 결과 : 실패");
        }
    }
}