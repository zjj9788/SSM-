package com.isoft.service;

import java.util.List;
import java.util.Map;

public interface IFileService {
    List<Map<String, Object>> fileUserFile(int file_upload_user, int page, int limit);

    int updateFileName(Map map);

    int deleteFileById(List<String> list);
}
