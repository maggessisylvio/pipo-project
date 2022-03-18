package com.pipo.employeeregistration.services;

import com.pipo.employeeregistration.dtos.EmployeeDTO;
import com.pipo.employeeregistration.entities.Employee;
import com.pipo.employeeregistration.repositories.EmployeeRepository;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository repository;
    private MongoTemplate mongoTemplate;

    public EmployeeService(EmployeeRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    public Employee create(EmployeeDTO employeeDTO) {
        Document data = Document.parse(employeeDTO.getData());

        Employee employeeBD = new Employee();
        employeeBD.setCustomerId(employeeDTO.getCustomerId());
        employeeBD.setData(data);

        return this.repository.save(employeeBD);
    }

    public List<Object> findByCustomer(Long customerId) {
        List<Object> data = new ArrayList<>();

        repository.findByCustomerId(customerId).forEach(employee -> {
            var object = mongoTemplate.getConverter().read(Object.class, employee.getData());
            data.add(object);
        });

        return data;
    }
}
