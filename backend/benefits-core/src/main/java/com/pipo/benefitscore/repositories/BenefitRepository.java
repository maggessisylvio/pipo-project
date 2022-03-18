package com.pipo.benefitscore.repositories;

import com.pipo.benefitscore.entities.Benefit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenefitRepository extends CrudRepository<Benefit,Long> {

    @Query(value = "SELECT B.* FROM BENEFITS B\n" +
            "INNER JOIN CUSTOMERS_BENEFITS CB ON (CB.BENEFITS_ID = B.ID)\n" +
            "WHERE CB.CUSTOMERS_ID = :customerId", nativeQuery = true)
    List<Benefit> findBenefitByCustomer(Long customerId);
}
