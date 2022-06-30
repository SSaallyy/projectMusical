package com.Musical;

//시연
import java.io.*;
import java.util.HashMap;


/*
 -수정 필요
1. 현재 뮤지컬의 데이터 구조는 하나의 작품에서, 날짜,배우,시간 을 모두 다르게 선택해도 실제로는 하나의 뮤지컬로 판단해서 좌석이 겹치게 나옴
 	1-1. 뮤지컬의 데이터구조는 하나의 뮤지컬이 배우+날짜+시간 을 여러개 들고 있는 구조로 바꿔야 할듯
2. TitleVO의 toString()오버라이딩 메서드를 쓰는 부분이 한 군데도 없는 것 같다. 확인 후 없다면 삭제 혹은 수정.


 -수정 완료
1. 변수명과 메서드명 수정
 1-1. 내 기준에서(영운) 최대한 가독성 좋도록 했지만.. 부족하고 어색한 부분도 있고, 전부 고치지는 못함.
2. 회원가입을 새로하면 종료 시 해당 데이터도 저장됨.(단. 제대로 종료버튼으로 종료했을 시)
3. 관리자 로그인 후 종료버튼 누르면 종료가 되어서 다시 메인 메뉴로 돌아오게 만듬.
	1-1. 출력은 "종료되었습니다" 로 나와서 지우고 메뉴 이름을 "메인으로" 로 바꿈
4. 관리자 메뉴에서 "뮤지컬 추가"를 만듬. 다만 아직 수정필요사항에서 1번을 수정하지 않아서 날짜,배우,시간,좌석 등의 문제가 있음.
	
*/


public class MusicalMain {
	static BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		DataImpl database = new DataImpl();

		HashMap<String, CustomerVO> customerMap = database.getcustomerDB();
		HashMap<String, TitleVO> titleMap = database.gettitleDB();

		ManagerImpl manager = new ManagerImpl(customerMap, titleMap);
		CustomerImpl customer = new CustomerImpl(customerMap, titleMap); 
		MusicalMain mainObject = new MusicalMain();
		
		System.out.println(" ===========================================================================");
		System.out.println(" ======  =====  ==  ====  ===      ===    ====     ======  =====  ==========\n"
				+ " ======   ===   ==  ====  ==  ====  ===  ====  ===  ====    ====  ==========\n"
				+ " ======  =   =  ==  ====  ==  ====  ===  ===  =========  ==  ===  ==========\n"
				+ " ======  == ==  ==  ====  ===  ========  ===  ========  ====  ==  ==========\n"
				+ " ======  =====  ==  ====  =======  ====  ===  ========        ==  ==========\n"
				+ " ======  =====  ==  ====  ==  ====  ===  ===  ========  ====  ==  ==========\n"
				+ " ======  =====  ==   ==   ==  ====  ===  ====  ===  ==  ====  ==  ==========\n"
				+ " ======  =====  ===      ====      ===    ====     ===  ====  ==        ====");
		System.out.println(" ===========================================================================");
		int num;
		while(true) {

			do {
				System.out.println();
				System.out.println();
				System.out.println(" ===========================================================================");
				System.out.println("ㅣ             ㅡㅡㅡㅡㅡ          ㅡㅡㅡㅡㅡㅡ             ㅡㅡㅡㅡ       ㅣ");                                                  
				System.out.println("ㅣ            ㅣ1.로그인ㅣ        ㅣ2.회원가입ㅣ           ㅣ3.종료ㅣ      ㅣ");
				System.out.println("ㅣ             ㅡㅡㅡㅡㅡ          ㅡㅡㅡㅡㅡㅡ             ㅡㅡㅡㅡ       ㅣ");
				System.out.println(" ===========================================================================");
				num = Integer.parseInt(br.readLine());
			}while(num<1 || 3<num);


			switch(num) {
			case 1 :
				mainObject.login(customerMap, manager, customer); break;
			case 2 : 
				mainObject.signUp(customerMap); break;
			case 3 :
				database.saveData();
				database.saveTitle();
				System.out.println("종료되었습니다.");
				System.exit(0);
			}
		}
	}
	public void login(HashMap<String, CustomerVO> customerMap, ManagerImpl manager, CustomerImpl customer) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		String id,pw;

		do{
			System.out.println("아이디?");
			id = br.readLine();

			if(!customerMap.containsKey(id)) {
				System.out.println("존재하지 않는 아이디 입니다.");
			}else {break;}				
		}while(true);

		System.out.println("비밀번호를 입력하세요.");

		do{
			pw = br.readLine();
			//do{
			if(!customerMap.get(id).getPw().equals(pw)) {
				System.out.println("비밀번호를 확인 해주세요");
				//pw = br.readLine();
			}else {
				if(id.equals("admin") && pw.equals("1111")) {
					manager.menu();
					break;
				}
				else {
					System.out.println("로그인 성공!");
					customer.succesLogIn(id);
					break;
				}
			}				
		}while(true);

	}

	public void signUp(HashMap<String, CustomerVO> customerMap) {

		SignUpException exp = new SignUpException();


		CustomerVO vo = new CustomerVO();

		while(true) {
			try {
				System.out.println("아이디를 입력하세요.");
				String id = br.readLine();
				exp.inputFormat(id);
				vo.setId(id);
				break;

			} catch (Exception e) {
				System.out.println(e.toString());     
			}
		}

		try {
			System.out.println("비밀번호를 입력하세요.");
			String pw = br.readLine();

			System.out.println("비밀번호를 재확인해주세요.");
			do {
				String pw2 = br.readLine();

				if(pw.equals(pw2)) {
					vo.setPw(pw2); break;
				}
				else {
					System.out.println("비밀번호가 다릅니다.다시입력해주세요.");
				}
			}while(true);
		} catch (Exception e) {
			System.out.println(e.toString());     
		}
		try {
			System.out.println("이름?");
			String name = br.readLine();
			vo.setName(name);
		} catch (Exception e) {
			System.out.println(e.toString());     
		}

		while(true) {
			try {
				System.out.println("성별? [F/M]");
				String gender = br.readLine(); 
				exp.genderInputFormat(gender);
				vo.setGender(gender);
				break;

			} catch (Exception e) {
				System.out.println(e.toString());     
			}
		}

		while(true) {
			try {
				System.out.println("생년월일?[yyyy-mm-dd]");
				String birth = br.readLine();
				exp.birthInputFormat(birth);
				vo.setBirth(birth);
				break;

			} catch (Exception e) {
				System.out.println(e.toString());     
			}
		}


		while(true) {
			try {
				System.out.println("이메일 주소?");
				String mail = br.readLine();
				exp.mailInputFormat(mail);
				vo.setMail(mail);
				break;

			} catch (Exception e) {
				System.out.println(e.toString());     
			}
		}


		while(true) {
			try {
				System.out.println("핸드폰 번호?[010-xxxx-xxxx]");
				String phone = br.readLine();
				exp.telInputFormat(phone);
				vo.setPhone(phone);
				break;

			} catch (Exception e) {
				System.out.println(e.toString());     
			}
		}
		System.out.println(" ===========================================================================");
		System.out.println("                               회원가입 성공 !");
		System.out.println(" ===========================================================================");

		customerMap.put(vo.getId(), vo);

	}
}