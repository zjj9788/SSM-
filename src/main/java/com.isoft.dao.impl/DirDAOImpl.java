package com.isoft.dao.impl;

import com.isoft.dao.IDirDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository("iDirDAO")
public class DirDAOImpl implements IDirDAO {
    @Autowired
    SqlSessionFactory sqlSessionFactoryBean;
    @Override
    public List<Map> findAllDirByUserId(String user_id) {
        SqlSession sqlSession = sqlSessionFactoryBean.openSession(true);
        String sql="com.isoft.mapping.Dir.findAllDir";
        List<Map> objects = sqlSession.selectList(sql, user_id);
        return objects;
    }

    @Override
    public List<Map> dirAnalysis(String user_id) {
        SqlSession sqlSession = sqlSessionFactoryBean.openSession(true);
        String sql="com.isoft.mapping.Dir.dirAnalysis";
        List<Map> objects = sqlSession.selectList(sql, user_id);
        return objects;
    }

    @Override
    public Map findFilePathByDirId(String dir_id) {
        SqlSession sqlSession = sqlSessionFactoryBean.openSession(true);
        String sql="com.isoft.mapping.Dir.findFilePathByDirId";
        Map objects = sqlSession.selectOne(sql,dir_id);
      //  System.out.println(dir_id+"test"+objects);
        return objects;
    }
}
