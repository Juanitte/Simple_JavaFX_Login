package com.juanite.model;

import java.util.HashSet;
import java.util.Set;

public class RepoAccount {

    private Set<Account> accounts;
    private static RepoAccount _newInstance;

    private RepoAccount(){
        this.accounts = new HashSet<Account>();
    }

    public static RepoAccount getInstance(){
        if(_newInstance == null){
            _newInstance = new RepoAccount();
        }
        return _newInstance;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
