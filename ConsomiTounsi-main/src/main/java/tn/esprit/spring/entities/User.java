package tn.esprit.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user")

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")

	private long id ; 
	@Column(name = "salary")
	private int salary;
	@Column(name = "name")
	private String name; 
	@Column(name = "email")
	private String email; 
	@Column(name = "phone")
	private int phone; 
	@Column(name = "password")
	private String password;
	@Column(name = "adress")
	private String adress;
	@Column(name = "status")
	private String status;


	 @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))

	 private Set<role> roles;

	
public User() {
		
	}
	public User(long id,int salary,int phone,String name,String email,String password,String adress,String status) {
		this.id=id; 
		this.salary=salary;
		this.phone=phone;
		this.name=name;
		this.email=email;
		this.password=password;
		this.adress=adress;
		this.status=status; 
	}
	
	public User(int salary,int phone,String name,String email,String password,String adress,String status) {
		this.salary=salary;
		this.phone=phone;
		this.name=name;
		this.email=email;
		this.password=password;
		this.adress=adress;
		this.status=status; 
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	

	public Set<role> getRoles() {
		return roles;
	}

	public void setRoles(Set<role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", salary=" + salary + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", adress=" + adress + ", status=" + status + ", roles=" + roles + "]";
	}
	
	
	
	
	



}
