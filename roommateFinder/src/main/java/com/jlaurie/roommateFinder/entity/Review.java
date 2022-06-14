package com.jlaurie.roommateFinder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "reviews")
public class Review {

    @Id
    @Column (name = "review_id")
    private int id;

    @Column (name = "review_text")
    private String review;

    @Column (name = "sender_name")
    private String user;

    @Column (name = "star")
    private int star;

    @Column (name = "date")
    private String date;

    public Review() {
    }

    public Review(int id, String review, String user, int star, String date) {
        this.id = id;
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
