package com.amiel.CrudDemo.dao;

import com.amiel.CrudDemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(int id);

    List<Student> findByLastName(String lastName);

    List<Student> findAll();

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
