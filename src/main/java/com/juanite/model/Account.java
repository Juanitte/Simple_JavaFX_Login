package com.juanite.model;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {

    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;
    private String country;
    private String city;
    private String bio;
    private boolean isAdmin;

    public Account(){
        this.username = "";
        this.password = "";
        this.email = "";
        this.name = "";
        this.surname = "";
        this.country = "";
        this.city = "";
        this.bio = "";
        this.isAdmin = false;
    }
    public Account(String username, String password){
        this.username = username;
        this.password = password;
        this.email = "";
        this.name = "";
        this.surname = "";
        this.country = "";
        this.city = "";
        this.bio = "";
        this.isAdmin = false;
    }
    public Account(String username, String password, boolean isAdmin){
        this.username = username;
        this.password = password;
        this.email = "";
        this.name = "";
        this.surname = "";
        this.country = "";
        this.city = "";
        this.bio = "";
        this.isAdmin = isAdmin;
    }
    public Account(String username, String password, String email, String name, String surname, String country, String city, String bio, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.city = city;
        this.bio = bio;
        this.isAdmin = isAdmin;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(username, account.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

}
