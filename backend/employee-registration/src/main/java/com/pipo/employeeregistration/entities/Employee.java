package com.pipo.employeeregistration.entities;

import org.bson.conversions.Bson;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employee {

    @Id
    private String id;
    private Long customerId;
    private Bson data;

    public Employee() {
    }

    public Employee(String id, Long customerId, Bson data) {
        this.id = id;
        this.customerId = customerId;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Bson getData() {
        return data;
    }

    public void setData(Bson data) {
        this.data = data;
    }
}
