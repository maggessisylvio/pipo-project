package com.pipo.benefitscore.dtos;

public class FieldDTO {
    private String name;
    private String label;
    private String type;
    private String value;
    private Boolean required;

    public FieldDTO() {
    }

    public FieldDTO(String name, String label, String type, String value, Boolean required) {
        this.name = name;
        this.label = label;
        this.type = type;
        this.value = value;
        this.required = required;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }
}
