package com.incrivel.service;

import java.util.List;

import com.incrivel.model.Role;
import com.incrivel.model.User;

public interface UserService {
	List<User> userList();
	
	User findById(Long id);
	
	User addUser(User user);
	
	String deleteUser(Long id);
	
	List<Role> roleList();
}
