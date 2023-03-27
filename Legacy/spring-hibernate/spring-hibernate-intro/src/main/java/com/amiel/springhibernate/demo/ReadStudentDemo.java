package com.amiel.springhibernate.demo;

import com.amiel.springhibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        // Create session factory.
        SessionFactory factory = new Configuration().addAnnotatedClass(Student.class).buildSessionFactory();
        // Create Session
        Session session = factory.getCurrentSession();
        try{
            // Create a student object
            System.out.println("Creating  new student object...");
            Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");
            // Start a transaction
            session.beginTransaction();
            // Save the student object
            session.persist(tempStudent);
            System.out.println("Saving the student...");
            System.out.println(tempStudent);
            // Commit transaction
            session.getTransaction().commit();

            // NEW CODE
            // Find out the student's id: primary key
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            // Get a new session and start transaction.
            session = factory.getCurrentSession();
            session.beginTransaction();
            // Retrieve student based on the id: primary key
            System.out.println("Getting student with id: " + tempStudent.getId());
            Student myStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("Get complete" + myStudent);
            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }
}
