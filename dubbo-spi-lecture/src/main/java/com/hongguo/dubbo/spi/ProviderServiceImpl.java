package com.hongguo.dubbo.spi;

public class ProviderServiceImpl implements ProviderService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
