package com.example.vtys.entity;
import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "saatlik_ücret", nullable = false)
	private Integer ücret;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String email, Integer ücret) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.ücret = ücret;
		
	}
	
	public Integer getÜcret() {
		return ücret;
	}

	public void setÜcret(Integer ücret) {
		this.ücret = ücret;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
}
