package com.hongguo.spi.impl;

import com.hongguo.spi.ProviderService;

public class ProviderServiceImpl implements ProviderService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
