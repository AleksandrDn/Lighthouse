package com.springapp.mvc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "reviews")
public class Reviews implements Serializable {

    //    @GenericGenerator(name = "generator", strategy = "foreign",
//            parameters = @Parameter(name = "property", value = "stock"))
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id_review;
    private String content;
    private Date review_date;//Date from java.sql.Date;
    private int rate;

    @OneToOne
    @JoinColumn(name = "email")
    private Account account;

    public String getId_review() {
        return id_review;
    }

    public void setId_review(String id_review) {
        this.id_review = id_review;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReview_date() {
        return review_date;
    }

    public void setReview_date(Date review_date) {
        this.review_date = review_date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }


    @Override
    public String toString() {
        return content;
    }

}
