package com.portfolio.my_portfolio_backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillDto {
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacio")
    private String name;

    @NotNull(message = "El nivel no puede ser nulo")
    @Min(value = 0, message = "El nivel no puede ser negativo")
    @Max(value = 100, message = "El nivel no puede ser mayor a 100")
    private Integer levelPercentage;

    @NotBlank(message = "La clase de icono no puede estar vacia")
    private String iconClass;

    @NotNull(message = "El id de la informacion personal no puede ser nulo")
    private Long personalInfoId;
}
