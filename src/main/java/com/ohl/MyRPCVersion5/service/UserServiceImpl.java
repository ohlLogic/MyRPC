package com.ohl.MyRPCVersion5.service;

import com.ohl.MyRPCVersion5.common.User;

public class UserServiceImpl implements UserService{
    @Override
    public User getUserByUserId(Integer id) {
        User user = User.builder().id(id).userName("hehe").sex(true).build();
        System.out.println("客户端查询" + id + "用户");
        return user;
    }

    @Override
    public Integer insertUserId(User user) {
        System.out.println("插入数据成功" + user);
        return 1;
    }
}
