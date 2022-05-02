package com.hongguo.provider.impl;

import com.alibaba.fastjson.JSON;
import com.hongguo.dubbo.domain.Pojo;
import com.hongguo.dubbo.domain.Result;
import com.hongguo.dubbo.provider.GreetingService;
import org.apache.dubbo.rpc.RpcContext;

/**
 * @author hongguo_cheng
 * @date 2022/4/5
 */
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHello(String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Hello " + name + " " + RpcContext.getContext().getAttachment("company");
    }

    @Override
    public Result<String> testGeneric(Pojo pojo) {
        Result<String> result = new Result<>();
        result.setSuccess(true);
        result.setData(JSON.toJSONString(pojo));
        return result;
    }
}
