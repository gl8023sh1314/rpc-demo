package org.example.provider.impl;

import org.example.provider.api.HelloService;

public class HelloServiceImplV2 implements HelloService {

    @Override
    public String sayHello(String userName) {
        return "Hello v2" + userName;
    }
}
