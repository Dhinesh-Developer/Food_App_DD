package com.FoodApp.Model;

public class user {
    private int userid;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String address;
    private String role;

    // Constructors
    public user(int userid, String username, String password, String email, String phone, String address, String role) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public user(String username, String password, String email,  String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    public user(int i, String password2, String email2, String phone2, String address2, String address3) {}


	// Getters and Setters
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return userid + " " + username + " " + password + " " + email + " " + phone + " " + address + " " + role;
    }
}
