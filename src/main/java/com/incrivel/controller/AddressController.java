package com.incrivel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incrivel.model.Address;
import com.incrivel.model.User;
import com.incrivel.service.AddressService;
import com.incrivel.service.UserService;

@Controller
@RequestMapping("/address")
public class AddressController {
	
	private AddressService addressService;
	private UserService userService;
	
	@Autowired
	public AddressController(AddressService addressService, UserService userService) {
		this.addressService = addressService;
		this.userService = userService;
	}
	
	@GetMapping("/form")
	public String addressForm(Model model) {
		model.addAttribute("addressForm", new Address());
		model.addAttribute("users", userService.userList());
		return "address/form";
	}
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable Long id, Model model) {
		model.addAttribute("addressForm", addressService.findById(id));
		model.addAttribute("users", userService.roleList());
		return "address/form";
	}
	@GetMapping("/delete/{id}")
	public String deleteAddress(@PathVariable Long id, Model model) {
		model.addAttribute("message", addressService.deleteAddress(id));
		return "message";
	}
	
	//adicionar endereço
	@PostMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String addAddress(@ModelAttribute Address address, Model model) {
		String message = "";
		if(address.getId() == null) {
			message = "added";
		} else {
			message = "updated";
		}
		model.addAttribute("message", addressService.addAddress(address).getUser().getUserName()+" address "+message+" successfully");
		return "message";
	}
	
	@GetMapping("/list/{id}")
	public Address findById(@PathVariable Long id) {
		return addressService.findById(id);
	}
	
	@GetMapping("/list")
	public String addressList(Model model){
		model.addAttribute("addresses", addressService.addressList());
		return "address/list";
	}
	
}
