package com.pipo.benefitscore.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "benefits")
public class Benefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "benefits_id"),
            inverseJoinColumns = @JoinColumn(name = "fields_id")
    )
    private List<Field> fields;

    public Benefit() {
    }

    public Benefit(Long id, String name, List<Field> fields) {
        this.id = id;
        this.name = name;
        this.fields = fields;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
