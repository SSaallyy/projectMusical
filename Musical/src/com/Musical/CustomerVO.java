package com.Musical;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerVO implements Serializable{
	
	String id;
	String pw;
	String name;
	String birth;
	String gender;
	String mail;
	String phone;
	String point;
	ArrayList<BookticketVO> paymentHistoy = null;

	public CustomerVO() {
		paymentHistoy = new ArrayList<>();
	}
	
	public CustomerVO(String id, String pw, String name, String birth, String gender, String mail, String phone) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.mail = mail;
		this.phone = phone;
		paymentHistoy = new ArrayList<>();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public ArrayList<BookticketVO> getPh() {
		return paymentHistoy;
	}
	public void setPh(ArrayList<BookticketVO> pPaymentHistoy) {
		this.paymentHistoy = pPaymentHistoy;
	}

	@Override
	public String toString() {
		String str = String.format("%-12s %-4s %-5s %2s %5s",id,name,birth,gender,phone);
		return str;
	}
	public String printTicket() { 
		System.out.println("\n___________________________________________________________________________");
		System.out.println("<"+name + "님의 예매내역입니다.>");	
		System.out.println("===========================================================================");
		String str = String.format("%10s %13s %10s %8s %6s %6s","제목","배우","날짜","시간","좌석번호","결제금액");
		System.out.println(str);
		System.out.println("===========================================================================");
		int idx = 1;
		
		for (BookticketVO details : paymentHistoy) {
			System.out.println((idx++) + ". "+ details.toString());
		}
		
		return str;
	}
}