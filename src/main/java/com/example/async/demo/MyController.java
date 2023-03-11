package com.example.async.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
/*
@EnableAsync
*/
public class MyController {
    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private MyService myService;

    @GetMapping("/async")
    public CompletableFuture<String> asyncEndpoint() {
        logger.info("asyncEndpoint Called in MyController");
        CompletableFuture<String> futureResult = myService.asyncMethod();
        futureResult.thenApply(result -> {
            // handle the result here
            return "Result is "+ result;
        });

        return futureResult;
    }

}