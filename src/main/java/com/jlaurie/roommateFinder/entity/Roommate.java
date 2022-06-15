package com.jlaurie.roommateFinder.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD:src/main/java/com/jlaurie/roommateFinder/entity/Roommate.java
@JsonIgnoreProperties({"hibernateLazyInitializer"})
=======
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
>>>>>>> main:roommateFinder/src/main/java/com/jlaurie/roommateFinder/entity/Roommate.java
@Entity
@Table(name = "users")
public class Roommate {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "summary")
    private String summary;

<<<<<<< HEAD:src/main/java/com/jlaurie/roommateFinder/entity/Roommate.java
    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval=true)
    @JoinColumn(name="user_id")
=======
    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, orphanRemoval = true
    )
    @JoinColumn(name="user_id")
    @JsonIgnoreProperties({ "roommate" })
>>>>>>> main:roommateFinder/src/main/java/com/jlaurie/roommateFinder/entity/Roommate.java
    private List<Review> reviews;

    public Roommate() {
    }

    public Roommate(String firstName, String lastName, String email, String password, String summary) {
<<<<<<< HEAD:src/main/java/com/jlaurie/roommateFinder/entity/Roommate.java
=======
        this.id=1;
>>>>>>> main:roommateFinder/src/main/java/com/jlaurie/roommateFinder/entity/Roommate.java
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.summary = summary;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

<<<<<<< HEAD:src/main/java/com/jlaurie/roommateFinder/entity/Roommate.java
    public void addReview( Review theReview) {
=======
    public void addReview(Review theReview) {
>>>>>>> main:roommateFinder/src/main/java/com/jlaurie/roommateFinder/entity/Roommate.java
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(theReview);
    }

    public long getId() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Roommate{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
