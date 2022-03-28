package com.ohl.MyRPCVersion0.server;

import com.ohl.MyRPCVersion0.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RPCServer {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        try {
            ServerSocket serverSocket = new ServerSocket(8899);
            System.out.println("服务端启动");

            //BIO（阻塞式编程）方式监听Socket
            while (true) {
                Socket socket = serverSocket.accept();
                //开启线程去处理
                new Thread(() -> {
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                        //读取客户端传过来的id
                        Integer id = ois.readInt();
                        User user = userService.getUserByUserId(id);
                        //写入User对象给客户端
                        oos.writeObject(user);
                        oos.flush();
                        System.out.println("服务端回传成功");
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("IO读取失败");
                    }
                }).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }
    }
}
