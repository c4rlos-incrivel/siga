package com.incrivel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incrivel.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
