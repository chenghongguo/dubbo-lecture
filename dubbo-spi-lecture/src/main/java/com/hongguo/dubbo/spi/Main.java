package com.hongguo.dubbo.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;

public class Main {
    public static void main(String[] args) {
        ProviderService service = ExtensionLoader.getExtensionLoader(ProviderService.class).getDefaultExtension();
        String zhangsan = service.sayHello("zhangsan");
        System.out.println(zhangsan);
    }
}
