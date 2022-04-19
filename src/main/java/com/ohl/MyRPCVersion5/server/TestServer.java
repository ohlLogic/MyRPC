package com.ohl.MyRPCVersion5.server;

import com.ohl.MyRPCVersion5.service.BlogService;
import com.ohl.MyRPCVersion5.service.BlogServiceImpl;
import com.ohl.MyRPCVersion5.service.UserService;
import com.ohl.MyRPCVersion5.service.UserServiceImpl;

public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();
        // 这里重用了服务暴露类，顺便在注册中心注册，实际上应分开，每个类做各自独立的事
        ServiceProvider serviceProvider = new ServiceProvider("127.0.0.1", 8899);
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);

        RPCServer RPCServer = new NettyRPCServer(serviceProvider);
        RPCServer.start(8899);
    }
}
