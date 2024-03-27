package com.practise.aopDemo.dao;


import com.practise.aopDemo.model.Account;

import java.util.List;

public interface AccountDao {
    public void addAccount(Account account,boolean vip);

    public boolean doWork();

    public void setName(String name);

    public String getName();

    public String getServiceCode();

    public void setServiceCode(String serviceCode);



    public  List<Account> findAccount(boolean tripWire);
}
