package com.BuildingWeb.Entity;

public class TransactionTypeEntity {
private int IdTransactionType;
private String Code;
private String TransactionTypeName;
private int IdTransaction;
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
public int getIdTransaction() {
	return IdTransaction;
}
public void setIdTransaction(int idTransaction) {
	IdTransaction = idTransaction;
}
}
