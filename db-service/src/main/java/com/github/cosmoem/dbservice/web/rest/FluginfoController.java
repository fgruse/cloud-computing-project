package com.github.cosmoem.dbservice.web.rest;

import com.github.cosmoem.dbservice.jpa.entity.Fluginfo;
import com.github.cosmoem.dbservice.service.FluginfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class FluginfoController {

    private final FluginfoService fluginfoService;

    public FluginfoController(final FluginfoService fluginfoService) {this.fluginfoService = fluginfoService;}

    @GetMapping("/flug/{flugnummer}")
    public ResponseEntity<Fluginfo> getFlugstatus(@PathVariable(name = "flugnummer") String flugnummer) {
        return ResponseEntity.ok(fluginfoService.getFluginfo(flugnummer));
    }
}
