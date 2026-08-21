package com.BuildingWeb.Repository;

import com.BuildingWeb.Entity.TransactionEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Long> {


        @Query("SELECT DISTINCT t FROM TransactionEntity t " +
                "LEFT JOIN t.transactionType tt " +
                "WHERE (:customerName IS NULL OR :customerName = '' OR t.customer.customerName LIKE CONCAT('%', :customerName, '%')) " +
                "AND (:userName IS NULL OR :userName = '' OR t.user.userName LIKE CONCAT('%', :userName, '%')) " +
                "AND (:code IS NULL OR :code = '' OR tt.code = :code) " +
                "AND (:currentUserName IS NULL OR t.user.phone = :currentUserName)")
        List<TransactionEntity> searchTransactions(@Param("customerName") String customerName,
                                                   @Param("userName") String userName,
                                                   @Param("code") String code,
                                                   @Param("currentUserName") String currentUserName);

    @Query("SELECT COUNT(DISTINCT t.id) FROM TransactionEntity t JOIN t.transactionType tt WHERE tt.code = 'DAN_XEM'")
    Long countDdxTransactions();

    @Query("SELECT u.userName, COUNT(t.id) " +
            "FROM TransactionEntity t JOIN t.user u " +
            "GROUP BY u.userName " +
            "ORDER BY COUNT(t.id) DESC")
    List<Object[]> getTopStaffPerformance(Pageable pageable);
    }
