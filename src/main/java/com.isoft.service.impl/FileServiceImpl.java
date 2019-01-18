package com.isoft.service.impl;

import com.isoft.dao.IFileDAO;
import com.isoft.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class FileServiceImpl implements IFileService {
    @Autowired
    IFileDAO fileDAOImpl;
    @Override
    public List<Map<String, Object>> fileUserFile(int file_upload_user,int page,int limit) {
        return fileDAOImpl.fileUserFile(file_upload_user,page,limit);
    }

    @Override
    public int updateFileName(Map map) {
        return fileDAOImpl.updateFileName(map);
    }

    @Override
    public int deleteFileById(List<String> list) {
        return fileDAOImpl.deleteFileById(list);
    }
}
