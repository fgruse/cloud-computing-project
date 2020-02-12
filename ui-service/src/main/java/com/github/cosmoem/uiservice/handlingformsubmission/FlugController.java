package com.github.cosmoem.uiservice.handlingformsubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FlugController {

    private final RemoteServiceHandler handler;

    public FlugController(final RemoteServiceHandler handler) {
        this.handler = handler;
    }

    @GetMapping("/flug")
    public String flugForm(Model model) {
        model.addAttribute("flug", new Flug());
        return "flug";
    }

    @PostMapping("/flug")
    public String flugSubmit(@ModelAttribute Flug flug) {
        Flug res = handler.getFluginfo(flug.getFlugnummer());
        String status = handler.getFlugstatus(flug.getFlugnummer());
        if (res.getFlugnummer() != null) {
            if (res.getAirline() != null) {
                flug.setAirline(res.getAirline());
                flug.setFlugdatum(res.getFlugdatum());
                flug.setNach(res.getNach());
                flug.setVon(res.getVon());
                flug.setUhrzeit(res.getUhrzeit());
                flug.setFlugstatus(status.replaceAll("^\"|\"$", ""));
                return "result";
            } else {
                return "failure";
            }
        }
        else {
            return "error";
        }
    }
}