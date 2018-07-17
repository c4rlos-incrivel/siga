package com.incrivel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incrivel.model.User;
import com.incrivel.repository.UserRepository;
import com.incrivel.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public List<User> userList() {
		return userRepository.findAll();
	}


	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);//substituí o method findOne
	}


	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}


	@Override
	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		return "{'message':'User deleted successfully.'}";
	}
	
	
}
