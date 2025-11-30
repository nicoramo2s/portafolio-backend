package com.portfolio.my_portfolio_backend.rest;

import com.portfolio.my_portfolio_backend.model.Experience;
import com.portfolio.my_portfolio_backend.service.IExperienceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/test/experience")
public class ExperienceTestController {
    private final IExperienceService experienceService;

    public ExperienceTestController(IExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping
    public List<Experience> getAllExperience() {
        return experienceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable Long id) {
        Optional<Experience> experience = experienceService.findById(id);
        if (experience.isPresent()) {
            return new ResponseEntity<>(experience.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Experience> createExperience(@RequestBody Experience experience) {
        try {
            Experience newExperience = experienceService.save(experience);
            return new ResponseEntity<>(newExperience, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Experience updateExperience(@PathVariable Long id, @RequestBody Experience experience) {
        experience.setId(id);
        try {
            return experienceService.save(experience);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteExperience(@PathVariable Long id) {
        experienceService.deleteById(id);
    }

    @GetMapping("/personal-info/{personalInfoId}")
    public List<Experience> getExperienceByPersonalInfoId(@PathVariable Long personalInfoId) {
        return experienceService.findExperienceByPersonalInfoId(personalInfoId);
    }
}
