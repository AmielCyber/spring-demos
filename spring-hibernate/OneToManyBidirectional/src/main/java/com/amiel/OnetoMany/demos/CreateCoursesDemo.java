package com.amiel.OnetoMany.demos;

import com.amiel.OnetoMany.entity.Course;
import com.amiel.OnetoMany.entity.Instructor;
import com.amiel.OnetoMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {
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
            // Create some courses
            Course course1 = new Course("Air Guitar - The Ultimate Guide");
            Course course2 = new Course("The Pinball Masterclass");
            // Add courses to instructor
            instructor.add(course1);
            instructor.add(course2);
            // Save the courses
            session.persist(course1);
            session.persist(course2);
            // Commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
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
