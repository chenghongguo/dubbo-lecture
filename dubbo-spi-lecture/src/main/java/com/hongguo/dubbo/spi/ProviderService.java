package com.hongguo.dubbo.spi;

import org.apache.dubbo.common.extension.SPI;

@SPI("impl")
public interface ProviderService {

    String sayHello(String name);
}
