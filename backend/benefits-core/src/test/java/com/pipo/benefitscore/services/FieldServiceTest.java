package com.pipo.benefitscore.services;

import com.pipo.benefitscore.dtos.FieldDTO;
import com.pipo.benefitscore.dtos.FormDataDTO;
import com.pipo.benefitscore.entities.Field;
import com.pipo.benefitscore.repositories.FieldRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FieldServiceTest {

    @InjectMocks
    private FieldService service;

    @Mock
    private FieldRepository repository;

    private Field field;
    private FieldDTO fieldDTO;

    @BeforeEach
    void beforeEach(){
        MockitoAnnotations.openMocks(this);
        startField();
    }

    @Test
    void shouldReturnAListOfFieldDTO(){
        Mockito.when(repository.getFieldsForEmployeeFormByBenefits(Mockito.anyList())).thenReturn(List.of(field));

        FormDataDTO response = service.getFieldsForEmployeeFormByBenefits(Mockito.anyList());

        assertNotNull(response);
        assertEquals(1, response.getFields().size());
        assertEquals(fieldDTO.getName(), response.getFields().get(0).getName());
        assertEquals(fieldDTO.getLabel(), response.getFields().get(0).getLabel());
        assertEquals(fieldDTO.getType(), response.getFields().get(0).getType());
        assertEquals(fieldDTO.getRequired(), response.getFields().get(0).getRequired());
    }

    private void startField() {
        field = new Field(1L, "name", "Name", "text", null, true);
        fieldDTO = new FieldDTO("name", "Name", "text", null, true);
    }

}