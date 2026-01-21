package com.portfolio.my_portfolio_backend.dto;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInfoDto {
    private Long id;

    @NotBlank(message = "EL nombre no puede estar vacio")
    private String firstName;

    @NotBlank(message = "EL apellido no puede estar vacio")
    private String lastName;

    @NotBlank(message = "EL titulo no puede estar vacio")
    private String title;

    @NotBlank(message = "La descripcion no puede estar vacia")
    private String profileDescription;

    @NotBlank(message = "La url de la imagen no puede estar vacia")
    private String profileImageUrl;

    @Min(value = 0, message = "Los años de experiencia no pueden ser negativos")
    private Integer yearsOfExperience;

    @Email(message = "El email no es valido")
    private String email;

    @NotBlank(message = "El telefono no puede estar vacio")
    private String phone;

    @URL(message = "La url de linkedin no puede estar vacia")
    private String linkedinUrl;

    @URL(message = "La url de github no puede estar vacia")
    private String githubUrl;
}
