package com.BuildingWeb.Repository;

import com.BuildingWeb.Entity.TransactionTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTypeRepository extends JpaRepository<TransactionTypeEntity,Long> {
    TransactionTypeEntity findByCode(String code);
}
