package com.portfolio.my_portfolio_backend.mapper;

import com.portfolio.my_portfolio_backend.dto.ProjectDto;
import com.portfolio.my_portfolio_backend.model.Project;

public class ProjectMapper {
    public static ProjectDto toDto(Project project) {
        if (project == null) {
            return null;
        }
        ProjectDto dto = new ProjectDto();

        dto.setId(project.getId());
        dto.setTitle(project.getTitle());
        dto.setDescription(project.getDescription());
        dto.setImageUrl(project.getImageUrl());
        dto.setProjectUrl(project.getProjectUrl());
        dto.setPersonalInfoId(project.getPersonalInfoId());
        return dto;
    }

    public static Project toEntity(ProjectDto projectDto) {
        if (projectDto == null) {
            return null;
        }
        Project project = new Project();

        project.setId(projectDto.getId());
        project.setTitle(projectDto.getTitle());
        project.setDescription(projectDto.getDescription());
        project.setImageUrl(projectDto.getImageUrl());
        project.setProjectUrl(projectDto.getProjectUrl());
        project.setPersonalInfoId(projectDto.getPersonalInfoId());
        return project;
    }
}
