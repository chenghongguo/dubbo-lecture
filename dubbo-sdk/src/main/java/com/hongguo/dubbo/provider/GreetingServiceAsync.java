package com.hongguo.dubbo.provider;

import java.util.concurrent.CompletableFuture;

/**
 * @author hongguo_cheng
 * @date 2022/4/5
 */
public interface GreetingServiceAsync {
    CompletableFuture<String> sayHello(String name);
}
