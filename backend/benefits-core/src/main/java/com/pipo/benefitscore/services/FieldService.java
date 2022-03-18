package com.pipo.benefitscore.services;

import com.pipo.benefitscore.dtos.FieldDTO;
import com.pipo.benefitscore.dtos.FormDataDTO;
import com.pipo.benefitscore.repositories.FieldRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FieldService {

    private FieldRepository repository;

    public FieldService(FieldRepository repository) {
        this.repository = repository;
    }

    public FormDataDTO getFieldsForEmployeeFormByBenefits(List<Integer> benefitsId) {
        ModelMapper modelMapper = new ModelMapper();
        List<FieldDTO> fields = new ArrayList<>();
        FormDataDTO form = new FormDataDTO();

        repository.getFieldsForEmployeeFormByBenefits(benefitsId).forEach(field -> {
            fields.add(modelMapper.map(field, FieldDTO.class));
        });

        form.setFields(fields);
        return form;
    }
}
