package com.Musical;

import java.util.HashMap;

public class DataImpl implements Data {

	String[] arrID = {"GANA11", "JOKER33", "STARBUCKS07"};
	String[] arrPW = {"11111", "22222", "33333"};
	String[] arrName = {"�迵��", "������", "�Ƚÿ�"};
	String[] arrBirth = {"1988-11-04", "1994-10-22", "1993-08-25"};
	String[] arrGender = {"M", "F", "F"};
	String[] arrMail = {"GANA@NAVER.COM", "JOKSS@GMAIL.COM", "STA@NAVER.COM"};
	String[] arrPhone = {"010-5859-3928", "010-4837-2937", "010-3920-4832"};
	String[] arrPoint = {"10000", "10000", "10000"};

	//������ ������ �Է�.����
	String[] arrTitle = {"������� ����", "���������", "Ĺ��"};
	String [] arrActor1 = {"���̺�,������","�����,�ֿ�","������,����"};
	String [] arrActor2 = {"������,����","���̺�,������","�����,�ֿ�"};
	String [] arrTime = {"11:00","15:00","19:30"};
	String [] arrDate = {"7/1(��)","7/2(��)","7/3(��)"};


	HashMap<String, CustomerVO> customerMap = new HashMap<>();
	HashMap<String, TitleVO> titleMap = new HashMap<>();


	public DataImpl() {
		inputTitle();
		inputCustomer();
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

			customerMap.put(arrID[i], vo);

		}
	}

	//����

	public void inputTitle() {


		for(int i=0;i<arrTitle.length;i++) {

			TitleVO vo = new TitleVO();


			vo.setTitle(arrTitle[i]);
			vo.setActor1(arrActor1[i]);
			vo.setActor2(arrActor2[i]);
			vo.setTime(arrTime);
			vo.setDate(arrDate);

			titleMap.put(arrTitle[i], vo);

		}
	}

	@Override
	public void saveData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void snycData() {
		// TODO Auto-generated method stub
		
	}

	public HashMap<String, CustomerVO> getCustomerMap() {
		return customerMap;
	}

	public void setCustomerMap(HashMap<String, CustomerVO> customerMap) {
		this.customerMap = customerMap;
	}

	public HashMap<String, TitleVO> getTitleMap() {
		return titleMap;
	}

	public void setTitleMap(HashMap<String, TitleVO> titleMap) {
		this.titleMap = titleMap;
	}

	


}