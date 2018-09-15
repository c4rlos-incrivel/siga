package com.incrivel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.incrivel.model.Role;
import com.incrivel.model.User;
import com.incrivel.repository.RoleRepository;
import com.incrivel.repository.UserRepository;
import com.incrivel.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}


	@Override
	public List<User> userList() {
		return userRepository.findAll();
	}


	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);//substituí o method findOne
	}

	//por corrigir
	@Override
	public User addUser(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setRole(roleRepository.findById(user.getRole().getId()).orElse(null));
		return userRepository.save(user);
	}


	@Override
	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		return "User deleted successfully.";
	}


	@Override
	public List<Role> roleList() {
		return roleRepository.findAll();
	}
	
	
}
