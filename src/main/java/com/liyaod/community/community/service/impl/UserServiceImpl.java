package com.liyaod.community.community.service.impl;

import com.liyaod.community.community.model.User;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liyaod
 * @create 2019-10-15  11:09
 */
@Service
public class UserServiceImpl /*implements UserService */{

  //  @Autowired
    //private UserMapper userMapper;


    @Resource
    protected RedisTemplate<String, Object> redisTemplate;

    //@Override
    public void inserUser(User user) {
        /**
         * 插入用户时，需要先判断用户是否存在
         * 如果存在则更新用户信息，
         * 如果不存在则插入用户信息。
         */
        /*User user1 = userMapper.findUserByAccountId(user.getAccountId());
        if (user1 != null) {
            userMapper.updateUser(user);
        } else {
            userMapper.inserUser(user);
        }*/
    }

   // @Override
    public User findOmeByToken(String token) {
        /*return userMapper.findOmeByToken(token);*/
        return null;
    }


}
