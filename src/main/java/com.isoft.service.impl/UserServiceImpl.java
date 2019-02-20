package com.isoft.service.impl;

import com.isoft.dao.IUserDAO;
import com.isoft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDAO userDAO;
    @Override
    public Map<String, Object> login(String uname, String upwd) {
        Map<String, Object> login = userDAO.login(uname, upwd);
        return login;
    }

    @Override
    public int register(Map<String, Object> obj) {
        int register = userDAO.register(obj);
        return register;
    }

    @Override
    public int validateOldPwd(int userid, String oldpwd) {
        int validate=userDAO.validateOldPwd(userid,oldpwd);
        return validate;
    }

    @Override
    public int updateOldPwd(int userid, String newpwd) {
        int i = userDAO.updateOldPwd(userid, newpwd);
        return i;
    }

    @Override
    public int updateUserPhoto(String userid, String photoPath) {
        int i = userDAO.updateUserPhoto(userid, photoPath);
        return i;
    }
}
