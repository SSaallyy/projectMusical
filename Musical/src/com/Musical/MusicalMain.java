package com.Musical;

//시연
import java.io.*;
import java.util.HashMap;


public class MusicalMain {
	static BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		DataImpl di = new DataImpl();

		HashMap<String, CustomerVO> customerMap = di.getCustomerMap();
		HashMap<String, TitleVO> titleMap = di.getTitleMap();

		ManagerImpl implM = new ManagerImpl(customerMap, titleMap);
		CustomerImpl implC = new CustomerImpl(customerMap, titleMap); 


		int num;

		MusicalMain mm = new MusicalMain();
		System.out.println("===================================================================");
		System.out.println("=  =====  ==  ====  ===      ===    ====     ======  =====  =======\n"
				+ "=   ===   ==  ====  ==  ====  ===  ====  ===  ====    ====  =======\n"
				+ "=  =   =  ==  ====  ==  ====  ===  ===  =========  ==  ===  =======\n"
				+ "=  == ==  ==  ====  ===  ========  ===  ========  ====  ==  =======\n"
				+ "=  =====  ==  ====  =======  ====  ===  ========        ==  =======\n"
				+ "=  =====  ==  ====  ==  ====  ===  ===  ========  ====  ==  =======\n"
				+ "=  =====  ==   ==   ==  ====  ===  ====  ===  ==  ====  ==  =======\n"
				+ "=  =====  ===      ====      ===    ====     ===  ====  ==        =\n");
		System.out.println("===================================================================");

		while(true) {

			do {
				System.out.println(" ==================================================================");
				System.out.println("ㅣ           ㅡㅡㅡㅡㅡ        ㅡㅡㅡㅡㅡㅡ        ㅡㅡㅡㅡ       ㅣ");                                                  
				System.out.println("ㅣ          ㅣ1.로그인ㅣ      ㅣ2.회원가입ㅣ      ㅣ3.종료ㅣ      ㅣ");
				System.out.println("ㅣ           ㅡㅡㅡㅡㅡ        ㅡㅡㅡㅡㅡㅡ        ㅡㅡㅡㅡ       ㅣ");
				System.out.println(" ==================================================================");
				num = Integer.parseInt(br.readLine());
			}while(num<1 || 3<num);


			switch(num) {
			case 1 :
				mm.login(customerMap, implM, implC); break;
			case 2 : 
				mm.signUp(customerMap); break;
			case 3 :
				di.saveData();
				System.out.println("종료되었습니다.");
				System.exit(0);
			}
		}
	}
	public void login(HashMap<String, CustomerVO> customerMap, ManagerImpl implM, CustomerImpl implC) throws IOException {
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
					implM.menu();
					break;
				}
				else {
					System.out.println("로그인 성공!");
					implC.succesLogIn(id);
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
		System.out.println("===================================================================");
		System.out.println("                          회원가입 성공 !");
		System.out.println("===================================================================");

		customerMap.put(vo.getId(), vo);

	}
}