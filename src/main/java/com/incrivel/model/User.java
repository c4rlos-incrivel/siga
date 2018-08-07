package com.incrivel.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//private transient Long id;
	private String userId;
	private String userName;
	private String password;

	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	@OneToMany(targetEntity=Address.class, mappedBy="user", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<Address> addresses;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
}
