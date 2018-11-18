package com.it.dao;

import com.it.bean.UserBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {
    private InputStream is;
    private SqlSession openSession;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        //读取配置文件
        //is = UserDaoTest.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //SqlSessionFactoryBuilder 获取构建者对象
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();

        //构建工厂
        SqlSessionFactory sqlSessionFactory = factoryBuilder.build(is);

        //获取工厂对象
        openSession = sqlSessionFactory.openSession();

        //获取代理对象
        userDao = openSession.getMapper(UserDao.class);
    }

    @After
    public void destroy() throws IOException {
        //释放资源
        openSession.commit();
        openSession.close();
        is.close();
    }

    /**
     *  查询所有用户
     */
    @Test
    public void findAll() {
        List<UserBean> all = userDao.findAll();
        for (UserBean userBean : all) {
            System.out.println("userBean = " + userBean);
        }
    }

}