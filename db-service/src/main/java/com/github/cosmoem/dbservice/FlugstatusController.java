package com.github.cosmoem.dbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlugstatusController {

    @Autowired
    private FlugstatusService flugstatusService;

    @RequestMapping("/flug/{flugnummer}")
    public Flugstatus getFlugstatus(String flugnummer) {
        return flugstatusService.getFlugstatus(flugnummer);
    }

}
