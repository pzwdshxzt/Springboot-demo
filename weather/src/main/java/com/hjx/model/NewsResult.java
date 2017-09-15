package com.hjx.model;

import java.util.Set;

public class NewsResult {

	
	private String stat;
	private Set<News> data;
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public Set<News> getData() {
		return data;
	}
	public void setData(Set<News> data) {
		this.data = data;
	}
	
	
}
