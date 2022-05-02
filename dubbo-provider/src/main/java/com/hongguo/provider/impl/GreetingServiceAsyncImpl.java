package com.hongguo.provider.impl;

import com.hongguo.dubbo.provider.GreetingServiceAsync;
import org.apache.dubbo.common.utils.NamedThreadFactory;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hongguo_cheng
 * @date 2022/4/5
 */
public class GreetingServiceAsyncImpl implements GreetingServiceAsync {

    private final ThreadPoolExecutor bizThreadPool =
            new ThreadPoolExecutor(8, 16, 1, TimeUnit.MINUTES,
                    new SynchronousQueue<>(), new NamedThreadFactory("biz-thread-pool"),
                    new ThreadPoolExecutor.CallerRunsPolicy());

    @Override
    public CompletableFuture<String> sayHello(String name) {
        RpcContext context = RpcContext.getContext();
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("async return ");
            return "Hello " + name + " " + context.getAttachment("company");
        }, bizThreadPool);
    }
}
