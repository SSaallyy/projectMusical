
package com.Musical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;



public class DataImpl implements Data {

	private final String F_USER_LIST = "userData.txt";
	private final String F_TITLE_LIST = "titleData.txt";
	
	String[] arrID = {"GANA11", "JOKER33", "STARBUCKS07","admin"};
	String[] arrPW = {"11111", "22222", "33333","1111"};
	String[] arrName = {"김영운", "이정민", "안시연","관리자"};
	String[] arrBirth = {"1988-11-04", "1994-10-22", "1993-08-25","1111-11-11"};
	String[] arrGender = {"M", "F", "F","F"};
	String[] arrMail = {"GANA@NAVER.COM", "JOKSS@GMAIL.COM", "STA@NAVER.COM","ADMIN@NAVER.COM"};
	String[] arrPhone = {"010-5859-3928", "010-4837-2937", "010-3920-4832","010-1111-1111"};
	String[] arrPoint = {"10000", "10000", "10000","0"};

	//뮤지컬 데이터 입력.정민
	String[] arrTitle = {"오페라의 유령", "레미제라블", "캣츠"};
	String [] arrActorPairs1 = {"아이비,주원","김소현,김준현","김지연,정성화"};
	String [] arrActorPairs2 = {"옥주현,조승우","정선아,박효신","최정원,남경주"};
	String [] arrTime = {"11:00","15:00","19:30"};
	String [] arrDate = {"7/1(금)","7/2(토)","7/3(일)"};
	int [] arrCost = {10000,20000,30000};
	
	
	HashMap<String, CustomerVO> customerDB = new HashMap<>();
	HashMap<String, TitleVO> titleDB = new HashMap<>();

	public DataImpl() {
		loadData();
	}

	public void inputCustomer() {	

		for(int i=0;i<arrID.length;i++) {

			CustomerVO vo = new CustomerVO();

			vo.setId(arrID[i]);
			vo.setPw(arrPW[i]);
			vo.setName(arrName[i]);
			vo.setBirth(arrBirth[i]);
			vo.setGender(arrGender[i]);
			vo.setMail(arrMail[i]);
			vo.setPhone(arrPhone[i]);
			vo.setPoint(arrPoint[i]);

			customerDB.put(arrID[i], vo);
		}
	}
	//정민

	public void inputTitle() {
		for(int i=0;i<arrTitle.length;i++) {

			TitleVO vo = new TitleVO();

			vo.setTitle(arrTitle[i]);
			vo.setActorPairs1(arrActorPairs1[i]);
			vo.setActorPairs2(arrActorPairs2[i]);
			vo.setTime(arrTime);
			vo.setDate(arrDate);
			vo.setCost(arrCost[i]);
			
			titleDB.put(arrTitle[i], vo);
		}
	}

	@Override
	public void saveData() {
		try {
			File f = new File("c:\\Musical\\" + F_USER_LIST);

			if(!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();				
			}

			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(customerDB);
			fos.close();
			oos.close();

		} catch (Exception e) {
			System.out.println(e.toString());}
	}
	
	public void saveTitle() {
		try {
			File f = new File("c:\\Musical\\" + F_TITLE_LIST);

			if(!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();				
			}

			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(titleDB);
			fos.close();
			oos.close();

		} catch (Exception e) {
			System.out.println(e.toString());}
	}

	@Override
	public void loadData() {

		loadFile(F_USER_LIST);
		loadFile(F_TITLE_LIST);
		//		try {
		//			File f = new File("c:\\Musical\\userlist.txt");
		//
		//			if(!f.exists()) {				
		//				inputCustomer();				
		//			}
		//			else {				
		//				FileInputStream fis = new FileInputStream(f);
		//				ObjectInputStream ois = new ObjectInputStream(fis);
		//				
		//				customerDB = (HashMap<String, CustomerVO>)ois.readObject();
		//				
		//				fis.close();
		//				ois.close();
		//				
		//			}
		//
		//		} catch (Exception e) {
		//			System.out.println(e.toString());
		//		}
	}

	void loadFile(String path) {

		try {
			File f = new File("c:\\Musical\\" + path);
			
			if(!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();	
			}
			
			if(path.equals(F_USER_LIST) && !f.exists()) {
				inputCustomer();
				return;
			}
			else if(path.equals(F_TITLE_LIST) && !f.exists()) {
				inputTitle();
				return;
			}

			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			if(path.equals(F_USER_LIST)) {
				customerDB = (HashMap<String, CustomerVO>)ois.readObject();
			}
			else {
				titleDB = (HashMap<String, TitleVO>)ois.readObject();
			}

			fis.close();
			ois.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public HashMap<String, CustomerVO> getcustomerDB() {
		return customerDB;
	}

	public void setcustomerDB(HashMap<String, CustomerVO> customerDB) {
		this.customerDB = customerDB;
	}

	public HashMap<String, TitleVO> gettitleDB() {
		return titleDB;
	}

	public void settitleDB(HashMap<String, TitleVO> titleDB) {
		this.titleDB = titleDB;
	}




}