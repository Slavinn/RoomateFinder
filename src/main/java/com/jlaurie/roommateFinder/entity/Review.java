package com.jlaurie.roommateFinder.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table (name = "reviews")
public class Review {

    @Id
    @Column (name = "id")
    private int id;

    @Column (name = "text")
    private String review;

    @Column (name = "sender_name")
    private String user;

    @Column (name = "star")
    private int star;


    @Column (name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Roommate roommate;

    public Review() {
    }

    public Review( String review, String user, int star, String date) {
        this.review = review;
        this.user = user;
        this.star = star;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", review='" + review + '\'' +
                ", user='" + user + '\'' +
                ", star=" + star +
                ", date='" + date + '\'' +
                '}';
    }
}
