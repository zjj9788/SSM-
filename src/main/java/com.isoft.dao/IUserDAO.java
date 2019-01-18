package com.isoft.dao;

import java.util.Map;

public interface IUserDAO {
    Map<String, Object> login(String uname, String upwd);

    int register(Map<String, Object> obj);
}
