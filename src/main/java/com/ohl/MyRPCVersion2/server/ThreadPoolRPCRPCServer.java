package com.ohl.MyRPCVersion2.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池实现
 */
public class ThreadPoolRPCRPCServer implements RPCServer{
    private final ThreadPoolExecutor threadPool;
    private Map<String, Object> serviceProvide;

    public ThreadPoolRPCRPCServer(Map<String, Object> map)
    {
        threadPool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                1000, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));

        this.serviceProvide = map;
    }

    public ThreadPoolRPCRPCServer(Map<String, Object> map, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue){
        threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.serviceProvide = map;
    }

    @Override
    public void start(int port) {
        try {
            System.out.println("服务端启动");
            ServerSocket serverSocket = new ServerSocket(port);
            while(true)
            {
                Socket socket = serverSocket.accept();
                threadPool.execute(new WorkThread(socket, serviceProvide));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {

    }
}
