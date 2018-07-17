package com.incrivel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incrivel.model.User;
import com.incrivel.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}
	
	@RequestMapping("/add")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping("/list/{id}")
	public User findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@RequestMapping("/list")
	public List<User> userList(){
		return userService.userList();
	}
}
