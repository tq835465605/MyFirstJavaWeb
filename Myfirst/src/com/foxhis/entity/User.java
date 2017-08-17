package com.foxhis.entity;



/***
 * entity作为javabean数据对象实体层
 * @author tq
 *
 */
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
}