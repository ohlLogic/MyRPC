package com.ohl.MyRPCVersion2.service;

import com.ohl.MyRPCVersion2.common.User;

public interface UserService {
    User getUserByUserId(Integer id);

    Integer insertUserId(User user);
}
