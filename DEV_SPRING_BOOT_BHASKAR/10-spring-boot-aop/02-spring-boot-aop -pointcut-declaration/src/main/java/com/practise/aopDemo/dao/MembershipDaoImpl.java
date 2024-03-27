package com.practise.aopDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements  MembershipDao{

    @Override
    public boolean addSillyMembers() {
        System.out.println(getClass()+" Doing DB Work : adding an Membership account");
        return  true;
    }

    @Override
    public boolean goingToSleep() {
        System.out.println(getClass()+" Going to Sleep");
        return false;
    }
}
