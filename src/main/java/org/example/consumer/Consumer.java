package org.example.consumer;

import org.example.framework.ProxyFactory;
import org.example.provider.api.HelloService;

public class Consumer {

    public static void main(String[] args) {

        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String result = helloService.sayHello("lei123");
        System.out.println(result);
    }
}
