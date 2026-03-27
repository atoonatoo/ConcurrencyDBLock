package com.project.concurrencydblock.optimistic;

public class OptimisticStockException extends RuntimeException {
    public OptimisticStockException(String message) {
        super(message);
    }

    public static class NotFound extends OptimisticStockException {
        private static final String MESSAGE = "해당 id의 재고 데이터를 찾을 수 없습니다.";
        public NotFound() {
            super(MESSAGE);
        }
    }

    public static class OutOfStock extends OptimisticStockException {
        private static final String MESSAGE = "재고가 부족합니다.";
        public OutOfStock() {
            super(MESSAGE);
        }
    }
}