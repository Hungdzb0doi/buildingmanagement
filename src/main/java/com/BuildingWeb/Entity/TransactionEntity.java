package com.BuildingWeb.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdTransaction")
private Long idTransaction;
    @ManyToOne
    @JoinColumn(name = "IdUser")
private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "IdCustomer")
private CustomerEntity customer;
    @OneToMany(mappedBy = "transaction",fetch = FetchType.LAZY)
private List<TransactionTypeEntity> transactionType=new ArrayList<>();
    @Column(name="Note")
private String  note;
    @Column(name="CreatedDate")
    private Date createdDate=new Date();

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getIdTransaction() {
	return idTransaction;
}
public void setIdTransaction(Long idTransaction) {
	this.idTransaction = idTransaction;
}

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public List<TransactionTypeEntity> getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(List<TransactionTypeEntity> transactionType) {
        this.transactionType = transactionType;
    }

    public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}
}
