package com.isoft.dao;

import java.util.List;
import java.util.Map;

public interface IFileDAO {
    List<Map<String, Object>> fileUserFile(Map map);
    int updateFileName(Map map);
    int deleteFileById(List<String> id);
    int updateFileStatus(Map map);
    int updateDownloadCount(int file_id);
    int insertUploadFileInfo(Map map);
}
