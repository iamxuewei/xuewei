package com.xuewei.service;

import com.xuewei.vo.User;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


public interface UserService {
    public User getUserByUserId(String userName);
    public List<User> getAllUser();

}
