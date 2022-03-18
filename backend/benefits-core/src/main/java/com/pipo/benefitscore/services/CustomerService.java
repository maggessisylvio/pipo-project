package com.pipo.benefitscore.services;

import com.pipo.benefitscore.dtos.CustomerDTO;
import com.pipo.benefitscore.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<CustomerDTO> findAll(){
        ModelMapper modelMapper = new ModelMapper();
        List<CustomerDTO> customers = new ArrayList<>();
        repository.findAll().forEach(customer -> {
            customers.add(modelMapper.map(customer, CustomerDTO.class));
        });

        return customers;
    }
}
