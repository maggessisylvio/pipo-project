package com.pipo.benefitscore.services;

import com.pipo.benefitscore.dtos.CustomerDTO;
import com.pipo.benefitscore.entities.Customer;
import com.pipo.benefitscore.repositories.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    @InjectMocks
    private CustomerService service;

    @Mock
    private CustomerRepository repository;

    private Customer customer;
    private CustomerDTO customerDTO;

    @BeforeEach
    void beforeEach(){
        MockitoAnnotations.openMocks(this);
        startCustomer();
    }

    @Test
    void shouldReturnAListOfCustomers(){
        Mockito.when(repository.findAll()).thenReturn(List.of(customer));

        List<CustomerDTO> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(customerDTO.getId(), response.get(0).getId());
        assertEquals(customerDTO.getName(), response.get(0).getName());
        assertEquals(customerDTO.getCnpj(), response.get(0).getCnpj());
    }

    @Test
    void shouldReturnAEmptyListOfCustomers(){
        Mockito.when(repository.findAll()).thenReturn(Collections.emptyList());

        List<CustomerDTO> response = service.findAll();

        assertNotNull(response);
        assertEquals(0, response.size());
    }

    private void startCustomer(){
        customer = new Customer(1L, "30640060000130", "João Carlos");
        customerDTO = new CustomerDTO(1L, "30640060000130", "João Carlos");
    }

}