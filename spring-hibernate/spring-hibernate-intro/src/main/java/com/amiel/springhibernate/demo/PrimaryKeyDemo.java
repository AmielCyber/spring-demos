package com.amiel.springhibernate.demo;

import com.amiel.springhibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        // Create session factory.
        SessionFactory factory = new Configuration().addAnnotatedClass(Student.class).buildSessionFactory();
        // Create Session
        Session session = factory.getCurrentSession();
        try{
            // Create 3 Student Objects
            // Use the session object to save Java object
            // Create a student object
            System.out.println("Creating  new student object...");
            Student tempStudent1 = new Student("John", "Doe", "jogh@gmail.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@gmail.com");
            Student tempStudent3 = new Student("Bonita", "Applebaum", "bonita@gmail.com");
            // Start a transaction
            session.beginTransaction();
            // Save the student object
            session.persist(tempStudent1);
            session.persist(tempStudent2);
            session.persist(tempStudent3);
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
