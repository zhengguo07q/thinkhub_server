package com.thinkhub.component.gateway.service;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.SetArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;


class IRouteServiceTest {
    private static Logger log = LoggerFactory.getLogger(IRouteServiceTest.class);
    private static StatefulRedisConnection<String, String> CONNECTION;
    private static RedisClient CLIENT;
    private static RedisCommands<String, String> COMMAND;
    private static RedisAsyncCommands<String, String> ASYNC_COMMAND;

    @BeforeAll
    public static void beforeClass() {
        RedisURI redisUri = RedisURI.builder()
                .withHost("localhost")
                .withPort(6379)
                .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();
        CLIENT = RedisClient.create(redisUri);
        CONNECTION = CLIENT.connect();
    }

    @AfterAll
    public static void afterClass() throws Exception {
        CONNECTION.close();
        CLIENT.shutdown();
    }

    @BeforeEach
    public void Before() {
        COMMAND = CONNECTION.sync();
        ASYNC_COMMAND = CONNECTION.async();
    }

    @Test
    public void testSyncPing() throws Exception {
        String pong = COMMAND.ping();
        Assertions.assertThat(pong).isEqualToIgnoringCase("PONG");
    }


    @Test
    public void testSyncSetAndGet() throws Exception {
        SetArgs setArgs = SetArgs.Builder.nx().ex(5);
        COMMAND.set("name", "throwable", setArgs);
        String value = COMMAND.get("name");
    }

    @Test
    public void testAsyncPing() throws Exception {
        RedisFuture<String> redisFuture = ASYNC_COMMAND.ping();
        log.info("Ping result:{}", redisFuture.get());
    }

    @Test
    public void testAsyncSetAndGet1() throws Exception {
        SetArgs setArgs = SetArgs.Builder.nx().ex(5);
        RedisFuture<String> future = ASYNC_COMMAND.set("name", "throwable", setArgs);
        // CompletableFuture#thenAccept()
        future.thenAccept(value -> log.info("Set命令返回:{}", value));
        // Future#get()
        future.get();
    }
// Set命令返回:OK

    @Test
    public void testAsyncSetAndGet2() throws Exception {
        SetArgs setArgs = SetArgs.Builder.nx().ex(5);
        CompletableFuture<Void> result =
                (CompletableFuture<Void>) ASYNC_COMMAND.set("name", "throwable", setArgs)
                        .thenAcceptBoth(ASYNC_COMMAND.get("name"),
                                (s, g) -> {
                                    log.info("Set命令返回:{}", s);
                                    log.info("Get命令返回:{}", g);
                                });
        result.get();
    }

    @Test
    void getRouteDefinitions() {
    }
}