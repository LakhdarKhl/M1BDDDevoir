package com.m1.bdd_merise_m1.controller;

import com.m1.bdd_merise_m1.dto.StatDTO;
import com.m1.bdd_merise_m1.service.FeelbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FeelbackController {
    
    @Autowired
    private FeelbackService dashboardService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        List<StatDTO> stats = dashboardService.getStats();
        model.addAttribute("stats", stats);
        
        return "dashboard";
    }

    @GetMapping("/questionnaire")
    public String questionnaire() {
        return "questionnaire";
    }
}
