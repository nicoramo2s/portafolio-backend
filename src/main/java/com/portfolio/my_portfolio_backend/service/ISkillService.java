package com.portfolio.my_portfolio_backend.service;

import com.portfolio.my_portfolio_backend.model.Skill;

import java.util.List;
import java.util.Optional;

public interface ISkillService {
    Skill saveSkill(Skill skill);
    Optional<Skill> findSkillById(Long id);
    List<Skill> findAllSkills();
    List<Skill> findSkillsByPersonalInfoId(Long personalInfoId);
    void deleteSkillById(Long id);
}
