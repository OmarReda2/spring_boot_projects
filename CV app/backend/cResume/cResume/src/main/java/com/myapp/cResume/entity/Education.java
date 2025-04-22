package com.myapp.cResume.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "education")
//@Getter
//@Setter
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "grade")
    private String grade;

    @Column(name = "gpa")
    private double gpa;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "description")
    private String description;


//    ----------------------- relations -------------------------
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    //    ----------------------- constructors -------------------------
    public Education() {
    }

    public Education(String name, String location, String grade, double gpa, Date startDate, Date endDate, String description) {
        this.name = name;
        this.location = location;
        this.grade = grade;
        this.gpa = gpa;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }


    //    ----------------------- getters -------------------------
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getGrade() {
        return grade;
    }

    public double getGpa() {
        return gpa;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    //    ----------------------- setters -------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(long id) {
        this.id = id;
    }
}
