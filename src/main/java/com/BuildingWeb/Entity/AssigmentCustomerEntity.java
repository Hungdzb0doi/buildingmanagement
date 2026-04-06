package com.BuildingWeb.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="assignmentcustomer")
public class AssigmentCustomerEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
private int Idassignmentcustomer;
@ManyToOne
@JoinColumn(name="IdUser")
private UserEntity User;
@ManyToOne
@JoinColumn(name="IdCustomer")
private CustomerEntity Customer;

    public int getIdassignmentcustomer() {
        return Idassignmentcustomer;
    }

    public void setIdassignmentcustomer(int idassignmentcustomer) {
        Idassignmentcustomer = idassignmentcustomer;
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
}
