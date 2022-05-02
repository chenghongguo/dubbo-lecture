package com.hongguo.dubbo.provider;

import com.hongguo.dubbo.domain.Pojo;
import com.hongguo.dubbo.domain.Result;

/**
 * @author hongguo_cheng
 * @date 2022/4/5
 */
public interface GreetingService {
    String sayHello(String name);

    Result<String> testGeneric(Pojo pojo);
}
