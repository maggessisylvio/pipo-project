package com.pipo.benefitscore.repositories;

import com.pipo.benefitscore.entities.Field;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepository extends CrudRepository<Field,Long> {

    @Query(value =
            "SELECT F.* FROM FIELDS F\n" +
            "INNER JOIN BENEFITS_FIELDS BF ON (F.ID = BF.FIELDS_ID)\n" +
            "INNER JOIN BENEFITS B ON (BF.BENEFITS_ID = B.ID)\n" +
            "INNER JOIN CUSTOMERS_BENEFITS CB ON (B.ID = CB.BENEFITS_ID)\n" +
            "WHERE B.ID IN (:benefitsId) \n" +
            "GROUP BY F.ID", nativeQuery = true)
    List<Field> getFieldsForEmployeeFormByBenefits(List<Integer> benefitsId);
}
