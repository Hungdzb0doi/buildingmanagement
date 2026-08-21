package com.BuildingWeb.Repository;

import com.BuildingWeb.Entity.AssignmentCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssignmentCustomerRepository extends JpaRepository<AssignmentCustomerEntity, Long> {
    void deleteBycustomer_idCustomer(Long idCustomer);
    @Query("SELECT a.user.idUser FROM AssignmentCustomerEntity a WHERE a.customer.idCustomer = :customerId")
    List<Long> findUserIdByCustomerId(@Param("customerId") Long customerId);
}
