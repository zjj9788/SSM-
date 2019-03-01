package com.isoft.service;

import com.isoft.pojo.UserInfo;

import java.util.List;
import java.util.Map;

public interface IUserService {
    Map<String,Object> login(String uname, String upwd);
    int register(Map<String, Object> obj);
    int validateOldPwd(int userid,String oldpwd);
    int updateOldPwd(int userid,String newpwd);
    int updateUserPhoto(String userid,String photoPath);
    Map findUserInfoById(String user_id);
    int updateUserInfo(UserInfo userinfo);
    List<Map> userAnalysis();
}
