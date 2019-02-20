package com.isoft.service;

import java.util.Map;

public interface IUserService {
    Map<String,Object> login(String uname, String upwd);
    int register(Map<String, Object> obj);
    int validateOldPwd(int userid,String oldpwd);
    int updateOldPwd(int userid,String newpwd);
    int updateUserPhoto(String userid,String photoPath);
}
