package com.portfolio.my_portfolio_backend.service;

import com.portfolio.my_portfolio_backend.exception.ValidationException;
import com.portfolio.my_portfolio_backend.model.Education;
import com.portfolio.my_portfolio_backend.repository.IEducationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class EducationServiceTest {
    @Autowired
    private IEducationService educationService;
    @Autowired
    private IEducationRepository educationRepository;

    @Test
    void testValidEducationSave() {
        Education validEducation = new Education(
                null,
                "Licenciatura en Informatica",
                "Universidad Nacional de La Plata",
                LocalDate.of(2018, 3, 1),
                LocalDate.of(2023, 12, 15),
                "Desarrollo de software, bases de datos, redes, etc.",
                1L);

        Education saveEducation = educationService.save(validEducation);

        assertNotNull(saveEducation.getId(), "El objeto guardado debe tener un ID asignado");

        assertNotNull(educationRepository.findById(saveEducation.getId()), "El objeto guardado debe estar en la base de datos");
    }

    @Test
    void testInvalidEducationSave() {
        Education invalidEducation = new Education(
                null,
                "Licenciatura en Informatica",
                "",
                LocalDate.of(2018, 3, 1),
                LocalDate.of(2023, 12, 15),
                "Desarrollo de software, bases de datos, redes, etc.",
                1L);

        assertThrows(ValidationException.class, () -> educationService.save(invalidEducation), "Se esperaba una excepción de validación");
    }

}
