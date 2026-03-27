package com.project.concurrencydblock.pessimistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConcurrencyPessimisticApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConcurrencyPessimisticApplication.class, args);
    }
}