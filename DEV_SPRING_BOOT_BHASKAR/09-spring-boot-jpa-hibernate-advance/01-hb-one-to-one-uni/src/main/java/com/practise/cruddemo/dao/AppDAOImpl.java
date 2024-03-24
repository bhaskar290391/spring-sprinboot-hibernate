package com.practise.cruddemo.dao;

import com.practise.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements  AppDAO{

    private EntityManager manager;

    AppDAOImpl(EntityManager manager){
        this.manager=manager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        manager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        Instructor instructor=manager.find(Instructor.class,id);
        return instructor;
    }

    @Override
    @Transactional
    public void delete(int id) {
        Instructor instructor=manager.find(Instructor.class,id);
        manager.remove(instructor);
    }
}
