package com.isoft.action;

import com.alibaba.fastjson.JSON;
import com.isoft.pojo.UserInfo;
import com.isoft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@Scope("singleton")
@RequestMapping("/user")
public class UserAction {
    @Autowired
    IUserService userServiceImpl;

    @RequestMapping(value = "/userAnalysis.do", method = RequestMethod.GET)
    @ResponseBody
    public Map userAnalysis() {
        List<Map> list = userServiceImpl.userAnalysis();
        List<String> statusList = new ArrayList<String>();
        List<Integer> countList = new ArrayList<Integer>();
        for (Map map : list) {
            //[{"aaa":32,'count':43},{"bb":43,'count':54}]
            statusList.add(map.get("status").toString());
            countList.add(Integer.parseInt(map.get("count").toString()));
        }
        Map map = new HashMap();
        map.put("status", statusList);
        map.put("count", countList);
        return map;
    }

    @RequestMapping(value = "/findUserInfoById.do", method = RequestMethod.GET)
    @ResponseBody
    public Map findUserInfoById(@RequestParam("userid") String user_id) {
        Map userInfo = userServiceImpl.findUserInfoById(user_id);
        return userInfo;
    }

    @RequestMapping(value = "/updateOldUpwd.do", method = RequestMethod.POST)
    @ResponseBody
    public int updateOldUpwd(int userid, String oldpwd, String newpwd) {
        int validate = userServiceImpl.validateOldPwd(userid, oldpwd);
        if (validate == 0) {
            return -1;
        } else {
            int i = userServiceImpl.updateOldPwd(userid, newpwd);
            return i;
        }

    }

    @RequestMapping(value = "/updateInfo.do", method = RequestMethod.POST)
    @ResponseBody
    public int updateUserInfo(UserInfo userinfo) {
        int i = userServiceImpl.updateUserInfo(userinfo);
        return i;
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public Map login(String uname, String upwd, HttpSession session) {

        Map<String, Object> login = userServiceImpl.login(uname, upwd);
        HashMap map = new HashMap();
        if (login == null) {
            map.put("loginmsg", 0);
            return map;
        } else {
            map.put("loginmsg", 1);
            map.put("status", login.get("status").toString());
            map.put("userid", login.get("user_id").toString());
            session.setAttribute("userid", login.get("user_id").toString());
            if (login.get("photo") != null)
                map.put("photo", login.get("photo").toString());
            else
                map.put("photo", "myphoto/myphoto.jpg");

            return map;
        }
    }

    /*    @RequestMapping(value = "/findUserIdByUname.do",method = RequestMethod.POST)
        @ResponseBody
        public int login(String uname){
            Map<String, Object> login = userServiceImpl.login(uname, upwd);
            System.out.println(uname+","+upwd+","+login);
            if(login==null)
                return 0;
            else
                return 1;
        }*/
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    @ResponseBody
    public int register(String uname, String upwd, String email) {
        Map map = new HashMap();
        map.put("uname", uname);
        map.put("upwd", upwd);
        map.put("email", email);
        int register = userServiceImpl.register(map);
        if (register == 0)
            return 0;
        else
            return 1;
    }

    @RequestMapping(value = "/toLogin.do")
    @ResponseBody
    public String forwardLogin(HttpServletResponse response) {
        StringBuilder builder = new StringBuilder();
        builder.append("<script type='text/javascript' charset='UTF-8'>");
        builder.append("alert('您还未登录，请先登录.');");
        builder.append("window.top.location.href='");
        builder.append("/login.html'</script>");

        return builder.toString();
    }
}
