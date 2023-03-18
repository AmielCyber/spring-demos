package com.amiel.CrudDemo.dao;

import com.amiel.CrudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// Mark for Spring scanning and translate JDBC exceptions
@Repository
public class StudentDAOImpl implements StudentDAO{
    // Define field for entity manager
    EntityManager entityManager;

    // Inject entity manager using constructor
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    // Add transactional since we are updating our database
    @Override
    @Transactional
    public void save(Student student) {
        // Saves to the database.
        this.entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        // Retrieve an object from our db.
        return this.entityManager.find(Student.class, id);
    }

    // No need for transactional since we are not updating our database
    @Override
    public List<Student> findByLastName(String lastName) {
        // Create query
        TypedQuery<Student> query = this.entityManager.createQuery("FROM Student WHERE lastName=:data", Student.class);
        // Set query parameters
        query.setParameter("data", lastName);
        // Return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findAll() {
        // Create query and order by lastname
        TypedQuery<Student> query = this.entityManager.createQuery("FROM Student ORDER BY lastName", Student.class);
        // Return query results
        return query.getResultList();
    }

    // Add transactional since we are updating our database
    @Override
    @Transactional
    public void update(Student student) {
        this.entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // Retrieve the student
        Student student = this.entityManager.find(Student.class, id);
        // Delete the student
        this.entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int rowsDeleteed = this.entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return rowsDeleteed;
    }
}
