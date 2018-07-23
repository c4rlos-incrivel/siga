package com.incrivel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incrivel.model.Address;
import com.incrivel.repository.AddressRepository;
import com.incrivel.repository.UserRepository;
import com.incrivel.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	private AddressRepository addressRepository;
	private UserRepository userRepository;
	
	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
		this.addressRepository = addressRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Address> addressList() {
		return addressRepository.findAll();
	}

	@Override
	public Address findById(Long id) {
		return addressRepository.findById(id).orElse(null);
	}

	@Override
	public Address addAddress(Address address) {
		address.setUser(userRepository.findById(address.getUserId()).orElse(null));
		return addressRepository.save(address);
	}

	@Override
	public String deleteAddress(Long id) {
		addressRepository.deleteById(id);
		return "{'message':'Address Eliminado com sucesso'}";
	}
	
	
}
