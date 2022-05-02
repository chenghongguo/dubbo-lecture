package com.test.spi;

/**
 * @author hongguo_cheng
 * @date 2022/4/12
 */
public class PrintServiceImpl implements PrintService {
    @Override
    public void printInfo() {
        System.out.println("hello world");
    }
}
