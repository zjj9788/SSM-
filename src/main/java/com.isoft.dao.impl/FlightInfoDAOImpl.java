package com.isoft.dao.impl;

import com.isoft.dao.IFlightDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class FlightInfoDAOImpl implements IFlightDAO {
    @Autowired
    SqlSessionFactory sqlSessionFactoryBean;
    @Override
    public List<Map<String, String>> findAllFlightInfo() {
        SqlSession sqlSession = sqlSessionFactoryBean.openSession(true);
        String sql="com.isoft.mapping.FlightInfo.findAllFilghtInfo";
        List<Map<String,String>> objects = sqlSession.selectList(sql);
       // System.out.println("dao test ok");
        return objects;
    }

    @Override
    public Map<String, String> findFlightId(int id) {
        SqlSession sqlSession = sqlSessionFactoryBean.openSession(true);
        String sql="com.isoft.mapping.FlightInfo.findFlightInfoById";
       Map<String,String> objects = sqlSession.selectOne(sql,id);
        return objects;
    }
}
