package org.example.framework.protocol.http;

import org.apache.commons.io.IOUtils;
import org.example.framework.Invocation;
import org.example.framework.register.LocalRegister;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) {

        //处理请求逻辑
        try {
            Invocation invocation = (Invocation) new ObjectInputStream(req.getInputStream()).readObject();

            String interfaceName = invocation.getInterfaceName();

            Class classImpl = LocalRegister.get(interfaceName);

            Method method = classImpl.getMethod(invocation.getMethodName(), invocation.getParamType());

            String result = (String )method.invoke(classImpl.newInstance(), invocation.getParams());

            IOUtils.write(result, resp.getOutputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }

    }
}
