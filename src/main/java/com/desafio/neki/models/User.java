package com.desafio.neki.models;

import jakarta.persistence.Entity;


public class User {


    private String ursername;
    private String password;
    private String role;

    public String getUrsername() {

        return ursername;
    }
    public void setUrsername(String ursername) {

        this.ursername = ursername;
    }
    public String getPassword() {

        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
