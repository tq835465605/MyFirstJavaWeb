package com.foxhis.dao;

import com.foxhis.entity.User;

public interface UserDao {

	/**
	 * 接口模式，通过姓名和密码来查找用户信息
	 * @param user
	 * @return
	 */
	public boolean findUserByNameAndPass(User user);
	
	
	/**
	 * 接口模式，通过姓名和密码来注册用户信息
	 * @param user
	 * @return
	 */
	public boolean registerUserByNameAndPass(User user);
	
	
}
