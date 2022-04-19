package com.ohl.MyRPCVersion5.server;

import com.ohl.MyRPCVersion5.register.ServiceRegister;
import com.ohl.MyRPCVersion5.register.ZkServiceRegister;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;


public class ServiceProvider {
    private Map<String, Object> interfaceProvider;
    private ServiceRegister serviceRegister;
    private String host;
    private int port;

    public ServiceProvider(String host, int port)
    {
        //传入服务端自身的服务的网络地址
        this.host = host;
        this.port = port;
        this.interfaceProvider = new HashMap<>();
        this.serviceRegister = new ZkServiceRegister();
    }

    public void provideServiceInterface(Object service)
    {
        Class<?>[] interfaces = service.getClass().getInterfaces();

        for(Class clazz : interfaces)
        {
            //本地映射表
            interfaceProvider.put(clazz.getName(), service);
            //在注册中心注册服务
            serviceRegister.register(clazz.getName(), new InetSocketAddress(host, port));
        }
    }

    public Object getService(String interfaceName)
    {
        return interfaceProvider.get(interfaceName);
    }
}
