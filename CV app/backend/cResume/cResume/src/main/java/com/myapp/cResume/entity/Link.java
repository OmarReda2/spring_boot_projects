package com.myapp.cResume.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "link")
//@Getter
//@Setter
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "url")
    private String url;

//    ----------------------- relations -------------------------
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    //    ----------------------- constructors -------------------------
    public Link() {
    }

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }


    //    ----------------------- getters -------------------------
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public User getUser() {
        return user;
    }

    //    ----------------------- setters -------------------------
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(User user) {
        this.user = user;
    }




}
