package com.project.concurrencydblock.optimistic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OptimisticStockRepository extends JpaRepository<OptimisticStock, Long> {
}