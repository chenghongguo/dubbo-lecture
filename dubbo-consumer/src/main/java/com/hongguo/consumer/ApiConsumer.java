package com.hongguo.consumer;

import com.hongguo.dubbo.provider.GreetingService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.RpcContext;

/**
 * @author hongguo_cheng
 * @date 2022/4/5
 */
public class ApiConsumer {
    public static void main(String[] args) throws Exception {
        ReferenceConfig<GreetingService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(new ApplicationConfig("first-dubbo-consumer"));
        referenceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        referenceConfig.setInterface(GreetingService.class);
        referenceConfig.setTimeout(3000);
        referenceConfig.setVersion("1.0");
        referenceConfig.setGroup("dubbo");
        GreetingService greetingService = referenceConfig.get();
        RpcContext.getContext().setAttachment("company", "alibaba");
        System.out.println(greetingService.sayHello("world"));
//        System.in.read();
    }
}
