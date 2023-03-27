package com.amiel.springhibernate.demo;

import com.amiel.springhibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
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

            // Delete student
            System.out.println("Deleting student: " + myStudent);
            session.remove(myStudent);

            // Delete student id=2
            System.out.println("Deleting student id=2");
            session.createQuery("DELETE FROM Student WHERE id=2").executeUpdate();

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }
}
