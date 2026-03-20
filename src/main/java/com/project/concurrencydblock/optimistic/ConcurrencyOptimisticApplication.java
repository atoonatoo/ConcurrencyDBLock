package com.project.concurrencydblock.optimistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConcurrencyOptimisticApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConcurrencyOptimisticApplication.class, args);
    }
}