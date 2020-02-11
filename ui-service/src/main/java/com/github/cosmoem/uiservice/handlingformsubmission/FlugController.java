package com.github.cosmoem.uiservice.handlingformsubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FlugController {

    @GetMapping("/flug")
    public String flugForm(Model model) {
        model.addAttribute("flug", new Flug());
        return "flug";
    }

    @PostMapping("/flug")
    public String flugSubmit(@ModelAttribute Flug flug) {
        return "result";
    }

}