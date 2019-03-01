package com.isoft.service;

import java.util.List;
import java.util.Map;

public interface IFileService {
    List<Map<String, Object>> fileUserFile(Map map);

    int updateFileName(Map map);

    int deleteFileById(List<String> list);

    int updateFileStatus(Map map);

    int updateDownloadCount(int file_id);

    int insertUploadFileInfo(Map map);

}
