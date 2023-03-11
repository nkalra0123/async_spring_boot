package com.example.async.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;

@Service
public class MyService {

    private static final Logger logger = LoggerFactory.getLogger(MyService.class);

    @Async
    public CompletableFuture<String> asyncMethod() {
        // This can be any work, like save to db, call some api, or compute a heavy operation
        logger.info("asyncMethod Called in MyService");

        BigInteger result = BigInteger.valueOf(1);
        for (int i = 2; i <= 5; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return CompletableFuture.completedFuture("Result: " + result.toString());
    }
}