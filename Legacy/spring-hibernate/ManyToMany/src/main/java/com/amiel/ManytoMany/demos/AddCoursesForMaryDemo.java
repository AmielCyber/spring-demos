package com.amiel.ManytoMany.demos;

import com.amiel.ManytoMany.entity.Course;
import com.amiel.ManytoMany.entity.Instructor;
import com.amiel.ManytoMany.entity.InstructorDetail;
import com.amiel.ManytoMany.entity.Review;
import com.amiel.ManytoMany.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForMaryDemo {
    public static void main(String[] args) {
        // Create session factory.
        SessionFactory factory = new Configuration().addAnnotatedClass(Instructor.class).addAnnotatedClass(Review.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Student.class).buildSessionFactory();
        // Create Session
        Session session = factory.getCurrentSession();
        try{
            // Start a transaction
            session.beginTransaction();

            // Get the student Mary from database
            int id = 2;
            Student mary = session.get(Student.class, id);
            print("Loaded student: " + mary.toString());
            print("Courses: " + mary.getCourses().toString());
            // Create more courses
            Course course1 = new Course("Rubik's Cube - How to Speed Cube");
            Course course2 = new Course("Atari 2600 - Game Development");
            // Add student to courses
            course1.addStudent(mary);
            course2.addStudent(mary);
            // Save the courses
            print("Saving the courses...");
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
        System.out.printf("\n\t%s\n", str);
    }
}
