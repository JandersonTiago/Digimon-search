package com.example.digimon.controller;

import com.example.digimon.model.Digimon;
import com.example.digimon.service.DigimonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DigimonController {
    @Autowired
    private DigimonService digimonService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/search")
    public String search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String level,
            Model model) {
        Digimon[] digimons = null;

        if (name != null && !name.isEmpty()) {
            digimons = digimonService.getDigimonByName(name);
        } else if (level != null && !level.isEmpty()) {
            digimons = digimonService.getDigimonByLevel(level);
        }

        model.addAttribute("digimons", digimons);
        return "search";
    }
}
