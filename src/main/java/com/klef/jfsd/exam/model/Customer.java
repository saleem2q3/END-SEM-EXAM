package com.klef.jfsd.exam.model;
import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private int id;

    @Column(name = "customer_name", nullable = false, length = 100)
    private String name;

    @Column(name = "customer_email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "customer_age", nullable = false)
    private int age;

    @Column(name = "customer_location", nullable = false, length = 100)
    private String location;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", location=" + location + "]";
    }
}
