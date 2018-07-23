package com.incrivel.service;

import java.util.List;

import com.incrivel.model.Address;

public interface AddressService {
	List<Address> addressList();
	
	Address findById(Long id);
	
	Address addAddress(Address address);
	
	String deleteAddress(Long id);
}
