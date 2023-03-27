package com.amiel.springhibernate.demo;

import com.amiel.springhibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        // Create session factory.
        SessionFactory factory = new Configuration().addAnnotatedClass(Student.class).buildSessionFactory();
        // Create Session
        Session session = factory.getCurrentSession();
        try{
            // Use the session object to save Java object
            // Create a student object
            System.out.println("Creating  new student object...");
            Student tempStudent = new Student("Paul", "Wall", "paul@gmail.com");
            // Start a transaction
            session.beginTransaction();
            // Save the student object
            session.persist(tempStudent);
            System.out.println("Saving the student...");
            // Commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }
}
