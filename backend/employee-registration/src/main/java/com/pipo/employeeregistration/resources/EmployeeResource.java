package com.pipo.employeeregistration.resources;

import com.pipo.employeeregistration.dtos.EmployeeDTO;
import com.pipo.employeeregistration.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/employees")
public class EmployeeResource {

    private EmployeeService service;

    public EmployeeResource(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody EmployeeDTO employeeDTO) {
        service.create(employeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Object>> findByCustomer(@RequestParam Long customerId) {
        return ResponseEntity.ok().body(service.findByCustomer(customerId));
    }
}
