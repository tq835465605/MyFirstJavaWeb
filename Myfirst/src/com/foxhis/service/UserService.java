package com.foxhis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxhis.entity.User;
import com.foxhis.mapping.UserMapper;

/**
 * service层属于服务层，用于与dao层相结合处理的结果，提供数据服务给控制层
 * @author tq
 *
 */
@Service
public class UserService {
	
	@Autowired
    private UserMapper usermapper;
    

	public List<User> getLogin(User user)
	{
		return this.usermapper.findUserByNameAndPass(user);
		
	}
	
	public void RegisterUser(User user)
	{
		 this.usermapper.registerUserByNameAndPass(user);
		
	}
	
	

}
