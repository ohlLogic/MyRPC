package com.ohl.MyRPCVersion3.server;


import com.ohl.MyRPCVersion3.service.BlogService;
import com.ohl.MyRPCVersion3.service.BlogServiceImpl;
import com.ohl.MyRPCVersion3.service.UserService;
import com.ohl.MyRPCVersion3.service.UserServiceImpl;

/**
 * 多个服务的实现类
 */
public class TestServer {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();

//        //暴露两个接口，添加一个HashMap
//        Map<String, Object> map = new HashMap<>();
//        map.put("com.ohl.MyRPCVersion2.service.UserService", userService);
//        map.put("com.ohl.MyRPCVersion2.service.BlogService", blogService);

        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer rpcServer = new SimpleRPCServer(serviceProvider);
        rpcServer.start(8899);
    }


}
