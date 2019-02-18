package com.isoft.dao;

import java.util.Map;

public interface IUserDAO {
    Map<String, Object> login(String uname, String upwd);

    int register(Map<String, Object> obj);

    public int validateOldPwd(int userid, String oldpwd);
    public int updateOldPwd(int userid, String newpwd);
}
