package com.Musical;

public interface Customer {
	
	
	public void succesLogIn(String pLogInCustomer);
	public void updateCustomerInfo();
	public void reserveMusical();
	public void reserveHistory();
	public boolean logout();
	public boolean deleteCustomerInfo();
	
//	현재 미구현 구현할지 선택
//	public boolean searchID(String id);
	
}
