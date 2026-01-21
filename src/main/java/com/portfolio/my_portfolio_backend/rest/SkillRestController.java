package com.portfolio.my_portfolio_backend.rest;

import com.portfolio.my_portfolio_backend.model.Skill;
import com.portfolio.my_portfolio_backend.service.ISkillService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/test/skill")
public class SkillRestController {

    private final ISkillService skillService;

    public SkillRestController(ISkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.findAllSkills();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable Long id) {
        Optional<Skill> skill = skillService.findSkillById(id);
        if (skill.isPresent()) {
            return new ResponseEntity<>(skill.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
        try {
            Skill newSkill = skillService.saveSkill(skill);
            return new ResponseEntity<>(newSkill, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable Long id, @RequestBody Skill skill) {
        skill.setId(id);
        try {
            return skillService.saveSkill(skill);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteSkillById(id);
    }

    @GetMapping("/personal-info/{personalInfoId}")
    public List<Skill> getSkillsByPersonalInfoId(@PathVariable Long personalInfoId) {
        return skillService.findSkillsByPersonalInfoId(personalInfoId);
    }

}
