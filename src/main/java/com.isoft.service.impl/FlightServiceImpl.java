package com.isoft.service.impl;

import com.isoft.dao.IFlightDAO;
import com.isoft.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service("flightService")
public class FlightServiceImpl implements IFlightService {
    @Autowired
    IFlightDAO flightInfoDAOImpl;
    @Override
    public List<Map<String, String>> findAllFlight() {
     //   System.out.println("Service Test ok");
        List<Map<String, String>> allFlightInfo = flightInfoDAOImpl.findAllFlightInfo();
      //  System.out.println(allFlightInfo);
        return allFlightInfo;
    }

    @Override
    public Map<String, String> findFlightId(int id) {
        Map<String, String> flightId = flightInfoDAOImpl.findFlightId(id);
        return flightId;
    }
}
