package com.amiel.springhibernate.demo;

import com.amiel.springhibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        // Create session factory.
        SessionFactory factory = new Configuration().addAnnotatedClass(Student.class).buildSessionFactory();
        // Create Session
        Session session = factory.getCurrentSession();
        try{
            // Start a transaction
            session.beginTransaction();
            // Query students
            List<Student> students = session.createQuery("FROM Student").getResultList();
            // Display students
            System.out.println("\n\nPrint all students");
            printStudents(students);
            // query students whose last name is Doe
            students = session.createQuery("FROM Student s WHERE s.lastName='Doe'").getResultList();
            System.out.println("\n\nStudents who have last name of Doe");
            printStudents(students);
            // Query students: lastName=Doe OR firstName=Daffy
            students = session.createQuery("FROM Student s WHERE s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
            System.out.println("\n\nStudents who have last name of Doe or first name of Daffy");
            printStudents(students);
            // Query student where email LIKE %gmail.com
            students = session.createQuery("FROM Student s WHERE s.email LIKE '%@gmail.com'").getResultList();
            System.out.println("\n\nStudents who have a gmail email");
            printStudents(students);

            // Commit transaction
            session.getTransaction().commit();


            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }

    private static void printStudents(List<Student> students) {
        for(Student student : students){
            System.out.println("\t" + student);
        }
    }
}
