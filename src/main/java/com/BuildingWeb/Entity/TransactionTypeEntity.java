package com.BuildingWeb.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="transactiontype")
public class TransactionTypeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="IdTransactionType")
private Long idTransactionType;
    @Column(name="Code")
private String code;
    @Column(name="TransactionTypeName")
private String transactionTypeName;
    @ManyToOne
    @JoinColumn(name = "IdTransaction")
private TransactionEntity transaction;
public Long getIdTransactionType() {
	return idTransactionType;
}
public void setIdTransactionType(Long idTransactionType) {
	this.idTransactionType = idTransactionType;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getTransactionTypeName() {
	return transactionTypeName;
}
public void setTransactionTypeName(String transactionTypeName) {
	this.transactionTypeName = transactionTypeName;
}

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }
}
