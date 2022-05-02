package com.test.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @author hongguo_cheng
 * @date 2022/4/12
 */
public class Main {
    public static void main(String[] args) {
        PrintService printService =
                ExtensionLoader.getExtensionLoader(PrintService.class)
                        .getDefaultExtension();
        printService.printInfo();
    }
}
