package com.incrivel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incrivel.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
