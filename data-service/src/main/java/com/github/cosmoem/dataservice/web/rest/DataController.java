package com.github.cosmoem.dataservice.web.rest;

import com.github.cosmoem.dataservice.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class DataController {

    @Autowired
    StatusService statusService;

    @RequestMapping("/status/{flugnummer}")
    public StatusService.status status(@PathVariable(name = "flugnummer") String flugnummer) {
        return statusService.getStatus();
    }
}
