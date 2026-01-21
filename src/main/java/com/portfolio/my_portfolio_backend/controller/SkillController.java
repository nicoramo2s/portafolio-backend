package com.portfolio.my_portfolio_backend.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.portfolio.my_portfolio_backend.dto.SkillDto;
import com.portfolio.my_portfolio_backend.mapper.SkillMapper;
import com.portfolio.my_portfolio_backend.model.Skill;
import com.portfolio.my_portfolio_backend.service.ISkillService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/skills")
@RequiredArgsConstructor
public class SkillController {

    private final ISkillService skillService;

    @GetMapping()
    public String getAllSkills(Model model) {
        List<Skill> skills = skillService.findAllSkills();
        List<SkillDto> skillsDto = skills.stream().map(SkillMapper::toDto).collect(Collectors.toList());
        model.addAttribute("skills", skillsDto);
        return "skills/list-skill";
    }

    @GetMapping("/new")
    public String getNewSkillForm(Model model) {
        model.addAttribute("skillDto", new SkillDto());
        return "skills/form-skill";
    }

    @PostMapping("/save")
    public String saveSkill(@Valid @ModelAttribute SkillDto skillDto, BindingResult result) {
        if (result.hasErrors()) {
            return "skills/form-skill";
        }
        try {
            Skill skill = SkillMapper.toEntity(skillDto);
            skillService.saveSkill(skill);

            return "redirect:/skills";
        } catch (Exception e) {
            return "error-page";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Skill> skillOptional = skillService.findSkillById(id);

        if (skillOptional.isPresent()) {
            model.addAttribute("skillDto", SkillMapper.toDto(skillOptional.get()));
            return "skills/form-skill";
        }
        model.addAttribute("errorMessage", "La habilidad no se encontro con ID: " + id);
        return "redirect:/skills/all";
    }

    @GetMapping("/personal/{personalInfoId}")
    public String listSkillsByPersonalInfoId(@PathVariable Long personalInfoId, Model model) {
        List<Skill> skills = skillService.findSkillsByPersonalInfoId(personalInfoId);
        List<SkillDto> skillsDto = skills.stream().map(SkillMapper::toDto).collect(Collectors.toList());
        model.addAttribute("skills", skillsDto);
        return "skills/list-skills";
    }

    @PostMapping("/delete/{id}")
    public String deleteSkill(@PathVariable Long id, RedirectAttributes redirectAttributes) {

        try {
            skillService.deleteSkillById(id);
            redirectAttributes.addFlashAttribute("message", "Habilidad eliminada exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar la habilidad");
        }
        return "redirect:/skills";
    }
}
