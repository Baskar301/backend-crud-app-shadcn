package com.example.CRUDwithshadcn.Service;

import java.util.List;

import com.example.CRUDwithshadcn.Models.Users;

public interface UsersServiceInterface {
	Users saveUser(Users users);
	List<Users> getAllUsers();
	Users getUserById(long id);
	Users updateUserById(Users users,long id);
	void deleteUserById(long id);
}
