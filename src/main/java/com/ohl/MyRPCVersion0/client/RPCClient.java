package com.ohl.MyRPCVersion0.client;

import com.ohl.MyRPCVersion0.common.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class RPCClient {
    public static void main(String[] args){
        try {
            //建立Socket连接

            //客户端实例化一个Socket对象，指定服务器IP和端口号
            Socket socket = new Socket("127.0.0.1", 8899);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            //传给服务器id
            objectOutputStream.writeInt(new Random().nextInt());
            objectOutputStream.flush();

            //服务器查询id，返回对应的对象
            User user = (User) objectInputStream.readObject();
            System.out.println("服务端返回的User：" + user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("客户端启动失败");
        }
    }
}
