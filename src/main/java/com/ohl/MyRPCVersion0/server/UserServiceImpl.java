package com.ohl.MyRPCVersion0.server;

import com.ohl.MyRPCVersion0.common.User;
import com.ohl.MyRPCVersion0.service.UserService;

import java.util.Random;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    @Override
    public User getUserByUserId(Integer id) {
        System.out.println("客户端查询" + id + "用户");

        //模拟从数据库中取用户
        Random random = new Random();
        User user = User.builder().userName(UUID.randomUUID().toString())
                .id(id)
                .sex(random.nextBoolean()).build();
        return user;
    }
}
