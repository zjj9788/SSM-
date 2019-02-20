package com.isoft.action;

import com.alibaba.fastjson.JSON;
import com.isoft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@Scope("prototype")
@RequestMapping("/file")
public class UploadAction {
    @Autowired
    IUserService userServiceImpl;

    @RequestMapping(value = "/uploadPersonPhoto.do", method = RequestMethod.POST)
    @ResponseBody
    public Map uploadPersonPhoto(@RequestParam("file") MultipartFile file, HttpSession session) {
        String userid = session.getAttribute("userid").toString();
        Map map = new HashMap();
        System.out.println("---" + userid);
        try {
            if (file != null) {
                String fileName = file.getOriginalFilename();
                String extName = fileName.substring(fileName.lastIndexOf("."));
                List list = new ArrayList();
                list.add(".jpg");
                list.add(".png");
                list.add(".gif");
                list.add(".bmp");
                list.add(".jpeg");
                if (list.contains(extName.toLowerCase())) {
                    String realPath = session.getServletContext().getRealPath("myphoto");
                    String photoFileName = new Date().getTime() + extName;//使用时间戳进行文件命名
                    String descPath = realPath + "/" + photoFileName;
                    System.out.println(descPath);
                    file.transferTo(new File(realPath, photoFileName));
                    //图片路径和文件名称保存到数据库中   photoFileName()  1550543609976.jpg
                    //根据用户ID更新头像
                    int i = userServiceImpl.updateUserPhoto(userid, "myphoto/"  + photoFileName);
                    System.out.println("upload"+i);
                    if (i > 0) {
                        System.out.println("上传头像成功");
                        map.put("photo","myphoto/" + photoFileName);
                        map.put("code",0);//上传头像成功，数据库存储路径成功
                    } else
                        map.put("code",3);//数据库存储路径不成功
                } else {
                    map.put("code",2);//文件类型错误
                }
            } else {
                map.put("code",4);//上传文件为空
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",1);// 上传异常
        }
       // System.out.println(JSON.toJSONString(map));
        return map;

    }
}
