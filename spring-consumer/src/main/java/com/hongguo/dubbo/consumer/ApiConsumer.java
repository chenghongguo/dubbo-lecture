package com.hongguo.dubbo.consumer;

import com.hongguo.dubbo.provider.GreetingService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hongguo_cheng
 * @date 2022/4/16
 */
public class ApiConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring.xml");

        GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
        String world = greetingService.sayHello("world");
        System.out.println(world);
    }
}
