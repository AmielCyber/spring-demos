package com.amiel.OnetoMany.demos;

import com.amiel.OnetoMany.entity.Course;
import com.amiel.OnetoMany.entity.Instructor;
import com.amiel.OnetoMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {
    public static void main(String[] args) {
        // Create session factory.
        SessionFactory factory = new Configuration().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
        // Create Session
        Session session = factory.getCurrentSession();
        try{
            // Start a transaction
            session.beginTransaction();

            // Get the instructor from db
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);
            print("Instructor: " + instructor);
            print("Courses: " + instructor.getCourses());
            // Get course for the instructor
            // Commit transaction
            session.getTransaction().commit();
            // Close the session
            session.close();

            // Option 1. call getter method

            print("Courses: " + instructor.getCourses());
            print("Done!");
        }
        finally {
            // Add clean up.
            session.close();
            factory.close();
        }
    }
    public static void print(String str){
        System.out.println("\n" + str + "\n");

    }
}
