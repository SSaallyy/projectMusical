package com.Musical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ManagerImpl implements Manager{

	BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

	HashMap<String, CustomerVO> customerMap = null;
	HashMap<String, TitleVO> titleMap = null;


	public ManagerImpl(HashMap<String, CustomerVO> customerMap, HashMap<String, TitleVO> titleMap) {
		this.customerMap = customerMap;
		this.titleMap = titleMap;
	}

	public void menu() {
		int num;
		while(true) {
			try {
				do {
					System.out.println(" ===========================================================================");
					System.out.println("ㅣ                ㅡㅡㅡㅡㅡㅡ     ㅡㅡㅡㅡㅡㅡ     ㅡㅡㅡㅡㅡㅡ           ㅣ");                                                  
					System.out.println("ㅣ               ㅣ1.회원조회ㅣ   ㅣ2.예매현황ㅣ   ㅣ3.매출 조회ㅣ         ㅣ");
					System.out.println("ㅣ                ㅡㅡㅡㅡㅡㅡ     ㅡㅡㅡㅡㅡㅡ     ㅡㅡㅡㅡㅡㅡ           ㅣ");
					System.out.println("ㅣ                      ㅡㅡㅡㅡㅡㅡㅡ        ㅡㅡㅡㅡ                     ㅣ");
					System.out.println("ㅣ                     ㅣ4.뮤지컬 추가ㅣ     ㅣ5.메인ㅣ                    ㅣ");
					System.out.println("ㅣ                      ㅡㅡㅡㅡㅡㅡㅡ        ㅡㅡㅡㅡ                     ㅣ");
					System.out.println(" ===========================================================================");
					num =Integer.parseInt(br.readLine());
				}while(num<1 || 5<num);

				switch(num) {
				case 1 :
					searchCustomer(); break;
				case 2 : 
					reserveTicket(); break;
				case 3 :
					totalSale(); break;
				case 4:
					addMusical(); break;
				default :
//					System.out.println("종료되었습니다.");
//					메인으로 가기로 바꿔서 주석처리
					return;
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}

	@Override
	public void searchCustomer() {	

		Iterator<String> it = customerMap.keySet().iterator();

		while(it.hasNext()) {
			CustomerVO vo = customerMap.get(it.next());
			System.out.println(vo.toString());
		}
	}

	@Override
	public void reserveTicket() {
		
		for (String strKey : customerMap.keySet()) {
			
			if(customerMap.get(strKey).getPh().size() > 0) {
				customerMap.get(strKey).printTicket();
			}
		}
	}

	@Override
	public void totalSale() {
		
		try {
			System.out.println(" ===========================================================================");
			System.out.println("                       <매출을 볼 뮤지컬을 선택해주세요>");
			System.out.println(" ===========================================================================");
			
			ArrayList<String> arrTitle = new ArrayList<>();
			int idx = 1;
			for (String strKey : titleMap.keySet()) {
				System.out.println(idx++ + ". " + strKey);
				arrTitle.add(strKey);
			}
			String inputNumber = br.readLine();
			
			TitleVO tv = titleMap.get(arrTitle.get(Integer.parseInt(inputNumber) - 1));
			
			System.out.println(tv.getTitle() + "의 총 매출은 " + tv.getTotalSales() + "원 입니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void addMusical() {
		try {
			
			String musicalTitle = null;
			String actorPairs1 = null;
			String actorPairs2 = null;
			
			System.out.println(" ===========================================================================");
			System.out.println("                     <추가할 뮤지컬의 이름을 입력하세요>");
			System.out.println(" ===========================================================================");
			musicalTitle = br.readLine();
			
			System.out.println(" ===========================================================================");
			System.out.println("                  <배우 조합1 을 입력하세요. [이정민,시연]>");
			System.out.println(" ===========================================================================");
			actorPairs1 = br.readLine();
			
			System.out.println(" ===========================================================================");
			System.out.println("                  <배우 조합2 를 입력하세요. [정민,안시연]>");
			System.out.println(" ===========================================================================");
			actorPairs2 = br.readLine();
			
			
//			임시로 데이터 가져와서 넣어줘서 생선만 해줌
			String [] arrTime = {"11:00","15:00","19:30"};
			String [] arrDate = {"7/1(금)","7/2(토)","7/3(일)"};
			int [] arrCost = {10000,20000,30000};
			
		
			TitleVO vo = new TitleVO(musicalTitle, actorPairs1, actorPairs2, arrDate, arrTime, arrCost[2]);
			
			titleMap.put(vo.getTitle(), vo);
			
//			이 아래는 원래라면 추가해야하는데 구조를 바꿔야 할 것 같아서 일단 보류
//			System.out.println("날짜1 을 입력하세요.");
//			System.out.println("날짜2 을 입력하세요.");
//			System.out.println("날짜3 을 입력하세요.");
//			
//			System.out.println("시간1 을 입력하세요.");
//			System.out.println("시간2 을 입력하세요.");
//			System.out.println("시간3 을 입력하세요.");
//			System.out.println("티켓 가격을 입력하세요.");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
