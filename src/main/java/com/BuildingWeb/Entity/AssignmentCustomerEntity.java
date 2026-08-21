package com.BuildingWeb.Entity;



import jakarta.persistence.*;

@Entity
@Table(name="assignmentcustomer")
public class AssignmentCustomerEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
private Long idAssignmentcustomer;
@ManyToOne
@JoinColumn(name="IdUser")
private UserEntity user;
@ManyToOne
@JoinColumn(name="IdCustomer")
private CustomerEntity customer;

    public Long getIdAssignmentcustomer() {
        return idAssignmentcustomer;
    }

    public void setIdAssignmentcustomer(Long idAssignmentcustomer) {
        this.idAssignmentcustomer = idAssignmentcustomer;
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
}
