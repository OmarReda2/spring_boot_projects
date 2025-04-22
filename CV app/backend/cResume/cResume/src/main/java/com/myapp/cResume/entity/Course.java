package com.myapp.cResume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "course")
//@Getter
//@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

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
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;





    //    ----------------------- constructors -------------------------
    public Course() {
    }

    public Course(String name, String location, Date startDate, Date endDate, String description) {
        this.name = name;
        this.location = location;
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
