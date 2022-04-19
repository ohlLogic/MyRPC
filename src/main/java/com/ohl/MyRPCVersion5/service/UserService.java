package com.ohl.MyRPCVersion5.service;

import com.ohl.MyRPCVersion5.common.User;

public interface UserService {
    User getUserByUserId(Integer id);

    Integer insertUserId(User user);

}
