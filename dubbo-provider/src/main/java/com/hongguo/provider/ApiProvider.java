package com.hongguo.provider;

import com.hongguo.dubbo.provider.GreetingService;
import com.hongguo.provider.impl.GreetingServiceImpl;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

/**
 * @author hongguo_cheng
 * @date 2022/4/5
 */
public class ApiProvider {
    public static void main(String[] args) throws Exception {
        // 创建ServiceConfig实例
        ServiceConfig<GreetingService> serviceConfig = new ServiceConfig<>();
        // 设置应用程序配置
        serviceConfig.setApplication(new ApplicationConfig("first-dubbo-provider"));
        // 设置注册中心
        RegistryConfig registryConfig = new RegistryConfig("zookeeper://127.0.0.1:2181");
        serviceConfig.setRegistry(registryConfig);

        serviceConfig.setInterface(GreetingService.class);
        serviceConfig.setRef(new GreetingServiceImpl());

        serviceConfig.setVersion("1.0");
        serviceConfig.setGroup("dubbo");

        serviceConfig.export();

        System.out.println("server is started");
        System.in.read();

    }
}
