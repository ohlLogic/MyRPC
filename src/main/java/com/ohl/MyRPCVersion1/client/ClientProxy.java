package com.ohl.MyRPCVersion1.client;

import com.ohl.MyRPCVersion1.common.RPCRequest;
import com.ohl.MyRPCVersion1.common.RPCResponse;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import java.lang.reflect.Proxy;

/**
 * 动态代理封装request对象
 */
@AllArgsConstructor
public class ClientProxy implements InvocationHandler {
    //传入参数Service接口的class对象，反射封装成一个request
    private String host;
    private int port;

    //jdk动态代理， 每一次代理对象调用方法，会经过此方法增强（反射获取request，socket发送至客户端）
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //request构建
        RPCRequest request = RPCRequest.builder().interfaceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .params(args).paramTypes(method.getParameterTypes()).build();

        //数据传输
        RPCResponse response = IOCClient.sendRequest(host, port, request);
        return response.getData();
    }

    <T> T getProxy(Class<T> clazz)
    {
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
        return (T) o;
    }
}
