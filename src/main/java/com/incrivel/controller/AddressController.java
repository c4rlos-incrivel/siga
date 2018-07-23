package com.incrivel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incrivel.model.Address;
import com.incrivel.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	private AddressService addressService;
	
	@Autowired
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteAddress(@PathVariable Long id) {
		return addressService.deleteAddress(id);
	}
	
	@RequestMapping("/add")
	public Address addAddress(@RequestBody Address address) {
		return addressService.addAddress(address);
	}
	
	@RequestMapping("/list/{id}")
	public Address findById(@PathVariable Long id) {
		return addressService.findById(id);
	}
	
	@RequestMapping("/list")
	public List<Address> addressList(){
		return addressService.addressList();
	}
	
}
