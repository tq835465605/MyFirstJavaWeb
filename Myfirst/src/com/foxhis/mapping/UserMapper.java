package com.foxhis.mapping;

import java.util.List;

import com.foxhis.entity.User;

public interface UserMapper {

	List<User> findUserByNameAndPass(User user);
	void registerUserByNameAndPass(User user);
}
