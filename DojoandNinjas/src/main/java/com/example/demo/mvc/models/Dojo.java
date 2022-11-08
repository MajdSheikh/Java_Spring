package com.example.demo.mvc.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@NotNull
    @Size(min = 3, max = 20 , message="Name must be at least 3 characters.")
    private String name;
	
	
	
	
	
	@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninjas> ninjas;
	
	
	
	public List<Ninjas> getNinjas() {
		return ninjas;
	}
	public void setNinjas(List<Ninjas> ninjas) {
		this.ninjas = ninjas;
	}
	
	
	
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
	 
	 
	 
	public Dojo() {
	}
	

	public Dojo(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	 
	 
	

}
