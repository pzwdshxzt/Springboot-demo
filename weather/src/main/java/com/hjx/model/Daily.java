package com.hjx.model;
/** 
*   预计
* Created by hjx on  2017年9月1日 下午2:43:20 
*/

import java.util.Set;

public class Daily {

	
	private String date;
	private String week;
	private String sunrise;
	private String sunset;
	private Weather night;
	private Weather day;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getSunrise() {
		return sunrise;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public String getSunset() {
		return sunset;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
	public Weather getNight() {
		return night;
	}
	public void setNight(Weather night) {
		this.night = night;
	}
	public Weather getDay() {
		return day;
	}
	public void setDay(Weather day) {
		this.day = day;
	}
	
	
	
}
