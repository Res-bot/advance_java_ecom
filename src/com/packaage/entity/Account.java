package com.packaage.entity;

public class Account {
	
int account;

public int getAccount() {
	return account;
}

public void setAccount(int account) {
	this.account = account;
}

public Account(int account) {
	super();
	this.account = account;
}

public Account() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Account [account=" + account + "]";
}
	
	

}
