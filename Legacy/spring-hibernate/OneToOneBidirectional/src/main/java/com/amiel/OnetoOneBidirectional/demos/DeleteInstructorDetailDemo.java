package com.amiel.OnetoOneBidirectional.demos;

import com.amiel.OnetoOneBidirectional.entity.Instructor;
import com.amiel.OnetoOneBidirectional.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        // Create session factory.
        SessionFactory factory = new Configuration().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
        // Create Session
        Session session = factory.getCurrentSession();
        try{
            // Start a transaction
            session.beginTransaction();
            // Get the instructor detail object
            int id = 4;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            // Print the instructor detail
            print("instructorDetail: " + instructorDetail);
            // Print the associated instructor
            print("The associated instructor: " + instructorDetail.getInstructor());
            // Delete the instructor detail
            print("Deleting instructorDetail: " + instructorDetail);
            // Remove the associated object reference. Break the Link
            instructorDetail.getInstructor().setInstructorDetail(null);
            // Remove the obj
            session.remove(instructorDetail);
            // Commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }catch(Exception err){
            err.printStackTrace();

        } finally {
            // Handle connection leak issue
            session.close();
            factory.close();
        }
    }
    public static void print(String str){
        System.out.println("\n" + str + "\n");

    }
}
