package com.example.CRUDwithshadcn.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUDwithshadcn.Models.Users;
import com.example.CRUDwithshadcn.Service.UsersServiceInterface;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequestMapping("api/users")
public class UsersController {
	
	private UsersServiceInterface usersserviceinterface;
	public UsersController(UsersServiceInterface usersserviceinterface){
		this.usersserviceinterface=usersserviceinterface;
	}
	
	@PostMapping
	public ResponseEntity<Users> saveUsers(@RequestBody Users users){
		return new ResponseEntity<Users>(usersserviceinterface.saveUser(users),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Users> getAllUsers(){
		return usersserviceinterface.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable("id") long id){
		return new ResponseEntity<Users>(usersserviceinterface.getUserById(id),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Users> updateUserById(@PathVariable("id") long id,@RequestBody Users users){
		return new ResponseEntity<Users>(usersserviceinterface.updateUserById(users, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <String> deleteUserById(@PathVariable("id") long id){
		usersserviceinterface.deleteUserById(id);
		return new ResponseEntity<String>("Employee Deleted Successfully.",HttpStatus.OK);
	}
}


