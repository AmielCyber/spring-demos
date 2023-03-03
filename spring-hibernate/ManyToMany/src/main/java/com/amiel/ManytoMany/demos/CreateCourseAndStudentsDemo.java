package com.amiel.ManytoMany.demos;

import com.amiel.ManytoMany.entity.Course;
import com.amiel.ManytoMany.entity.Instructor;
import com.amiel.ManytoMany.entity.InstructorDetail;
import com.amiel.ManytoMany.entity.Review;
import com.amiel.ManytoMany.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
    public static void main(String[] args) {
        // Create session factory.
        SessionFactory factory = new Configuration().addAnnotatedClass(Instructor.class).addAnnotatedClass(Review.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Student.class).buildSessionFactory();
        // Create Session
        Session session = factory.getCurrentSession();
        try{
            // Start a transaction
            session.beginTransaction();
            // Create a course
            Course course = new Course("Pacman - How to Score One Million Points");
            // Save the course and leverage the cascade all
            print("Saving the course....");
            session.persist(course);
            print("Saved the course: " + course.toString());
            // Create the students
            Student student1 = new Student("John", "Doe", "jon@gmail.com");
            Student student2 = new Student("Mary", "Public", "public@gmail.com");
            // Add students to the course
            course.addStudent(student1);
            course.addStudent(student2);
            // Save the students
            print("Saving the students...");
            session.persist(student1);
            session.persist(student2);
            print("Saved students: " + course.getStudents().toString());
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
