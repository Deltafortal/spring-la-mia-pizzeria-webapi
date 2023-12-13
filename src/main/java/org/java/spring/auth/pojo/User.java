package org.java.spring.auth.pojo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class User implements UserDetails{

	
	//Declaring variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String username;
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles;
	
	
	
	//Constructor
	public User() { }
	public User(String username, String password, Role...roles) {
		
		setUsername(username);
		setPassword(password);
		setRoles(roles);
	}
	
	
	
	
	
	//Id Functions
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	//Username FUnctions
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	//Password Functions
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	//Roles Functions
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public void setRoles(Role... roles) {
		setRoles(List.of(roles));
	}
	
	
	
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return getRoles().stream()
				.map(r -> new SimpleGrantedAuthority(r.getName()))
			.toList();
	}
	@Override
	public boolean isAccountNonExpired() { return true; }
	@Override
	public boolean isAccountNonLocked() { return true; }
	@Override
	public boolean isCredentialsNonExpired() { return true; }
	@Override
	public boolean isEnabled() { return true; }
}
