package com.amiel.OnetoMany.demos;

import com.amiel.OnetoMany.entity.Course;
import com.amiel.OnetoMany.entity.Instructor;
import com.amiel.OnetoMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        // Create session factory.
        SessionFactory factory = new Configuration().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
        // Create Session
        Session session = factory.getCurrentSession();
        try{
            // Create the objects
            Instructor instructor = new Instructor("Susan", "Public", "susan@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/susan", "Gamer");
            // Associate the objects
            instructor.setInstructorDetail(instructorDetail);
            // Start a transaction
            session.beginTransaction();
            // Save the instructor. This will also save the details object because of CascadeType.ALL
            print("\n\nSaving Instructor: " + instructor);
            session.persist(instructor);
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
