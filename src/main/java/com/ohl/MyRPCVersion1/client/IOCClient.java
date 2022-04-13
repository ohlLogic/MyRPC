package com.ohl.MyRPCVersion1.client;

import com.ohl.MyRPCVersion1.common.RPCRequest;
import com.ohl.MyRPCVersion1.common.RPCResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//底层通信
public class IOCClient {
    /**
     * 负责底层与服务端的通信，发送Request，接口Response
     * 上层对request进行封装，不同的service需要进行不同的封装，客户端只知道Service接口，需要一层动态代理
     * 根据反射封装不同的Service
     */

    public static RPCResponse sendRequest(String host, int port, RPCRequest request) {
        try {
            Socket socket = new Socket(host, port);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            System.out.println(request);
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

            RPCResponse response = (RPCResponse) objectInputStream.readObject();
            return response;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
