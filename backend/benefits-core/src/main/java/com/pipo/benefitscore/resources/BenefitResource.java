package com.pipo.benefitscore.resources;

import com.pipo.benefitscore.dtos.BenefitDTO;
import com.pipo.benefitscore.dtos.FieldNameDTO;
import com.pipo.benefitscore.services.BenefitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/benefits")
public class BenefitResource {

    private BenefitService service;

    public BenefitResource(BenefitService service) {
        this.service = service;
    }

    @GetMapping("/findBenefitByCustomer")
    public ResponseEntity<List<BenefitDTO>> findBenefitByCustomer(@RequestParam Long customerId) {
        return ResponseEntity.ok().body(service.findBenefitByCustomer(customerId));
    }

    @GetMapping("/findFieldsNameByBenefit")
    public ResponseEntity<List<FieldNameDTO>> findFieldsNameByBenefit(@RequestParam Long benefitId) {
        return ResponseEntity.ok().body(service.findFieldsNameByBenefit(benefitId));
    }
}
