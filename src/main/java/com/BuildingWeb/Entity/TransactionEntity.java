package com.BuildingWeb.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdTransaction")
private int IdTransaction;
    @ManyToOne
    @JoinColumn(name = "IdUser")
private UserEntity User;
    @ManyToOne
    @JoinColumn(name = "IdCustomer")
private CustomerEntity Customer;
    @OneToMany(mappedBy = "Transaction",fetch = FetchType.LAZY)
private List<TransactionTypeEntity> TransactionType=new ArrayList<>();
    @Column(name="Note")
private String  Note;
public int getIdTransaction() {
	return IdTransaction;
}
public void setIdTransaction(int idTransaction) {
	IdTransaction = idTransaction;
}

    public UserEntity getUser() {
        return User;
    }

    public void setUser(UserEntity user) {
        User = user;
    }

    public CustomerEntity getCustomer() {
        return Customer;
    }

    public void setCustomer(CustomerEntity customer) {
        Customer = customer;
    }

    public List<TransactionTypeEntity> getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(List<TransactionTypeEntity> transactionType) {
        TransactionType = transactionType;
    }

    public String getNote() {
	return Note;
}
public void setNote(String note) {
	Note = note;
}
}
