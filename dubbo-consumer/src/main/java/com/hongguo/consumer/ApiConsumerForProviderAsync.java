package com.hongguo.consumer;

import com.hongguo.dubbo.provider.GreetingServiceAsync;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.CompletableFuture;

/**
 * @author hongguo_cheng
 * @date 2022/4/5
 */
public class ApiConsumerForProviderAsync {
    public static void main(String[] args) throws Exception {
        ReferenceConfig<GreetingServiceAsync> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        referenceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        referenceConfig.setInterface(GreetingServiceAsync.class);
        referenceConfig.setTimeout(5000);
        referenceConfig.setVersion("1.0");
        referenceConfig.setGroup("dubbo");
        GreetingServiceAsync greetingService = referenceConfig.get();
        RpcContext.getContext().setAttachment("company", "alibaba");
        CompletableFuture<String> future = greetingService.sayHello("world");
        future.whenComplete((v, t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                System.out.println(v);
            }
        });
        Thread.currentThread().join();
    }
}
