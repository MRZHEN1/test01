package com.it.service.impl;

import com.it.bean.UserBean;
import com.it.dao.UserDao;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao ;

    @Override
    public List<UserBean> findAll() {
        return userDao.findAll();
    }

    @Override
    public UserBean findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<UserBean> findBySexLikeUsername(UserBean user) {
        return userDao.findBySexLikeUsername(user);
    }

    @Override
    public void add(UserBean user) {
        userDao.add(user);
    }

    @Override
    public UserBean findByIdWithAccount(Integer id) {
        return userDao.findByIdWithAccount(id);
    }

}
