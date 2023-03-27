package com.amiel.OneToOneUnidirectional.demos;

import com.amiel.OneToOneUnidirectional.entity.Instructor;
import com.amiel.OneToOneUnidirectional.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        // Create session factory.
        SessionFactory factory = new Configuration().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
        // Create Session
        Session session = factory.getCurrentSession();
        try{
            // Create the objects
            /*
            Instructor instructor = new Instructor("Chad", "Darby", "darby@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!");
            */
            Instructor instructor = new Instructor("Madhi", "Patel", "mad@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("youtube.com", "Guitar");
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
            factory.close();
        }
    }
    public static void print(String str){
        System.out.println("\n" + str + "\n");

    }
}
