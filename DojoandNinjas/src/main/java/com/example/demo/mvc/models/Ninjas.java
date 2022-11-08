package com.example.demo.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninjas {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@NotNull
    @Size(min = 3, max = 20 , message="First Name must be at least 3 characters.")
    private String firstname;
	
	@NotNull
    @Size(min = 3, max = 20 , message="Last Name must be at least 3 characters.")
    private String lastname;
	
	
	@NotNull
    @Min(value=1, message="age must be at least 1 years old.")
    private Integer age;
	
	
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
	
	
	
	
	
	
	@Column(updatable=false)
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date createdAt;
	    
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date updatedAt;
	 
	 @PrePersist
	 protected void onCreate(){
	      this.createdAt = new Date();
	 }
	 @PreUpdate
	 protected void onUpdate(){
	      this.updatedAt = new Date();
	 }
	 
	 
	public Ninjas() {
	}
	
	public Ninjas( String firstname, String lastname, Integer age, Dojo dojo) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.dojo = dojo;
	}
	
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getFirstname() {
		return firstname;
	}
	
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	
	public String getLastname() {
		return lastname;
	}
	
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	public Integer getAge() {
		return age;
	}
	
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
	
	
	
	
	
	
	
	
	 
	 
	 

}
