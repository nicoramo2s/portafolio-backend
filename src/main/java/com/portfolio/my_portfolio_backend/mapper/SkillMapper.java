package com.portfolio.my_portfolio_backend.mapper;

import com.portfolio.my_portfolio_backend.dto.SkillDto;
import com.portfolio.my_portfolio_backend.model.Skill;

public class SkillMapper {
    public static SkillDto toDto(Skill skill) {
        if (skill == null) {
            return null;
        }
        SkillDto dto = new SkillDto();

        dto.setId(skill.getId());
        dto.setName(skill.getName());
        dto.setLevelPercentage(skill.getLevelPercentage());
        dto.setIconClass(skill.getIconClass());
        dto.setPersonalInfoId(skill.getPersonalInfoId());
        return dto;
    }

    public static Skill toEntity(SkillDto skillDto) {
        if (skillDto == null) {
            return null;
        }
        Skill skill = new Skill();

        skill.setId(skillDto.getId());
        skill.setName(skillDto.getName());
        skill.setLevelPercentage(skillDto.getLevelPercentage());
        skill.setIconClass(skillDto.getIconClass());
        skill.setPersonalInfoId(skillDto.getPersonalInfoId());
        return skill;
    }
}
