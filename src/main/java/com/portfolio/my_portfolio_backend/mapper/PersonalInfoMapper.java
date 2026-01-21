package com.portfolio.my_portfolio_backend.mapper;

import com.portfolio.my_portfolio_backend.dto.PersonalInfoDto;
import com.portfolio.my_portfolio_backend.model.PersonalInfo;

public class PersonalInfoMapper {

    public static PersonalInfoDto toDto(PersonalInfo personalInfo) {
        return new PersonalInfoDto(
                personalInfo.getId(),
                personalInfo.getFirstName(),
                personalInfo.getLastName(),
                personalInfo.getTitle(),
                personalInfo.getProfileDescription(),
                personalInfo.getProfileImageUrl(),
                personalInfo.getYearsOfExperience(),
                personalInfo.getEmail(),
                personalInfo.getPhone(),
                personalInfo.getLinkedinUrl(),
                personalInfo.getGithubUrl());
    }

    public static PersonalInfo toEntity(PersonalInfoDto personalInfoDto) {
        return new PersonalInfo(
                personalInfoDto.getId(),
                personalInfoDto.getFirstName(),
                personalInfoDto.getLastName(),
                personalInfoDto.getTitle(),
                personalInfoDto.getProfileDescription(),
                personalInfoDto.getProfileImageUrl(),
                personalInfoDto.getYearsOfExperience(),
                personalInfoDto.getEmail(),
                personalInfoDto.getPhone(),
                personalInfoDto.getLinkedinUrl(),
                personalInfoDto.getGithubUrl());
    }
}
