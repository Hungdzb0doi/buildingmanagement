package com.BuildingWeb.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="IdUser")
private int IdUser;
@Column(name="UserName")
private String UserName;
@Column(name="Password")
private String Password;
@OneToMany(mappedBy="User",fetch=FetchType.LAZY)
private List<AssigmentCustomerEntity> AssigmentCustomer=new ArrayList<>();
@OneToMany(mappedBy = "User",fetch=FetchType.LAZY)
private List<UserRoleEntity> UserRole=new ArrayList<>();
@OneToMany(mappedBy = "User",fetch=FetchType.LAZY)
private List<TransactionEntity> Transaction=new ArrayList<>();
    public List<AssigmentCustomerEntity> getAssigmentCustomer() {
        return AssigmentCustomer;
    }

    public void setAssigmentCustomer(List<AssigmentCustomerEntity> assigmentCustomer) {
        AssigmentCustomer = assigmentCustomer;
    }

    public List<UserRoleEntity> getUserRole() {
        return UserRole;
    }

    public void setUserRole(List<UserRoleEntity> userRole) {
        UserRole = userRole;
    }

    public List<TransactionEntity> getTransaction() {
        return Transaction;
    }

    public void setTransaction(List<TransactionEntity> transaction) {
        Transaction = transaction;
    }

    public int getIdUser() {
	return IdUser;
}
public void setIdUser(int idUser) {
	IdUser = idUser;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
}

