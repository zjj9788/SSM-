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
        String sql = "com.isoft.mapping.User.login";
        Map map = new HashMap();
        map.put("uname", uname);
        map.put("upwd", upwd);
        Map<String, Object> o = sqlSession.selectOne(sql, map);
        return o;
    }

    @Override
    public int register(Map<String, Object> obj) {
        SqlSession sqlSession = sqlSessionFactoryBean.openSession(true);
        String sql = "com.isoft.mapping.User.register";
        int insert = sqlSession.insert(sql, obj);
        return insert;
    }

    @Override
    public int validateOldPwd(int userid, String oldpwd) {
        SqlSession sqlSession = sqlSessionFactoryBean.openSession(true);
        String sql = "com.isoft.mapping.User.validateOldPwd";
        Map map = new HashMap();
        map.put("userid", userid);
        map.put("oldpwd", oldpwd);
        Map<String, Object> o = sqlSession.selectOne(sql, map);
        if (o == null)
            return 0;//旧密码不正确
        else
            return 1;//旧密码正确
    }

    @Override
    public int updateOldPwd(int userid, String newpwd) {
        SqlSession sqlSession = sqlSessionFactoryBean.openSession(true);
        String sql = "com.isoft.mapping.User.updateOldPwd";
        Map map = new HashMap();
        map.put("userid", userid);
        map.put("newpwd", newpwd);
        int update = sqlSession.update(sql, map);
        return update;
    }

    @Override
    public int updateUserPhoto(String userid, String photoPath) {
        SqlSession sqlSession = sqlSessionFactoryBean.openSession(true);
        String sql = "com.isoft.mapping.User.updateUserPhoto";
        Map map = new HashMap();
        map.put("userid", userid);
        map.put("photopath", photoPath);
        int update = sqlSession.update(sql, map);
        sqlSession.commit();
        return update;
    }
}
