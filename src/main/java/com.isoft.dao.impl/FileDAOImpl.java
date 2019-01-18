package com.isoft.dao.impl;

import com.isoft.dao.IFileDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FileDAOImpl implements IFileDAO {
    @Autowired
    SqlSessionFactory sqlSessionFactoryBean;

    @Override
    public List<Map<String, Object>> fileUserFile(int file_upload_user, int page, int limit) {
        SqlSession sqlSession = sqlSessionFactoryBean.openSession();
        String sql = "com.isoft.mapping.File.findUseFile";
        String sql_count = "com.isoft.mapping.File.findRSCount";
        Map map = new HashMap();
        map.put("file_upload_user", file_upload_user);
        map.put("page", (page - 1) * limit);
        map.put("limit", limit);
        List<Map<String, Object>> objects = sqlSession.selectList(sql, map);
        Map<String, Object> rscount = sqlSession.selectOne(sql_count, map);
        objects.add(rscount);
        return objects;
    }

    @Override
    public int updateFileName(Map map) {
        SqlSession sqlSession = sqlSessionFactoryBean.openSession(true);
        String sql = "com.isoft.mapping.File.updateFileName";
        int i = sqlSession.update(sql, map);
        sqlSession.commit(true);
        return i;
    }

    @Override
    public int deleteFileById(List<String> list) {
        SqlSession sqlSession = sqlSessionFactoryBean.openSession(true);
        String sql = "com.isoft.mapping.File.deleteFileById";
        Map map = new HashMap();
        int i = 0;
        for (String str : list) {
            map.put("file_id", str);
            i = sqlSession.update(sql, map);
            sqlSession.commit(true);
        }

        return i;
    }
}
