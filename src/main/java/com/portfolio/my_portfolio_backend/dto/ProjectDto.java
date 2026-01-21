package com.portfolio.my_portfolio_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@NoArgsConstructor
public class ProjectDto {
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Size(min = 3, max = 100, message = "El título debe tener entre 3 y 100 caracteres")
    private String title;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 10, max = 500, message = "La descripción debe tener entre 10 y 500 caracteres")
    private String description;

    @URL(message = "La URL de la imagen es obligatoria")
    private String imageUrl;

    @URL(message = "La URL del proyecto es obligatoria")
    private String projectUrl;

    @NotNull(message = "El ID de la información personal es obligatorio")
    private Long personalInfoId;
}
