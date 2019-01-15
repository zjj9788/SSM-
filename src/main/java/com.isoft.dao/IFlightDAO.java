package com.isoft.dao;

import java.util.List;
import java.util.Map;

public interface IFlightDAO {
    List<Map<String,String>> findAllFlightInfo();
    Map<String,String> findFlightId(int id);
}
