package com.isoft.service;

import java.util.List;
import java.util.Map;

public interface IFlightService {
    List<Map<String,String>> findAllFlight();
    Map<String,String> findFlightId(int id);
}
