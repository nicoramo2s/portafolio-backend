package com.portfolio.my_portfolio_backend.rest;

import com.portfolio.my_portfolio_backend.model.Education;
import com.portfolio.my_portfolio_backend.service.IEducationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/test/education")
public class EducationRestController {
    private final IEducationService educationService;

    public EducationRestController(IEducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping
    public List<Education> getAllEducation() {
        return educationService.findAll();
    }

    @GetMapping("/{id}")
    public Education getEducationById(@PathVariable Long id) {
        Optional<Education> education = educationService.findById(id);
        if (education.isPresent()) {
            return education.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Educación no encontrada con ID: " + id);
        }
    }

    @PostMapping
    public ResponseEntity<Education> createEducation(@RequestBody Education education) {
        try {
            Education newEducation = educationService.save(education);
            return new ResponseEntity<>(newEducation, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Education updateEducation(@PathVariable Long id, @RequestBody Education education) {
        education.setId(id);
        try {
            return educationService.save(education);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEducation(@PathVariable Long id) {
        educationService.deleteById(id);
    }

    @GetMapping("/personal-info/{personalInfoId}")
    public List<Education> getEducationByPersonalInfoId(@PathVariable Long personalInfoId) {
        return educationService.findEducationByPersonalInfoId(personalInfoId);
    }

}
