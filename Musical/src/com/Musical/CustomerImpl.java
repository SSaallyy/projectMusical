package com.Musical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


public class CustomerImpl implements Customer{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	HashMap<String, CustomerVO> customerMap = null;
	HashMap<String, TitleVO> titleMap = null;
	String curCustomer;
	SignUpException se = new SignUpException();

	public CustomerImpl(HashMap<String, CustomerVO> customerMap, HashMap<String, TitleVO> titleMap) {
		this.customerMap = customerMap;
		this.titleMap = titleMap;
	}
	
	public void succesLogIn(String pLogInCustomer) {
		try {  
			int selectMenu = 0;
			curCustomer = pLogInCustomer;
			while(true){   
				do {
					System.out.println(" ===========================================================================");
					System.out.println("ㅣ                ㅡㅡㅡㅡㅡㅡㅡ    ㅡㅡㅡㅡㅡㅡ     ㅡㅡㅡㅡㅡㅡㅡㅡ      ㅣ");                                                  
					System.out.println("ㅣ               ㅣ1.내정보수정ㅣ  ㅣ2.예매하기ㅣ  ㅣ3.예매내역 조회ㅣ     ㅣ");
					System.out.println("ㅣ                ㅡㅡㅡㅡㅡㅡㅡ    ㅡㅡㅡㅡㅡㅡ    ㅡㅡㅡㅡㅡㅡㅡㅡ       ㅣ");
					System.out.println("ㅣ                        ㅡㅡㅡㅡㅡㅡ        ㅡㅡㅡㅡㅡㅡ                 ㅣ");
					System.out.println("ㅣ                       ㅣ4.로그아웃ㅣ      ㅣ5.회원탈퇴ㅣ                ㅣ");
					System.out.println("ㅣ                        ㅡㅡㅡㅡㅡㅡ        ㅡㅡㅡㅡㅡㅡ                 ㅣ");
					System.out.println(" ===========================================================================");
					selectMenu = Integer.parseInt(br.readLine());
				}while(selectMenu<1||selectMenu>5);


				switch (selectMenu) {

				case(1):updateCustomerInfo();break;
				case(2):reserveMusical();break;
				case(3):reserveHistory();break;
				case(4):logout();return;
				case(5):deleteCustomerInfo();return;
            
				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	

	@Override
	public void updateCustomerInfo() {

		try {

			System.out.print("비밀번호를 입력해주세요");
			String changepw = (br.readLine());

			CustomerVO vo = customerMap.get(curCustomer);

			if(!vo.getPw().equals(changepw)){
				System.out.println("비밀번호가 틀렸습니다");
				return;
			}else {
				System.out.println("비밀번호 인증 완료");
			}

			System.out.println("수정하고싶은 회원정보를 선택하세요");
			System.out.println("1.비밀번호 \n2.이메일 \n3.핸드폰번호");
			int num2 = (Integer.parseInt(br.readLine()));

			boolean flag = false;

			switch (num2) {
			case 1:
				System.out.println("수정할 비밀번호?");
				vo.setPw(br.readLine());flag = true; 
				break;

			case 2:

				while(true) {
					try { System.out.println("수정할 이메일?");
					vo.setMail(br.readLine());
					se.mailInputFormat(vo.getMail());
					flag = true;
					break;

					} catch (Exception e) {
						System.out.println(e.toString());
					}
				}
				break;

			case 3:

				while(true) {

					try {System.out.println("수정할 핸드폰 번호?");
					vo.setPhone(br.readLine());
					se.telInputFormat(vo.getPhone());
					flag = true;
					break;

					} catch (Exception e) {
						System.out.println(e.toString());
					}
				}
				break;

			default:
				flag = false; break;
			}

			if(flag) {
				customerMap.put(curCustomer, vo);
				System.out.println("수정 완료!");
			}else {
				System.out.println("번호를 다시 입력하세요"); 
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Override
	public void reserveMusical() {
		BookticketImpl bk = new BookticketImpl(titleMap);
		customerMap.get(curCustomer).getPh().add(bk.enterBookticket());
	}

	@Override
	public void logout() {
		
		try {
			System.out.println("로그아웃 하시겠습니까?[Y/N]");
			String answer = br.readLine();

			if(answer.equals("Y") || answer.equals("y")) {
				System.out.println("로그아웃이 완료되었습니다");

			}else if(answer.equals("N") || answer.equals("n")) {
				return;
			}else {
				System.out.println("다시 입력해주세요");
				return;
			}

		} catch (Exception e) {

		}
	}

	@Override
	public void deleteCustomerInfo() {
		try {

			System.out.print("탈퇴하시겠습니까?[Y/N]");
			String yn = br.readLine();

			if(yn.equals("Y") || yn.equals("y")) {
				customerMap.remove(curCustomer);
				System.out.println("회원탈퇴가 완료되었습니다");
			}else if(yn.equals("N") || yn.equals("n")) {
				return;
			}else {
				System.out.println("다시 입력해주세요");
				return;
			}
		
		
	
		} catch (Exception e) {

		}
	}
	
	@Override
	public void reserveHistory() {
		customerMap.get(curCustomer).printTicket();
	}

	
	//구현할지 말지 선택
	
	/*@Override
	public boolean searchID(String id) {

		return customerMap.containsKey(id);

	}
	*/
}