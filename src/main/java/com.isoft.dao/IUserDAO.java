package com.isoft.dao;

import com.isoft.pojo.UserInfo;

import java.util.List;
import java.util.Map;

public interface IUserDAO {
    Map<String, Object> login(String uname, String upwd);

    int register(Map<String, Object> obj);

    public int validateOldPwd(int userid, String oldpwd);
    public int updateOldPwd(int userid, String newpwd);
    public int updateUserPhoto(String userid,String photoPath);
    Map findUserInfoById(String user_id);
    int updateUserInfo(UserInfo userinfo);
    List<Map> userAnalysis();
}
