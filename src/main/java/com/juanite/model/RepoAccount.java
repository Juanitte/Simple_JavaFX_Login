package com.juanite.model;

import com.juanite.util.Utils;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class RepoAccount implements Serializable {

    private Set<Account> accounts;
    private static RepoAccount _newInstance;

    private RepoAccount(){
        this.accounts = new HashSet<Account>();
    }

    public static RepoAccount getInstance(){
        if(_newInstance == null){
            _newInstance = new RepoAccount();
            _newInstance.getAccounts().add(new Account("admin", "admin", true));
            _newInstance.getAccounts().add(new Account("user", "user"));
        }
        return _newInstance;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public boolean addAccount(String username, String password){
        Account account = new Account(username, password);
        if(account.getUsername() != null && account.getPassword() != null) {
            if (!_newInstance.getAccounts().contains(account)) {
                return _newInstance.getAccounts().add(new Account(username, password));
            }
        }
        return false;
    }

    public Account searchAccount(String username){
        for(Account account : _newInstance.getAccounts()){
            if (account.getUsername().equalsIgnoreCase(username)){
                return account;
            }
        }
        return null;
    }

    public boolean updateUsername(Account account, String username){
        if(!_newInstance.usedUsername(username)){
            account.setUsername(username);
            return true;
        }
        return false;
    }

    public boolean updatePassword(Account account, String password){
        if(Utils.validatePassword(password)){
            account.setPassword(password);
            return true;
        }
        return false;
    }

    public boolean updateName(Account account, String name){
        if(Utils.validateName(name)){
            account.setName(name);
            return true;
        }
        return false;
    }

    public boolean updateSurname(Account account, String surname){
        if(Utils.validateName(surname)){
            account.setSurname(surname);
            return true;
        }
        return false;
    }

    public boolean updateEmail(Account account, String email){
        if(Utils.validateEmail(email)){
            account.setEmail(email);
            return true;
        }
        return false;
    }

    public boolean updateCountry(Account account, String country){
        if(Utils.validateName(country)){
            account.setCountry(country);
            return true;
        }
        return false;
    }

    public boolean updateCity(Account account, String city){
        if(Utils.validateName(city)){
            account.setCity(city);
            return true;
        }
        return false;
    }

    public boolean updateBio(Account account, String bio){
            account.setBio(bio);
            return true;
    }

    public boolean removeAccount(Account account){
        return _newInstance.getAccounts().remove(account);
    }

    public boolean usedUsername(String username){
        for(Account account : _newInstance.getAccounts()){
            if (account.getUsername().equalsIgnoreCase(username)){
                return true;
            }
        }
        return false;
    }

}
