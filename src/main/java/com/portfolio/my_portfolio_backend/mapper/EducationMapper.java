package com.portfolio.my_portfolio_backend.mapper;

import com.portfolio.my_portfolio_backend.dto.EducationDto;
import com.portfolio.my_portfolio_backend.model.Education;

public class EducationMapper {
    public static EducationDto toDto(Education education) {
        if (education == null) {
            return null;
        }
        EducationDto dto = new EducationDto();

        dto.setId(education.getId());
        dto.setDegree(education.getDegree());
        dto.setInstitution(education.getInstitution());
        dto.setStartDate(education.getStartDate());
        dto.setEndDate(education.getEndDate());
        dto.setDescription(education.getDescription());
        dto.setPersonalInfoId(education.getPersonalInfoId());
        return dto;
    }

    public static Education toEntity(EducationDto educationDto) {
        if (educationDto == null) {
            return null;
        }
        Education education = new Education();

        education.setId(educationDto.getId());
        education.setDegree(educationDto.getDegree());
        education.setInstitution(educationDto.getInstitution());
        education.setStartDate(educationDto.getStartDate());
        education.setEndDate(educationDto.getEndDate());
        education.setDescription(educationDto.getDescription());
        education.setPersonalInfoId(educationDto.getPersonalInfoId());
        return education;
    }
}
