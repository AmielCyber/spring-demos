package com.amiel.OnetoMany.demos;

import com.amiel.OnetoMany.entity.Course;
import com.amiel.OnetoMany.entity.Instructor;
import com.amiel.OnetoMany.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
    public static void main(String[] args) {
        // Create session factory.
        SessionFactory factory = new Configuration().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
        // Create Session
        Session session = factory.getCurrentSession();
        try{
            // Start a transaction
            session.beginTransaction();

            // Option 2: Hibernate query with HQL
            // Get the instructor from db
            int id = 1;
            Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i JOIN FETCH i.courses WHERE i.id=:id", Instructor.class);
            // Set parameter on query
            query.setParameter("id", id);
            // Execute query and get instructor
            Instructor instructor = query.getSingleResult();
            // Everything gets loaded if EAGER
            print("Instructor: " + instructor);
            // Commit transaction
            session.getTransaction().commit();
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
