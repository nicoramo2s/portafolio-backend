package com.portfolio.my_portfolio_backend.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDto {
    private Long id;

    @NotBlank(message = "El puesto de trabajo no puede estar vacio")
    @Size(max = 100, message = "El puesto de trabajo no puede tener más de 100 caracteres")
    private String jobTitle;

    @NotBlank(message = "El nombre de la empresa no puede estar vacio")
    private String companyName;

    @NotNull(message = "La fecha de inicio no puede estar vacia")
    @PastOrPresent(message = "La fecha de inicio no puede ser posterior a la fecha actual")
    private LocalDate startDate;

    @PastOrPresent(message = "La fecha de fin no puede ser posterior a la fecha actual")
    private LocalDate endDate;

    @NotBlank(message = "La descripcion no puede estar vacia")
    private String description;

    private Long personalInfoId;
}
