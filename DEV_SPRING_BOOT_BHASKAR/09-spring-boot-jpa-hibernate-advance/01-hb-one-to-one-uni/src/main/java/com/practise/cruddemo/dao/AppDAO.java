package com.practise.cruddemo.dao;

import com.practise.cruddemo.entity.Instructor;

public interface AppDAO {

    public void save(Instructor instructor);

    public Instructor findById(int id);

    public void delete(int id);
}
