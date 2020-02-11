package com.github.cosmoem.dbservice.web.rest;

import com.github.cosmoem.dbservice.jpa.entity.Flugstatus;
import com.github.cosmoem.dbservice.service.FlugstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class FlugstatusController {

    @Autowired
    private FlugstatusService flugstatusService;

    @RequestMapping("/flug")
    public Iterable<Flugstatus> getAll() {
        return flugstatusService.getAll();
    }

    @RequestMapping("/flug/{flugnummer}")
    public Flugstatus getFlugstatus(@PathVariable(name = "flugnummer") String flugnummer) {
        return flugstatusService.getFlugstatus(flugnummer);
    }
}
