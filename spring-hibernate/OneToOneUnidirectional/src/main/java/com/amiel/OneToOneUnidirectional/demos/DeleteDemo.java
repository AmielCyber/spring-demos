package com.amiel.OneToOneUnidirectional.demos;

import com.amiel.OneToOneUnidirectional.entity.Instructor;
import com.amiel.OneToOneUnidirectional.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        // Create session factory.
        SessionFactory factory = new Configuration().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
        // Create Session
        Session session = factory.getCurrentSession();
        try{
            // Start a transaction
            session.beginTransaction();
            // Get instructor by primary key/id
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);
            print("Found instructor: " + instructor);
            // Delete instructors
            if(instructor != null){
                print("Deleting: " + instructor);
                // Will also delete the InstructorDetail object
                session.remove(instructor);
            }
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
