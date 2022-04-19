package com.ohl.MyRPCVersion4.service;

import com.ohl.MyRPCVersion4.common.User;

public interface UserService {
    User getUserByUserId(Integer id);

    Integer insertUserId(User user);
}
