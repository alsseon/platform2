package com.spring.plt.admin.vo;

import org.springframework.stereotype.Component;

@Component("adminVO")
public class AdminVO {
	private String id;
	private String pwd;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}	
}
