package com.amiel.springhibernate.entity;

import jakarta.persistence.*;


@Entity
@Table(name="student")// Maps the Student class to a student table.
public class Student {
    @Id // Marks this as the unique identifier in our db.
    @GeneratedValue(strategy=GenerationType.IDENTITY)   // Let DB handle auto increment
    @Column(name="id")  // Map the column id to this variable.
    private int id;
    @Column(name="first_name")  // Map the column id to this variable.
    private String firstName;
    @Column(name="last_name")  // Map the column id to this variable.
    private String lastName;
    @Column(name="email")  // Map the column id to this variable.
    private String email;

    // No arg constructor
    public Student(){

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
