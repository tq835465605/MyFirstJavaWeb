package com.foxhis.service;

import com.foxhis.dao.UserDao;
import com.foxhis.entity.User;

/**
 * service层属于服务层，用于与dao层相结合处理的结果，提供数据服务给控制层
 * @author tq
 *
 */
public class UserService {
	
    private UserDao userdao;
    
	
	public UserDao getUserdao() {
		return userdao;
	}


	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}


	public boolean getLogin(User user)
	{
		return userdao.findUserByNameAndPass(user);
		
	}
	
	public boolean RegisterUser(User user)
	{
		return userdao.registerUserByNameAndPass(user);
		
	}
	
	

}
