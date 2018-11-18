package com.it.service;

import com.it.bean.UserBean;

import java.util.List;

public interface UserService  {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<UserBean> findAll();

    /**
     *  根据id查询用户信息
     * @param id
     * @return
     */
    public UserBean findById(Integer id);


    /**
     * 根据用户名称进行模糊查询 ,根据姓名进行精确匹配
     * @return
     */
    public List<UserBean> findBySexLikeUsername(UserBean user);

    /**
     * 添加用户 返回生成的主键
     * @param user
     */
    public void add(UserBean user);

    /**
     * 查询用户信息,用户信息中包含账户信息
     * @return
     */
    public UserBean findByIdWithAccount(Integer id);
}
