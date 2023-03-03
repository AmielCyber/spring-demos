package com.amiel.ManytoMany.demos;

import com.amiel.ManytoMany.entity.Course;
import com.amiel.ManytoMany.entity.Instructor;
import com.amiel.ManytoMany.entity.InstructorDetail;
import com.amiel.ManytoMany.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviewsDemo {
    public static void main(String[] args) {
        // Create session factory.
        SessionFactory factory = new Configuration().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
        // Create Session
        Session session = factory.getCurrentSession();
        try{
            // Start a transaction
            session.beginTransaction();
            // Create a course
            Course course = new Course("Pacman - How to Score One Million Points");
            // Add some reviews
            course.addReview(new Review("Great course... loved it!"));
            course.addReview(new Review("Cool course, job well done."));
            course.addReview(new Review("What a dumb course, you are an idiot!"));
            // Save the course and leverage the cascade all
            print("Saving the course.");
            session.persist(course);
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
        System.out.printf("\n\t%s\n", str);
    }
}
