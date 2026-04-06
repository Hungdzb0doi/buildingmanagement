package com.BuildingWeb.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer")
public class CustomerEntity {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="IdCustomer")
private int IdCustomer;
@Column(name="CustomerName")
private String CustomerName;
@Column(name = "Phone")
private String Phone;
@Column(name="Email")
private String Email;
@OneToMany(mappedBy = "Customer",fetch = FetchType.LAZY)
private List<AssigmentCustomerEntity> AssigmentCustomer = new ArrayList<AssigmentCustomerEntity>();
@OneToMany(mappedBy = "Customer",fetch =  FetchType.LAZY)
private List<TransactionEntity> Transaction = new ArrayList<>();
public int getIdCustomer() {
	return IdCustomer;
}
public void setIdCustomer(int idCustomer) {
	IdCustomer = idCustomer;
}
public String getCustomerName() {
	return CustomerName;
}
public void setCustomerName(String customerName) {
	CustomerName = customerName;
}
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	Phone = phone;
}
public String getEmail() {
	return Email;
}
    public void setEmail(String email) {
	Email = email;
}

    public List<AssigmentCustomerEntity> getAssigmentCustomer() {
        return AssigmentCustomer;
    }

    public void setAssigmentCustomer(List<AssigmentCustomerEntity> assigmentCustomer) {
        AssigmentCustomer = assigmentCustomer;
    }

    public List<TransactionEntity> getTransaction() {
        return Transaction;
    }

    public void setTransaction(List<TransactionEntity> transaction) {
        Transaction = transaction;
    }
}
