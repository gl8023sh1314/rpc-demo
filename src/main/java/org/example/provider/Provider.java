package org.example.provider;

import org.example.framework.protocol.http.HttpServer;
import org.example.framework.register.LocalRegister;
import org.example.provider.api.HelloService;
import org.example.provider.impl.HelloServiceImpl;

public class Provider {

    public static void main(String[] args) {

        //启动  通过网络接收请求
        //Tomcat Netty Jetty SocketServer

        //本地注册
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);

        //启动Tomcat
        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8082);


    }
}
