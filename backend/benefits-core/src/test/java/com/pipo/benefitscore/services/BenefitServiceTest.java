package com.pipo.benefitscore.services;

import com.pipo.benefitscore.dtos.BenefitDTO;
import com.pipo.benefitscore.dtos.FieldNameDTO;
import com.pipo.benefitscore.entities.Benefit;
import com.pipo.benefitscore.entities.Field;
import com.pipo.benefitscore.repositories.BenefitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BenefitServiceTest {

    @InjectMocks
    private BenefitService service;

    @Mock
    private BenefitRepository repository;

    private Benefit benefit;
    private BenefitDTO benefitDTO;
    private Optional<Benefit> benefitOptional;

    private Field field;
    private FieldNameDTO fieldNameDTO;

    @BeforeEach
    void beforeEach(){
        MockitoAnnotations.openMocks(this);
        startBenefit();
    }

    @Test
    void shouldReturnAListOfBenefits(){
        Mockito.when(repository.findBenefitByCustomer(Mockito.anyLong())).thenReturn(List.of(benefit));

        List<BenefitDTO> response = service.findBenefitByCustomer(Mockito.anyLong());

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(benefitDTO.getId(), response.get(0).getId());
        assertEquals(benefitDTO.getName(), response.get(0).getName());
    }

    @Test
    void shouldReturnAListOfFieldsName(){
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(benefitOptional);

        List<FieldNameDTO> response = service.findFieldsNameByBenefit(Mockito.anyLong());

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(fieldNameDTO.getName(), response.get(0).getName());
    }

    private void startBenefit() {
        field = new Field(1L, "name", "Name", "text", null, true);
        fieldNameDTO = new FieldNameDTO("name");

        benefit = new Benefit(1L, "PLANO SAO JOSE", List.of(field));
        benefitDTO = new BenefitDTO(1L, "PLANO SAO JOSE");
        benefitOptional = Optional.of(new Benefit(1L, "PLANO SAO JOSE", List.of(field)));
    }
}