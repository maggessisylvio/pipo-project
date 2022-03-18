package com.pipo.employeeregistration.services;

import com.pipo.employeeregistration.dtos.EmployeeDTO;
import com.pipo.employeeregistration.entities.Employee;
import com.pipo.employeeregistration.repositories.EmployeeRepository;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService service;

    @Mock
    private EmployeeRepository repository;

    @Mock
    private MongoTemplate mongoTemplate;

    @Mock
    MongoConverter converter;

    private Employee employee;
    private EmployeeDTO employeeDTO;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
        startEmployee();
    }

    @Test
    void shouldCreateAnEmployee() {
        Mockito.when(repository.save(Mockito.any())).thenReturn(employee);

        Employee response = service.create(employeeDTO);

        assertNotNull(response);
        assertEquals(Employee.class, response.getClass());
        assertEquals(employee.getId(), response.getId());
    }

    @Test
    void shouldReturnAListOfObjectsWithEmployeeFields() {
        Mockito.when(repository.findByCustomerId(Mockito.anyLong())).thenReturn(List.of(employee));
        Mockito.when(mongoTemplate.getConverter()).thenReturn(converter);

        List<Object> response = service.findByCustomer(Mockito.anyLong());

        assertNotNull(response);
        assertEquals(1, response.size());
    }

    private void startEmployee() {
        var data = "{\"name\":\"Rogério\",\"cpf\":\"1231232131\",\"admissionDate\":\"2022-03-07\",\"address\":\"RuaJosédeSuza,número31,BairroJacaré\",\"weight\":\"78\",\"weight\":\"181\",\"weight\":\"8\"}";
        employeeDTO = new EmployeeDTO(1L, data);
        employee = new Employee("54759eb3c090d83494e2d804", 1L, Document.parse(data));
    }

}