package com.devs.ecom.dto;

public class UserLoginReqDto {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public UserLoginReqDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginReqDto setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "LoginUserDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
