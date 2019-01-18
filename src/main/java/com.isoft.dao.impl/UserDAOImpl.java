package com.isoft.dao.impl;

import com.isoft.dao.IUserDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository("userDAO")
public class UserDAOImpl implements IUserDAO {
    @Autowired
    SqlSessionFactory sqlSessionFactoryBean;
    @Override
    public Map<String, Object> login(String uname, String upwd) {
        SqlSession sqlSession = sqlSessionFactoryBean.openSession(true);
        String sql="com.isoft.mapping.User.login";
        Map map=new HashMap();
        map.put("uname",uname);
        map.put("upwd",upwd);
        Map<String, Object> o = sqlSession.selectOne(sql, map);
        return o;
    }

    @Override
    public int register(Map<String, Object> obj) {
        SqlSession sqlSession = sqlSessionFactoryBean.openSession(true);
        String sql="com.isoft.mapping.User.register";
        int insert = sqlSession.insert(sql, obj);
        return insert;
    }
}
