package com.isoft.service;

import java.util.Map;

public interface IUserService {
    Map<String,Object> login(String uname, String upwd);
    int register(Map<String, Object> obj);
}
