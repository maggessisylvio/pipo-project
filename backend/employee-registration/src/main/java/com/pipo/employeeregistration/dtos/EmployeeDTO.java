package com.pipo.employeeregistration.dtos;

public class EmployeeDTO {

    private Long customerId;
    private String data;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long customerId, String data) {
        this.customerId = customerId;
        this.data = data;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
