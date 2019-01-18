package com.isoft.dao;

import java.util.List;
import java.util.Map;

public interface IFileDAO {
    List<Map<String, Object>> fileUserFile(int file_upload_user,int page,int limit);
    int updateFileName(Map map);
    int deleteFileById(List<String> id);
}
