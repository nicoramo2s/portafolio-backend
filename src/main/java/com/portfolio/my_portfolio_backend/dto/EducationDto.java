package com.portfolio.my_portfolio_backend.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {
    private Long id;
    @NotBlank(message = "El titulo no puede estar vacio")
    private String degree;

    @NotBlank(message = "La institucion no puede estar vacia")
    private String institution;

    @NotNull(message = "La fecha de inicio no puede estar vacia")
    @PastOrPresent(message = "La fecha de inicio no puede ser posterior a la fecha actual")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @PastOrPresent(message = "La fecha de fin no puede ser posterior a la fecha actual")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotBlank(message = "La descripcion no puede estar vacia")
    private String description;

    private Long personalInfoId;
}
