package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    private String name;
    private int age;
    private String address;
    @CreationTimestamp
    private Date createdAt;
    
    public Member(long id, String name, int age, String address, Date createdAt ) {
    	this.id = id;
    	this.name=name;
    	this.age=age;
    	this.address=address;
    	this.createdAt=createdAt;
    }
    
    public Member(String name, int age, String address) {
    	this.name=name;
    	this.age=age;
    	this.address=address;
    }

	public void setName(String name) {
		this.name=name;
		
	}

	public void setAge(int age) {
		this.age = age;
		
	}

	public void setAddress(String address) {
		this.address=address;
		
	}
}