package com.ohl.MyRPCVersion3.service;

import com.ohl.MyRPCVersion3.common.User;

public interface UserService {
    User getUserByUserId(Integer id);

    Integer insertUserId(User user);
}
