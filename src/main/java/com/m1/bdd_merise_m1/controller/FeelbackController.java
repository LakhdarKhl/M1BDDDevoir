package com.m1.bdd_merise_m1.controller;

import com.m1.bdd_merise_m1.dto.StatsDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class FeelbackController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        StatsDTO stats = new StatsDTO();
        stats.setAnswersCount(10);
        stats.setDelayRate(0.5);
        stats.setPackageStateRate(0.8);
        stats.setDeliveryRate(0.9);
        
        model.addAttribute("stats", stats);
        
        return "dashboard";
    }

    @GetMapping("/questionnaire")
    public String questionnaire() {
        return "questionnaire";
    }
}
