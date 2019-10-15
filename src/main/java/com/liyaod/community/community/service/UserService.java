package com.liyaod.community.community.service;

import com.liyaod.community.community.model.User;

/**
 * @author liyaod
 * @create 2019-10-15  11:08
 */
public interface UserService {
    /**
     * 插入用户信息
     * @param user
     */
    void inserUser(User user);

    User findOmeByToken(String token);
}
