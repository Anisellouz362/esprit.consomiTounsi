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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;




@Entity
@Table(name = "user")

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")

	private long id ; 
	@Column(name = "salary")
	private int salary;

	@NotNull(message="name is compulsory")
	@Column(name = "name")
	private String name; 
	
	@NotNull(message="email is compulsory")
	@Email(message = "Email is invalid")
	@Column(name = "email")
	private String email; 
	@Column(name = "phone")
	private int phone; 
	
	@NotNull(message="Password is compulsory")
	@Length(min=5, message="Password should be at least 5 characters")
	@Column(name = "password")
	private String password;
	@Column(name = "adress")
	private String adress;
	@Column(name = "status")
	private String status;


	 @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))

	 private Set<Role> roles;

	
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
	

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", salary=" + salary + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", adress=" + adress + ", status=" + status + ", roles=" + roles + "]";
	}
	
	
	
	
	



}
