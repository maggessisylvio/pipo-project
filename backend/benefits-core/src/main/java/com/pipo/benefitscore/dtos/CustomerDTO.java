package com.pipo.benefitscore.dtos;

public class CustomerDTO {

    private Long id;
    private String cnpj;
    private String name;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String cnpj, String name) {
        this.id = id;
        this.cnpj = cnpj;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
