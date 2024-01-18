package com.SpringBoot.Entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=" employee")  //  implements UserDetails
public class Employee 
{
  
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
  
  @Column
  private String  email_id;
  
  @Column
  private String  first_name;
  
  @Column
  private String last_name;
  
  @Column
  private String password;
  
  @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
  @JoinTable(name=("Emp_Roles"),
  joinColumns = @JoinColumn(name="employee", referencedColumnName = "employeeId"),
  inverseJoinColumns = @JoinColumn(name="role", referencedColumnName = "id"))
  private Set<Roles> roles= new HashSet<>();

public Employee()
{
	super();
	// TODO Auto-generated constructor stub
}

public int getEmployeeId() {
	return employeeId;
}

public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}

public String getEmail_id() {
	return email_id;
}

public void setEmail_id(String email_id) {
	this.email_id = email_id;
}

public String getFirst_name() {
	return first_name;
}

public void setFirst_name(String first_name) {
	this.first_name = first_name;
}

public String getLast_name() {
	return last_name;
}

public void setLast_name(String last_name) {
	this.last_name = last_name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Set<Roles> getRoles() {
	return roles;
}

public void setRoles(Set<Roles> roles) {
	this.roles = roles;
}

//@Override
//public Collection<? extends GrantedAuthority> getAuthorities() 
//{
//	List<SimpleGrantedAuthority> authories= this.roles.stream()
//			.map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//	
//	return authories;
//
//}
//
//@Override
//public String getUsername()
//{
//	
//	return this.email_id;
//}
//
//@Override
//public boolean isAccountNonExpired() {
//	// TODO Auto-generated method stub
//	return true;
//}
//
//@Override
//public boolean isAccountNonLocked() {
//	// TODO Auto-generated method stub
//	return true;
//}
//
//@Override
//public boolean isCredentialsNonExpired() {
//	// TODO Auto-generated method stub
//	return true;
//}
//
//@Override
//public boolean isEnabled() 
//{
//	
//	return true;
//}
//
//
//
//   
  
}
