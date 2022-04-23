package com.example.project.dto;

public class UserDTO {
    private String email;
    private String password;
    private String phoneNo;
    private String role;

    public UserDTO(){

    }

    public UserDTO(String email, String password, String phoneNo,String role) {
        this.email = email;
        this.password = password;
        this.phoneNo=phoneNo;
        this.role=role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo(){
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
