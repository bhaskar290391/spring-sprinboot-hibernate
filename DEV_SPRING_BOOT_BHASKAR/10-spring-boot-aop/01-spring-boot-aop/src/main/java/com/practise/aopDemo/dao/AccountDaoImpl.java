package com.practise.aopDemo.dao;

import com.practise.aopDemo.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements  AccountDao{

    @Override
    public void addAccount(Account account,boolean vip) {
        System.out.println(getClass()+" Doing DB Work : adding an account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+" doWork() ");
        return false;
    }
}
