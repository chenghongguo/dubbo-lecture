package com.test.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author hongguo_cheng
 * @date 2022/4/12
 */
@SPI("impl")
public interface PrintService {
    void printInfo();
}
