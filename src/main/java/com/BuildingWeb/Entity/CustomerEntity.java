package com.BuildingWeb.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer")
public class CustomerEntity {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="IdCustomer")
private Long idCustomer;
@Column(name="CustomerName")
private String customerName;
@Column(name = "Phone")
private String phone;
@Column(name="Email")
private String email;
@OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
private List<AssignmentCustomerEntity> assigmentCustomer = new ArrayList<AssignmentCustomerEntity>();
@OneToMany(mappedBy = "customer",fetch =  FetchType.LAZY)
private List<TransactionEntity> transaction = new ArrayList<>();
public Long getIdCustomer() {
	return idCustomer;
}
public void setIdCustomer(Long idCustomer) {
	this.idCustomer = idCustomer;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
    public void setEmail(String email) {
		this.email = email;
}

    public List<AssignmentCustomerEntity> getAssigmentCustomer() {
        return assigmentCustomer;
    }

    public void setAssigmentCustomer(List<AssignmentCustomerEntity> assigmentCustomer) {
        this.assigmentCustomer = assigmentCustomer;
    }

    public List<TransactionEntity> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<TransactionEntity> transaction) {
        this.transaction = transaction;
    }
}
