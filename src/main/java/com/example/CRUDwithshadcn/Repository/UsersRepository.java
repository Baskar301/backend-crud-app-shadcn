package com.example.CRUDwithshadcn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CRUDwithshadcn.Models.Users;

public interface UsersRepository extends JpaRepository<Users,Long>{

}
