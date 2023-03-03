package com.amiel.ManytoMany.demos;

import com.amiel.ManytoMany.entity.Course;
import com.amiel.ManytoMany.entity.Instructor;
import com.amiel.ManytoMany.entity.InstructorDetail;
import com.amiel.ManytoMany.entity.Review;
import com.amiel.ManytoMany.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacmanCourseDemo {
    public static void main(String[] args) {
        // Create session factory.
        SessionFactory factory = new Configuration().addAnnotatedClass(Instructor.class).addAnnotatedClass(Review.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Student.class).buildSessionFactory();
        // Create Session
        Session session = factory.getCurrentSession();
        try{
            // Start a transaction
            session.beginTransaction();

            // Get the pacman course from db
            int courseId = 10;
            Course course =  session.get(Course.class, courseId);
            // Delete the course
            print("Deleting course: " + course.toString());
            session.remove(course);

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
