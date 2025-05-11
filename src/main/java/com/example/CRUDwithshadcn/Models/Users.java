package com.example.CRUDwithshadcn.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usersTable")
public class Users {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@Column(name ="email",nullable=false,unique=true)
private String email;
@Column(name = "username")
private String Username;
@Column(name ="ph_no")
private long phonenumber;
}
