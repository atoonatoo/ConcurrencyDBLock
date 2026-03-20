package com.project.concurrencydblock.pessimistic;

public class PessimisticStockException extends RuntimeException {
    public PessimisticStockException(String message) {
        super(message);
    }

    public static class NotFound extends PessimisticStockException {
        private static final String MESSAGE = "해당 id의 재고 데이터를 찾을 수 없습니다.";
        public NotFound() {
            super(MESSAGE);
        }
    }

    public static class OutOfStock extends PessimisticStockException {
        private static final String MESSAGE = "재고가 모두 소진되었습니다.";
        public OutOfStock() {
            super(MESSAGE);
        }
    }
}