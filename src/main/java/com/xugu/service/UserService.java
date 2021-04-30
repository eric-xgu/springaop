package com.xugu.service;


import com.xugu.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserDao userDao;
    public void test(){
        System.out.println("user service");
        userDao.test();
    }
}
