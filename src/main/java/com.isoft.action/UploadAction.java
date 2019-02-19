package com.isoft.action;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Scope("prototype")
@RequestMapping("/file")
public class UploadAction {
    @RequestMapping(value = "/uploadPersonPhoto.do", method = RequestMethod.POST)
    @ResponseBody
    public int uploadPersonPhoto(@RequestParam("file") MultipartFile file, HttpSession session) {
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
                    return 3;//上传头像成功
                } else {
                    return 2;//文件类型错误
                }
            } else {
                return 0;//上传文件为空
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 1;// 上传异常
        }


    }
}
