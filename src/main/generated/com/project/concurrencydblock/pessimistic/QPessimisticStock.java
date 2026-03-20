package com.project.concurrencydblock.pessimistic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPessimisticStock is a Querydsl query type for PessimisticStock
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPessimisticStock extends EntityPathBase<PessimisticStock> {

    private static final long serialVersionUID = -1516354270L;

    public static final QPessimisticStock pessimisticStock = new QPessimisticStock("pessimisticStock");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> quantity = createNumber("quantity", Long.class);

    public QPessimisticStock(String variable) {
        super(PessimisticStock.class, forVariable(variable));
    }

    public QPessimisticStock(Path<? extends PessimisticStock> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPessimisticStock(PathMetadata metadata) {
        super(PessimisticStock.class, metadata);
    }

}

