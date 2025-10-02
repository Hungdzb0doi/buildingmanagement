package com.BuildingWeb.Entity;

public class TransactionEntity {
private int IdTransaction;
private int IdUser;
private int IdCustomer;
private String  Note;
public int getIdTransaction() {
	return IdTransaction;
}
public void setIdTransaction(int idTransaction) {
	IdTransaction = idTransaction;
}
public int getIdUser() {
	return IdUser;
}
public void setIdUser(int idUser) {
	IdUser = idUser;
}
public int getIdCustomer() {
	return IdCustomer;
}
public void setIdCustomer(int idCustomer) {
	IdCustomer = idCustomer;
}
public String getNote() {
	return Note;
}
public void setNote(String note) {
	Note = note;
}
}
