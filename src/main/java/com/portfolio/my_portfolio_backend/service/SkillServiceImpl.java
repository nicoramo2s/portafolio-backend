package com.portfolio.my_portfolio_backend.service;

import com.portfolio.my_portfolio_backend.exception.ValidationException;
import com.portfolio.my_portfolio_backend.model.Skill;
import com.portfolio.my_portfolio_backend.repository.ISkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements ISkillService {

    private final ISkillRepository skillRepository;
    private final Validator validator;

    @Override
    @Transactional
    public Skill saveSkill(Skill skill) {
        BindingResult result = new BeanPropertyBindingResult(skill, "skill");
        validator.validate(skill, result);
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }
        return skillRepository.save(skill);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Skill> findSkillById(Long id) {
        return skillRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Skill> findAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Skill> findSkillsByPersonalInfoId(Long personalInfoId) {
        return skillRepository.findByPersonalInfoId(personalInfoId);
    }

    @Override
    @Transactional
    public void deleteSkillById(Long id) {
        skillRepository.deleteById(id);
    }
}
