package com.project.concurrencydblock.optimistic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOptimisticStock is a Querydsl query type for OptimisticStock
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOptimisticStock extends EntityPathBase<OptimisticStock> {

    private static final long serialVersionUID = 393034556L;

    public static final QOptimisticStock optimisticStock = new QOptimisticStock("optimisticStock");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> quantity = createNumber("quantity", Long.class);

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QOptimisticStock(String variable) {
        super(OptimisticStock.class, forVariable(variable));
    }

    public QOptimisticStock(Path<? extends OptimisticStock> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOptimisticStock(PathMetadata metadata) {
        super(OptimisticStock.class, metadata);
    }

}

