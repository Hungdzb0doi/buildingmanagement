package com.BuildingWeb.Repository;

import com.BuildingWeb.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    @Query("SELECT c FROM CustomerEntity c WHERE " +
            "(:name IS NULL OR :name = '' OR LOWER(c.customerName) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:phone IS NULL OR :phone = '' OR c.phone LIKE CONCAT('%', :phone, '%')) AND " +
            "(:idUser IS NULL OR EXISTS (SELECT a FROM AssignmentCustomerEntity a WHERE a.customer = c AND a.user.idUser = :idUser))")
    List<CustomerEntity> searchCustomers(@Param("name") String customerName, @Param("phone") String phone, @Param("idUser") Long idUser);
    void deleteByIdCustomerIn(Long[] id);
    @Query("SELECT COUNT(c) FROM CustomerEntity c WHERE NOT EXISTS (SELECT t FROM TransactionEntity t WHERE t.customer.id = c.id)")
    Long countNeglectedCustomers();
    @Query("SELECT c FROM CustomerEntity c WHERE NOT EXISTS (SELECT t FROM TransactionEntity t WHERE t.customer.id = c.id)")
    List<CustomerEntity> findNeglectedCustomers();
}
