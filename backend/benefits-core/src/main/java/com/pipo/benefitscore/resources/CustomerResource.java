package com.pipo.benefitscore.resources;

import com.pipo.benefitscore.dtos.CustomerDTO;
import com.pipo.benefitscore.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/customers")
public class CustomerResource {

    private CustomerService service;

    public CustomerResource(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
