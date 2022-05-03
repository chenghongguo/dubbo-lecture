package com.hongguo.spi;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<ProviderService> services = ServiceLoader.load(ProviderService.class);
        services.forEach(service -> System.out.println(service.sayHello("hello")));
    }
}
