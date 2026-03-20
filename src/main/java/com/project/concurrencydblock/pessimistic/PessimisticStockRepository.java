package com.project.concurrencydblock.pessimistic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessimisticStockRepository extends JpaRepository<PessimisticStock, Long>,
        PessimisticStockRepositoryCustom {}
