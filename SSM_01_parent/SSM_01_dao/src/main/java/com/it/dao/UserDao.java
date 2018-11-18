package com.it.dao;

import com.it.bean.UserBean;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<UserBean> findAll();

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    public UserBean findById(int id);

    /**
     * 根据用户名模糊查询，根据性别精确匹配
     * @return
     */
    public List<UserBean> findBySexLikeUsername(UserBean userBean);

    /**
     * 添加用户
     * @param userBean
     */
    public void add(UserBean userBean);

    /**
     * 查询用户信息，用户信息中包含账户信息
     * @return
     */
    public UserBean findByIdWithAccount(Integer id);
}
