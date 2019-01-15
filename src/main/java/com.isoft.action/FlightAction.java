package com.isoft.action;

import com.isoft.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/flight")
public class FlightAction {
    @Autowired
    IFlightService flightService;
    @RequestMapping(value = "/findAllFilght.do", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, String>> findAllFilght() {
      //  System.out.println("control test ok");
        List<Map<String, String>> allFlight = flightService.findAllFlight();
        //System.out.println("action="+allFlight);
        return allFlight;
    }
    @RequestMapping(value = "/findFilghtByID.do", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> findFilghtByID(int id) {
        //  System.out.println("control test ok");
       Map<String, String> allFlight = flightService.findFlightId(id);
        //System.out.println("action="+allFlight);
        return allFlight;
    }
}
