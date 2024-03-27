package com.practise.aopDemo.dao;

import com.practise.aopDemo.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements  AccountDao{

    private String name;

    private String serviceCode;

    @Override
    public void addAccount(Account account,boolean vip) {
        System.out.println(getClass()+" Doing DB Work : adding an account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+" doWork() ");
        return false;
    }

    @Override
    public void setName(String name) {
        System.out.println(getClass()+" setName() ");
        this.name=name;
    }

    @Override
    public String getName() {
        System.out.println(getClass()+" getName() ");
        return name;
    }

    @Override
    public String getServiceCode() {
        System.out.println(getClass()+" getServiceCode() ");
        return serviceCode;
    }

    @Override
    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+" setServiceCode() ");
        this.serviceCode=serviceCode;
    }

    public List<Account> findAccount() {
        return findAccount(false);
    }

    @Override
    public List<Account> findAccount(boolean tripWire) {

        if(tripWire){
            throw  new RuntimeException("Exception while finding account");
        }
        List<Account> account=new ArrayList<>();
        account.add(new Account(29,"silver"));
        account.add(new Account(31,"diamond"));
        System.out.println("The Data==>"+account);
        return account;
    }
}
