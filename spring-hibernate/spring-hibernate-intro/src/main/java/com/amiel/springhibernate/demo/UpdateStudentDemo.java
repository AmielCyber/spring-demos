package com.amiel.springhibernate.demo;

import com.amiel.springhibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        // Create session factory.
        SessionFactory factory = new Configuration().addAnnotatedClass(Student.class).buildSessionFactory();
        // Create Session
        Session session = factory.getCurrentSession();
        try{
            int studentId = 1;
            // Get a new session and start transaction.
            session = factory.getCurrentSession();
            session.beginTransaction();
            // Retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("Updating student...");
            myStudent.setFirstName("Scooby");
            // Commit the transaction
            session.getTransaction().commit();

            // NEW CODE
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Update email for all students
            System.out.println("\nUpdating email for all students");
            session.createQuery("UPDATE Student SET email='foo@gmail.com'").executeUpdate();

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }
}
