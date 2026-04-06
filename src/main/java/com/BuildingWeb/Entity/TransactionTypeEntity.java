package com.BuildingWeb.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="transactiontype")
public class TransactionTypeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="IdTransactionType")
private int IdTransactionType;
    @Column(name="Code")
private String Code;
    @Column(name="TransactionType")
private String TransactionTypeName;
    @ManyToOne
    @JoinColumn(name = "IdTransaction")
private TransactionEntity Transaction;
public int getIdTransactionType() {
	return IdTransactionType;
}
public void setIdTransactionType(int idTransactionType) {
	IdTransactionType = idTransactionType;
}
public String getCode() {
	return Code;
}
public void setCode(String code) {
	Code = code;
}
public String getTransactionTypeName() {
	return TransactionTypeName;
}
public void setTransactionTypeName(String transactionTypeName) {
	TransactionTypeName = transactionTypeName;
}

    public TransactionEntity getTransaction() {
        return Transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        Transaction = transaction;
    }
}
