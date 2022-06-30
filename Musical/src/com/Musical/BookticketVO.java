package com.Musical;

import java.io.Serializable;

public class BookticketVO implements Serializable {
	String title;
	String actor;
	String date;
	String time;
	String seat;
	int cost;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	@Override
	public String toString() {
		String str = String.format("%-10s %-10s %-8s %7s %5s %12d",title, actor, date, time, seat, cost);
		return str;
	}
}

