package com.ohl.MyRPCVersion3.client;

import com.ohl.MyRPCVersion3.common.RPCRequest;
import com.ohl.MyRPCVersion3.common.RPCResponse;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@AllArgsConstructor
public class RPCClientProxy implements InvocationHandler {
    private RPCClient client;

    //jdk动态代理
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RPCRequest request = RPCRequest.builder().interfaceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .params(args).paramsTypes(method.getParameterTypes()).build();

        //数据传输
        RPCResponse response = client.sendRequest(request);
        return response.getData();
    }

    <T> T getProxy(Class<T> clazz)
    {
       Object o =  Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
        return (T) o;
    }
}
