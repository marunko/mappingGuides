package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.manytomany.User_App;

public interface UserRepository extends JpaRepository<User_App, Long> {

}
