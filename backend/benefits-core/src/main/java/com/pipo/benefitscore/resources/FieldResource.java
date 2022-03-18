package com.pipo.benefitscore.resources;

import com.pipo.benefitscore.dtos.BenefitsIdDTO;
import com.pipo.benefitscore.dtos.FormDataDTO;
import com.pipo.benefitscore.services.FieldService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/fields")
public class FieldResource {

    private FieldService service;

    public FieldResource(FieldService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FormDataDTO> getFieldsForEmployeeFormByBenefits(@RequestBody BenefitsIdDTO benefitsId) {
        return ResponseEntity.ok().body(service.getFieldsForEmployeeFormByBenefits(benefitsId.getIds()));
    }
}
