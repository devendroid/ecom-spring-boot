package com.devs.ecom.service;

import java.util.List;

import com.devs.ecom.entity.User;

public interface UserService {

public List<User> getAllUsers(); 

public User getUser(String email); 

}
