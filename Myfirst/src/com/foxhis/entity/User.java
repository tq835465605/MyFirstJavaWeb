package com.foxhis.entity;

import org.springframework.stereotype.Component;

/***
 * entity作为javabean数据对象实体层
 * @author tq
 *
 */
@Component
public class User {
	
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String pass;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String password) {
		this.pass = password;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[User] username="+username+",pass="+pass;
	}
	
}
