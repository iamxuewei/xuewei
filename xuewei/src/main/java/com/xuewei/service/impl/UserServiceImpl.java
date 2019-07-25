package com.xuewei.service.impl;

import com.xuewei.mapper.UserMapper;
import com.xuewei.service.UserService;
import com.xuewei.vo.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    public UserMapper userMapper;

    /**
     *  缓存
     * @param userName
     * @return
     */
    @Override
    public User getUserByUserId(String userName) {
        return userMapper.getUserByUserId(userName);
    }

    @Override
    @Cacheable(cacheNames = "user")
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }
}
