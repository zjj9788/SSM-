package com.isoft.action;

import com.alibaba.fastjson.JSON;
import com.isoft.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@Scope("prototype")
@RequestMapping("/file")
public class FileAction {
    @Autowired
    IFileService fileServiceImpl;

    @RequestMapping(value = "findUserFile.do", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findUserFile(int file_upload_user,int page,int limit) {//根据用户信息查询
        System.out.println(page+","+limit);
        List<Map<String, Object>> maps = fileServiceImpl.fileUserFile(file_upload_user,page,limit);
       int count= Integer.parseInt(maps.get(maps.size() - 1).get("count").toString());
       maps.remove(maps.size()-1);
        Map map = new HashMap();
        map.put("count", count);
        map.put("data", maps);
        if (maps != null)
            map.put("msg", "查询成功");
        else
            map.put("msg", "还没有上传文件");
        map.put("code", 0);

        return map;
    }
    @RequestMapping(value = "/updateFileName.do", method = RequestMethod.GET)
    @ResponseBody
    public int updateFileName(String obj){
        Map map= (Map) JSON.parse(obj);
        System.out.println(map+"---");
        int i = fileServiceImpl.updateFileName(map);
        return i;
    }
    @RequestMapping(value = "/deleteFileById.do", method = RequestMethod.POST)
    @ResponseBody
    public int deleteFileById(String file_id){
        String[] split = file_id.substring(1, file_id.length() - 1).split(",");
        List<String> strings = Arrays.asList(split);//把数组转化成List
        System.out.println(strings);
        for (String str:strings) {
            System.out.println(str+"-----");
        }
       // Map map= (Map) JSON.parse(file_id);
        int i = fileServiceImpl.deleteFileById(strings);
        System.out.println(i+"----");
        return i;
    }
}
