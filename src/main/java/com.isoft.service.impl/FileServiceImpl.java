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
    public List<Map<String, Object>> fileUserFile(Map map) {
        return fileDAOImpl.fileUserFile(map);
    }

    @Override
    public int updateFileName(Map map) {
        return fileDAOImpl.updateFileName(map);
    }

    @Override
    public int deleteFileById(List<String> list) {
        return fileDAOImpl.deleteFileById(list);
    }

    @Override
    public int updateFileStatus(Map map) {
        return fileDAOImpl.updateFileStatus(map);
    }

    @Override
    public int updateDownloadCount(int file_id) {
        return fileDAOImpl.updateDownloadCount(file_id);
    }

    @Override
    public int insertUploadFileInfo(Map map) {
        return fileDAOImpl.insertUploadFileInfo(map);
    }
}
