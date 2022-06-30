package com.Musical;

public class SignUpException {

	public void inputFormat(String str) throws Exception {

		if(str.length()<8 || 15< str.length()) {

			throw new Exception("8자 이상 15자 이하로 작성해주세요");
		}

		int num = 0,eng = 0;
		for(int i=0;i<str.length();i++) {
			if('0'<=str.charAt(i) && str.charAt(i)<='9') {
				num++;
			}else if((str.charAt(i)>='a' && 'z' >= str.charAt(i)) ||
					(str.charAt(i)>='A' && 'Z' >= str.charAt(i))) {
				eng++;
			}

		}

		if(num ==0 || eng==0) {
			throw new Exception("영대소문자와 숫자를 혼용해야합니다.");
		}	

	}

	public void nameInputFormat(String str) throws Exception {

		if(str.length()<2 || 6<str.length())
			throw new Exception("저장할수 없는 양식입니다.");

	}

	public void genderInputFormat(String str) throws Exception {
		char ch = str.charAt(0);

		if(ch !='m' && ch !='M' && ch !='F' && ch!='f') {

			throw new Exception("M과 F로만 입력해주세요.");
		}	
	}
     
	//[yyyy-mm-dd] 이형태로 입력할 수 있게 예외처리하기 : 정민 (완료)
	public void birthInputFormat(String str) throws Exception {

		boolean flag = false;
		
		if(str.charAt(4)=='-' && str.charAt(7)=='-')
			flag = true;
		if(!flag)
			throw new Exception("잘못된 생년월일 형식입니다");

	
			int year =Integer.parseInt(str.substring(0, 4));
		
			if(year<0 || 2021<year) 
				throw new Exception("잘못된 년도입니다.");
			
			int month =  Integer.parseInt(str.substring(5,7));
			if(month<00 || month>12) 
				throw new Exception("잘못된 월입니다.");
			
			int day = Integer.parseInt(str.substring(8,10));
			if(day<00 || day>31) {
				throw new Exception("잘못된 일입니다.");
			
			}

		}


	
//이메일 예외처리 완료 (정민)
	public void mailInputFormat (String str) throws Exception {
		
		int su1=0;
		int su2=0;
		int num = str.indexOf("@");
		int num1 = str.indexOf(".");
		int num3=0;
		int eng=0;
	

		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='@') {
				su1++;
			}else if(str.charAt(i)=='.') {
				su2++;
			}
		}	
		
		if (su1==0 || su2==0)	
			
			throw new Exception("잘못된 이메일 형식입니다.");
		
	
		for(int i=0;i<=num;i++) {
			if('0'<=str.charAt(i) && str.charAt(i)<='9') {
				num3++;
			}else if((str.charAt(i)>='a' && 'z' >= str.charAt(i)) ||
					(str.charAt(i)>='A' && 'Z' >= str.charAt(i)))  {
				eng++;
			}
		}

		if(num3 ==0 || eng==0) {
			throw new Exception("영문자와 숫자를 혼용해주세요.");
		}
		
		
		for(int i=num+1;i<num1;i++) {
			
			if((str.charAt(i)>='a' && 'z' >= str.charAt(i)) ||
					(str.charAt(i)>='A' && 'Z' >= str.charAt(i))){
			}else {
				throw new Exception ("영문자를 입력해주세요");
			
			}
			
		}
			
		for(int i=num1+1;i<str.length();i++) {
			if((str.charAt(i)>='a' && 'z' >= str.charAt(i)) ||
					(str.charAt(i)>='A' && 'Z' >= str.charAt(i))) {
			}else {	
				throw new Exception ("영문자를 입력해주세요");
			
		}
			
			

}	
	}
	
	
	//[010-xxxx-xxxx] 이형태로 입력할 수 있게 예외처리하기 : 정민 (완료)
	public void telInputFormat(String str) throws Exception {
		
/*		if(str.length()!=13)	{
			
			throw new Exception("잘못된 번호입니다.");
		
		}
*/		
		boolean flag = false;
	
			if(str.charAt(3)=='-' && str.charAt(8)=='-') {
				flag = true;
			}		
		
		if(!flag) {
			throw new Exception("잘못된 핸드폰 번호 형식입니다.");
		}
		
		String number = str.substring(0,3);
		if (!number.equals("010"))
			throw new Exception("잘못된 번호입니다.");

		for(int i=4;i<8;i++) {
			if(!('0'<=str.charAt(i) && str.charAt(i)<='9')) {
				throw new Exception("잘못된 번호입니다.");
			}
			
		}
		
		for(int j=9;j<13;j++) {
			
			if(!('0'<=str.charAt(j) && str.charAt(j)<='9')) {
				
				throw new Exception("잘못된 번호입니다.");
				
			}
		}
	}
	
	
	
}
