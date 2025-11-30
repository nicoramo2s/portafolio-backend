package com.portfolio.my_portfolio_backend.service;


import com.portfolio.my_portfolio_backend.exception.ValidationException;
import com.portfolio.my_portfolio_backend.model.Skill;
import com.portfolio.my_portfolio_backend.repository.ISkillRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class SkillServiceImplTest {

    @Mock
    private ISkillRepository skillRepository;

    @InjectMocks
    private SkillServiceImpl skillService;

    @Mock
    private Validator validator;

    @Test
    void testFindAllReturnsListOfSkills() {
        // Arrange
        List<Skill> mockSkills = Arrays.asList(new Skill(), new Skill());
        Mockito.when(skillRepository.findAll()).thenReturn(mockSkills);

        // Act - Accion
        List<Skill> skillList = skillService.findAllSkills();

        // Assert - Verificacion
        Assertions.assertNotNull(skillList);
        Assertions.assertEquals(2, skillList.size());
        Mockito.verify(skillRepository, Mockito.times(1)).findAll();
    }

    @Test
    void testFindByIdReturnsSkillWhenFound() {
        Long id = 1L;
        Skill mockSkill = new Skill();
        Mockito.when(skillRepository.findById(id)).thenReturn(Optional.of(mockSkill));

        Optional<Skill> skill = skillService.findSkillById(id);

        Assertions.assertTrue(skill.isPresent());
        Assertions.assertEquals(mockSkill, skill.get());
        Mockito.verify(skillRepository, Mockito.times(1)).findById(id);
    }

    @Test
    void testSaveSkillThrowsExceptionWhenInvalid() {
        Skill invalidSkill = new Skill();
        Mockito.doAnswer(invocationOnMock -> {
            BindingResult result = invocationOnMock.getArgument(1);
            result.rejectValue("name", "NotBlanck", "El nombre no puede estar vacio");
            return null;
        }).when(validator).validate(Mockito.any(Skill.class), Mockito.any(BindingResult.class));

        Assertions.assertThrows(ValidationException.class, () -> skillService.saveSkill(invalidSkill), "Se esperaba una excepción de validación");

        Mockito.verify(validator, Mockito.times(1)).validate(Mockito.any(Skill.class), Mockito.any(BindingResult.class));
        Mockito.verify(skillRepository, Mockito.never()).save(Mockito.any(Skill.class));
    }

    @Test
    void testSaveSkillSavesValidSkill() {
        // Arrange - preparacion
        Skill validSkill = new Skill(null, "Java", 90, "fab fa-java", 1L);
        Mockito.when(skillRepository.save(Mockito.any(Skill.class))).thenReturn(validSkill);
        Mockito.doNothing().when(validator).validate(Mockito.any(Skill.class), Mockito.any(BindingResult.class));

        // ACT
        Skill saveSkill = skillService.saveSkill(validSkill);
        //Assert
        Assertions.assertNotNull(saveSkill);
        Mockito.verify(skillRepository, Mockito.times(1)).save(validSkill);
    }
}
