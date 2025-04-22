package com.myapp.cResume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
//@Getter
//@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name = "age")
    private int age;


    @Column(name = "intro")
    private String intro;


//    ----------------------- relations -------------------------
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Course> courses = new HashSet<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Education> educations = new HashSet<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private  Set<Link> links = new HashSet<>();



    //    ----------------------- constructors -------------------------
    public User() {
    }

    public User(String firstName, String lastName, String city, String country, String imageUrl, int age, String intro) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.country = country;
        this.imageUrl = imageUrl;
        this.age = age;
        this.intro = intro;
    }


    //    ----------------------- getters and setters -------------------------
    public long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }

    public String getIntro() {
        return intro;
    }
    public Set<Course> getCourses() {
        return courses;
    }
    public Set<Education> getEducations() {
        return educations;
    }
    public Set<Link> getLinks() {
        return links;
    }
    public String getImageUrl(){
        return imageUrl;
    }


    public void setCity(String city) {
        this.city = city;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }
    public void setLinks(Set<Link> links) {
        this.links = links;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }





    // ----------------------- methods -------------------------
    public void add(Course course){

        if(course != null){
            if(courses == null){
                courses = new HashSet<>();
            }
        }

        courses.add(course);
        course.setUser(this);

    }

    public void add(Education education){

        if(education != null){
            if(educations == null){
                educations = new HashSet<>();
            }
        }

        educations.add(education);
        education.setUser(this);

    }

    public void add(Link link){

        if(link != null){
            if(links == null){
                links = new HashSet<>();
            }
        }

        links.add(link);
        link.setUser(this);

    }


}
