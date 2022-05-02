package com.hongguo.dubbo.provider;

import com.hongguo.dubbo.domain.Pojo;
import com.hongguo.dubbo.domain.Result;

/**
 * @author hongguo_cheng
 * @date 2022/4/16
 */
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHello(String name) {
        System.out.println("sayHello --- 1 -----");
        return "hello " + name;
    }

    @Override
    public Result<String> testGeneric(Pojo pojo) {
        Result<String> result = new Result<>();
        result.setData("hello");
        result.setSuccess(true);
        result.setMsg("ok");
        return result;
    }
}
