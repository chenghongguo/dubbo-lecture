package com.hongguo.consumer;

import com.hongguo.dubbo.provider.GreetingService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.CompletableFuture;

/**
 * @author hongguo_cheng
 * @date 2022/4/5
 */
public class ApiAsyncConsumerForCompletableFuture {
    public static void main(String[] args) throws Exception {
        ReferenceConfig<GreetingService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        referenceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        referenceConfig.setInterface(GreetingService.class);
        referenceConfig.setTimeout(3000);
        referenceConfig.setVersion("1.0");
        referenceConfig.setGroup("dubbo");
        // 设置为异步
        referenceConfig.setAsync(true);

        // 直接返回null
        GreetingService greetingService = referenceConfig.get();
        System.out.println(greetingService.sayHello("world"));

        // 异步执行回调
        CompletableFuture<String> future = RpcContext.getContext().getCompletableFuture();
        future.whenComplete((v, t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                System.out.println(v);
            }
        });

        System.out.println("over");
        Thread.currentThread().join();
    }
}
