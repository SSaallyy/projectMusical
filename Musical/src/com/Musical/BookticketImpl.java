package com.Musical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BookticketImpl implements Bookticket{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	String selectedTitle = null;
	BookticketVO paymentHistory = new BookticketVO();
	HashMap<String, TitleVO> titleMap = null;

	public BookticketImpl(HashMap<String, TitleVO> pTitleMap) {
		this.titleMap = pTitleMap;
	}

	public BookticketVO enterBookticket(){
		try {
			selectMusical();
			selectActor();
			selectDate();
			selectTime();
			selectSeat();
			payment();
		} catch (Exception e) {
			//TODO: handle exception
		}

		System.out.println();
		System.out.println("나의 예매 내역");
		System.out.println(paymentHistory.toString());

		return paymentHistory;
	}

	@Override
	public void selectMusical() {
		ArrayList<String> arrTitle = new ArrayList<>();
		System.out.println("===========================================================================");
		System.out.println("                           <작품을 선택하세요>");
		System.out.println("===========================================================================");

		int titleIdx = 1;

		for (String strKey : titleMap.keySet()) {
			System.out.println(titleIdx++ + ". " + strKey);
			arrTitle.add(strKey);
		}

		String selectedTitle = arrTitle.get(Integer.parseInt(inputSelect()) - 1);

		paymentHistory.setTitle(selectedTitle);
		System.out.println(selectedTitle + "을 선택하셨습니다.");
		this.selectedTitle = selectedTitle;
	}

	@Override
	public void selectActor() {
		System.out.println("===========================================================================");
		System.out.println("                         <배우 조합을 선택하세요>");
		System.out.println("===========================================================================");

		System.out.println("1. " + titleMap.get(selectedTitle).getActorPairs1());
		System.out.println("2. " + titleMap.get(selectedTitle).getActorPairs2());

		if(inputSelect().equals("1")) {
			paymentHistory.setActor(titleMap.get(selectedTitle).getActorPairs1());
		}
		else {
			paymentHistory.setActor(titleMap.get(selectedTitle).getActorPairs2());
		}
		System.out.println(paymentHistory.getActor() + "을 선택하셨습니다.");
	}

	public void selectDate() {
		select("날짜", titleMap.get(selectedTitle).getDate());
	}

	@Override
	public void selectTime() {
		select("시간", titleMap.get(selectedTitle).getTime());
	}

	@Override
	public void payment() {
		paymentHistory.setCost(titleMap.get(selectedTitle).getCost());
		System.out.println("가격은 " + paymentHistory.getCost() + " 원 입니다.");
		System.out.println("결제 됐습니다.");
		titleMap.get(selectedTitle).setTotalSales(paymentHistory.getCost());
	}

	//현재는 미구현 상태
	@Override
	public void selectSeat() {
		String[] seatState = titleMap.get(selectedTitle).getStateOfSeat();
		System.out.println("===========================================================================");
		System.out.println("                           <좌석을 선택하세요>");
		System.out.println("===========================================================================");
		seatDraw(seatState);
		String selected;
		while(true) {
			
			selected = inputSelect();
			
			if(seatState[Integer.valueOf(selected) - 1] == "■") {
				System.out.println("선택할 수 없는 좌석입니다.");
			}
			else {
				break;
			}
		}
		
		seatState[Integer.valueOf(selected) - 1] = "■";

		System.out.println(selected + "번을 선택하셨습니다.");
		paymentHistory.setSeat(selected);
	}


/////////아래로는 헬퍼메서드
	
	public void select(String pStr, String[] pArr){
		System.out.println("===========================================================================");
		System.out.println("                        <"+pStr + "을(를) 선택하세요>");
		System.out.println("===========================================================================");

		int titleIdx = 1;

		for (String strKey : pArr) {
			System.out.println(titleIdx++ + ". " + strKey);
		}

		String selected = pArr[Integer.parseInt(inputSelect()) - 1];

		System.out.println(selected + "을 선택하셨습니다.");

		if(pStr.equals("날짜")){
			paymentHistory.setDate(selected);
		}
		else {
			paymentHistory.setTime(selected);
		}
	}

	void seatDraw(String[] pSeat){
		System.out.println(" ㅡㅡㅡㅡㅡㅡ");
		System.out.printf("| %s | %s | %s |\n", pSeat[0], pSeat[1], pSeat[2]);
		System.out.println(" ㅡㅡㅡㅡㅡㅡ");
		System.out.printf("| %s | %s | %s |\n", pSeat[3], pSeat[4], pSeat[5]);
		System.out.println(" ㅡㅡㅡㅡㅡㅡ");
		System.out.printf("| %s | %s | %s |\n", pSeat[6], pSeat[7], pSeat[8]);
		System.out.println(" ㅡㅡㅡㅡㅡㅡ");
	}
	
	String inputSelect(){
		try {
			String inputValue = br.readLine();
			return inputValue;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}

}
