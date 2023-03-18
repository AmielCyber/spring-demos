package com.amiel.CrudDemo;

import com.amiel.CrudDemo.dao.StudentDAO;
import com.amiel.CrudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	// Executes after the Spring Beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			// findStudent(studentDAO);
			// findAllStudents(studentDAO);
			// findByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int rowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted rows: " + rowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// Delete the student
		int id = 3;
		System.out.println("Deleting student with id: " + id);
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Retrieve student based on the id: primary key
		int id = 1;
		System.out.println("Getting student with id: "  + id);
		Student student = studentDAO.findById(id);

		System.out.println("Updating student...");

		// Change first name to 'Scooby'
		student.setFirstName("Scooby");
		studentDAO.update(student);

		// Display updated student
		System.out.println("Updated student: " + student);
	}

	private void findByLastName(StudentDAO studentDAO) {
		// Get a list of students
		List<Student> students = studentDAO.findByLastName("Doe");
		// Display list of students
		for(Student student: students){
			System.out.println(student);
		}
	}


	private void createStudent(StudentDAO studentDAO) {
		// Create the student object
		System.out.println("Creating new student object....");
		Student student = new Student("Paul", "Doe", "paul@gmail.com");
		// Save the student object
		System.out.println("Saving the student object....");
		studentDAO.save(student);
		// Display id of the saved student
		System.out.println("Saving student. Generated id: " +  student.getId());
	}
	private void createMultipleStudents(StudentDAO studentDAO) {
		// Create the student object
		System.out.println("Creating new student object....");
		Student student1 = new Student("John", "Doe", "john@gmail.com");
		Student student2 = new Student("Mary", "Public", "public@gmail.com");
		Student student3 = new Student("Bonita", "Applebum", "bonita@gmail.com");
		// Save the student object
		System.out.println("Saving the students....");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}
	private void findStudent(StudentDAO studentDAO){
		// Create a student obj
		System.out.println("Creating a new student object...");
		Student student = new Student("Daffy", "Duck", "daffy@gmail.com");
		// Save the student
		System.out.println("Saving the student...");
		studentDAO.save(student);
		// Display id of the saved student
		int id = student.getId();
		System.out.println("Saved student: Generated id: " + id);
		// Retrieve student based on the id: primary ky
		Student readStudent = studentDAO.findById(id);
		// Display Student
		System.out.println("Found the student: " + readStudent);
	}
	private void findAllStudents(StudentDAO studentDAO){
		// Get a list of students
		List<Student> students = studentDAO.findAll();
		// Display list of students
		for(Student student: students){
			System.out.println(student);
		}

	}

}
