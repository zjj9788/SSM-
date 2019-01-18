package com.isoft.action;

import com.isoft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserAction {
    @Autowired
    IUserService userServiceImpl;
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    @ResponseBody
    public int login(String uname,String upwd){
        Map<String, Object> login = userServiceImpl.login(uname, upwd);
        System.out.println(uname+","+upwd+","+login);
        if(login==null)
            return 0;
        else
            return 1;
    }
    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    @ResponseBody
    public int register(String uname,String upwd,String email){
        Map map=new HashMap();
        map.put("uname",uname);
        map.put("upwd",upwd);
        map.put("email",email);
        int register = userServiceImpl.register(map);
        if(register==0)
            return 0;
        else
            return 1;
    }
}
