package com.github.cosmoem.uiservice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

    @RequestMapping(value= {"/home"}, method=RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/home");
        return model;
    }

    @RequestMapping(value= {"/flugstatus"}, method=RequestMethod.GET)
    public ModelAndView flugstatus() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/flugstatus");
        return model;
    }
}