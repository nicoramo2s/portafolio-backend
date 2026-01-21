package com.portfolio.my_portfolio_backend.controller;

import com.portfolio.my_portfolio_backend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final IPersonalInfoService personalInfoService;
    private final IEducationService educationService;
    private final ISkillService skillService;
    private final IExperienceService experienceService;
    private final IProjectService projectService;

    @GetMapping("/")
    public String showIndex(Model model){
        model.addAttribute("personalInfo", personalInfoService.findAll().get(0));
        model.addAttribute("educationList", educationService.findAll());
        model.addAttribute("skills", skillService.findAllSkills());
        model.addAttribute("experienceList", experienceService.findAll());
        model.addAttribute("projects", projectService.findAll());
        return "index";
    }
}
