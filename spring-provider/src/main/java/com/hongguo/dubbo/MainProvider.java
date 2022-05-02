package com.hongguo.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hongguo_cheng
 * @date 2022/4/16
 */
public class MainProvider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring.xml");
        context.start();
        System.out.println("started------");

        System.in.read();
    }
}
