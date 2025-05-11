package com.example.CRUDwithshadcn.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CRUDwithshadcn.Exception.ResourceNotFoundException;
import com.example.CRUDwithshadcn.Models.Users;
import com.example.CRUDwithshadcn.Repository.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersServiceInterface{
	private UsersRepository usersrepository;
	
	public UsersServiceImplementation(UsersRepository usersrepository) {
		this.usersrepository=usersrepository;
	}
	
	@Override
	public Users saveUser(Users users) {
		return usersrepository.save(users);
	}

	@Override
	public List<Users> getAllUsers() {
		return usersrepository.findAll();
	}

	@Override
	public Users getUserById(long id) {
		return usersrepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Users","id",id)
		);
	}

	@Override
	public Users updateUserById(Users users, long id) {
		Users existingUsers= usersrepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Users","id",id)
		);
		
		
		existingUsers.setPhonenumber(users.getPhonenumber());
		existingUsers.setEmail(users.getEmail());
		existingUsers.setUsername(users.getUsername());
		
		return usersrepository.save(existingUsers);
	}

	@Override
	public void deleteUserById(long id) {
		usersrepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Users","id",id)
		);
		
		usersrepository.deleteById(id);
	}
}
