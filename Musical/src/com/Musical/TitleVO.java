package com.Musical;

import java.io.Serializable;

public class TitleVO implements Serializable{
	
	private String title;
	private String actorPairs1;
	private String actorPairs2;
	private String[] date;
	private String[] time;
	private int curReservationsNumber;
	private int maxReservationsNumber;
	private String[] stateOfSeat;
	private int cost;
	private int totalSales;
	
	public TitleVO() {
		defaultSetting();
	}
	
	public TitleVO(String title, String actorPairs1, String actorPairs2, String[] date, String[] time, int cost) {
		this.title = title;
		this.actorPairs1 = actorPairs1;
		this.actorPairs2 = actorPairs2;
		this.date = date;
		this.time = time;
		this.cost = cost;
		defaultSetting();
	}
	
	public void defaultSetting(){
		curReservationsNumber = 0;
		maxReservationsNumber = 9;
		stateOfSeat = new String[9];
		for (int i = 0; i < maxReservationsNumber; i++) {
			stateOfSeat[i] = String.valueOf(i + 1);
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getActorPairs1() {
		return actorPairs1;
	}

	public void setActorPairs1(String actorPairs1) {
		this.actorPairs1 = actorPairs1;
	}

	public String getActorPairs2() {
		return actorPairs2;
	}

	public void setActorPairs2(String actorPairs2) {
		this.actorPairs2 = actorPairs2;
	}

	public String[] getTime() {
		return time;
	}

	public void setTime(String[] time) {
		this.time = time;
	}

	public String[] getDate() {
		return date;
	}
	
	public void setDate(String[] date) {
		this.date = date;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCurReservationsNumber() {
		return curReservationsNumber;
	}

	public void setCurReservationsNumber(int curReservationNumber) {
		this.curReservationsNumber = curReservationNumber;
	}

	public int getMaxReservationsNumber() {
		return maxReservationsNumber;
	}

	public void setMaxReservationsNumber(int maxReservationNumber) {
		this.maxReservationsNumber = maxReservationNumber;
	}

	public String[] getStateOfSeat() {
		return stateOfSeat;
	}

	public void setStateOfSeat(String[] stateSeat) {
		this.stateOfSeat = stateSeat;
	}
	
	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales += totalSales;
	}

	@Override
	public String toString() {
		String str = String.format("%-12s %-4s %-5s %2s %5s %5s %5s %5s %5s %d %d",title,actorPairs1,actorPairs2,
				time[0],time[1],time[2],date[0],date[1],date[2],cost, totalSales);
		
		return null;
	}

}
