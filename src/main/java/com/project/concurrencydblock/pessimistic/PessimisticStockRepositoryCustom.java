package com.project.concurrencydblock.pessimistic;

import java.util.Optional;

public interface PessimisticStockRepositoryCustom {
    Optional<PessimisticStock> findByIdWithLock(Long id);
}