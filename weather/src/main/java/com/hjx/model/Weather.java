package com.hjx.model;
/** 
*   天气情况
* Created by hjx on  2017年9月1日 下午2:41:27 
*/
public class Weather {

	
	private String weather;
	private String templow;
	private String temphigh;
	private String img;
	private String winddirect;
	private String windpower;
	
	
	public String getTemphigh() {
		return temphigh;
	}
	public void setTemphigh(String temphigh) {
		this.temphigh = temphigh;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTemplow() {
		return templow;
	}
	public void setTemplow(String templow) {
		this.templow = templow;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getWinddirect() {
		return winddirect;
	}
	public void setWinddirect(String winddirect) {
		this.winddirect = winddirect;
	}
	public String getWindpower() {
		return windpower;
	}
	public void setWindpower(String windpower) {
		this.windpower = windpower;
	}
	
	
}
