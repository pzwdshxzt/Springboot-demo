package com.hjx.model;

import java.util.Set;

public class CityA {

	private String status;
	private String msg;
	private Set<CityInfo> result;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Set<CityInfo> getResult() {
		return result;
	}
	public void setResult(Set<CityInfo> result) {
		this.result = result;
	}

	
}
