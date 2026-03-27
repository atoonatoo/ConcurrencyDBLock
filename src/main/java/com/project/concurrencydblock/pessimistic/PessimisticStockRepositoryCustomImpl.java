package com.project.concurrencydblock.pessimistic;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.LockModeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import static com.project.concurrencydblock.pessimistic.QPessimisticStock.pessimisticStock;

@Repository
@RequiredArgsConstructor
public class PessimisticStockRepositoryCustomImpl implements PessimisticStockRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<PessimisticStock> findByIdWithLock(Long id) {
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(pessimisticStock)
                        .where(pessimisticStock.id.eq(id))
                        .setLockMode(LockModeType.PESSIMISTIC_WRITE)
                        .fetchOne()
        );
    }
}