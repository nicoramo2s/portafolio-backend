package com.portfolio.my_portfolio_backend.mapper;

import com.portfolio.my_portfolio_backend.dto.ExperienceDto;
import com.portfolio.my_portfolio_backend.model.Experience;

public class ExperienceMapper {
    public static ExperienceDto toDto(Experience experience) {
        if (experience == null) {
            return null;
        }
        ExperienceDto dto = new ExperienceDto();

        dto.setId(experience.getId());
        dto.setCompanyName(experience.getCompanyName());
        dto.setJobTitle(experience.getJobTitle());
        dto.setStartDate(experience.getStartDate());
        dto.setEndDate(experience.getEndDate());
        dto.setDescription(experience.getDescription());
        dto.setPersonalInfoId(experience.getPersonalInfoId());
        return dto;
    }

    public static Experience toEntity(ExperienceDto experienceDto) {
        if (experienceDto == null) {
            return null;
        }
        Experience experience = new Experience();

        experience.setId(experienceDto.getId());
        experience.setCompanyName(experienceDto.getCompanyName());
        experience.setJobTitle(experienceDto.getJobTitle());
        experience.setStartDate(experienceDto.getStartDate());
        experience.setEndDate(experienceDto.getEndDate());
        experience.setDescription(experienceDto.getDescription());
        experience.setPersonalInfoId(experienceDto.getPersonalInfoId());
        return experience;
    }
}
