package com.devs.ecom.service;

import com.devs.ecom.dto.UserLoginReqDto;
import com.devs.ecom.dto.UserRegisterReqDto;
import com.devs.ecom.entity.User;

public interface AuthenticationService {

    public User signup(UserRegisterReqDto input); 

    public User authenticate(UserLoginReqDto input);

}
