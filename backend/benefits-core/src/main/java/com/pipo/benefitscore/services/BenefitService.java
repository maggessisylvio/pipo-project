package com.pipo.benefitscore.services;

import com.pipo.benefitscore.dtos.BenefitDTO;
import com.pipo.benefitscore.dtos.FieldNameDTO;
import com.pipo.benefitscore.entities.Benefit;
import com.pipo.benefitscore.repositories.BenefitRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BenefitService {

    private BenefitRepository repository;

    public BenefitService(BenefitRepository repository) {
        this.repository = repository;
    }

    public List<BenefitDTO> findBenefitByCustomer(Long customerId){
        ModelMapper modelMapper = new ModelMapper();
        List<BenefitDTO> benefits = new ArrayList<>();

        repository.findBenefitByCustomer(customerId).forEach(benefit ->{
            benefits.add(modelMapper.map(benefit, BenefitDTO.class));
        });

        return benefits;
    }

    public List<FieldNameDTO> findFieldsNameByBenefit(Long benefitId){
        List<FieldNameDTO> fields = new ArrayList<>();
        Benefit benefit = repository.findById(benefitId).get();
        benefit.getFields().forEach(field -> {
            FieldNameDTO fieldNameDTO = new FieldNameDTO();
            fieldNameDTO.setName(field.getName());
            fields.add(fieldNameDTO);
        });
        return fields;
    }
}
