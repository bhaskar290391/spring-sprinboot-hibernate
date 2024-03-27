package com.practise.aopDemo.dao;


import com.practise.aopDemo.model.Account;

public interface AccountDao {
    public void addAccount(Account account,boolean vip);

    public boolean doWork();
}
