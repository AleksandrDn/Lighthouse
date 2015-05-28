package com.springapp.mvc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 * SQL:
     *
    CREATE TABLE `news` (
     `id_news` int(11) NOT NULL AUTO_INCREMENT,
     `title` varchar(50) DEFAULT NULL,
     `date_news` date DEFAULT NULL,
     `time_news` time DEFAULT NULL,
     `content` text,
     `short_content` text,
     `image` text,
     PRIMARY KEY (`id_news`)
     ) ENGINE=InnoDB DEFAULT CHARSET=cp1251;
     SELECT * FROM sanatorium.news;
 */

@Entity
@Table(name = "news")
public class News implements Serializable {

   // private static final long serialVersionUID = -5527566248002296042L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_news;
    private String title;
    private Date date_news;//Date from java.sql.Date;
    private Time time_news; //Time from java.sql.Time
    private String content;
    private String short_content;
    private String image;

    public News() {  }

    public Long getId_news() {
        return id_news;
    }

    public void setId_news(Long id_news) {
        this.id_news = id_news;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate_news() {
        return date_news;
    }

    public void setDate_news(Date date_news) {
        this.date_news = date_news;
    }

    public Time getTime_news() {
        return time_news;
    }

    public void setTime_news(Time time_news) {
        this.time_news = time_news;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShort_content() {
        return short_content;
    }

    public void setShort_content(String short_content) {
        this.short_content = short_content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Person [id_news=" + id_news + ", title=" + title + ", date_news=" + date_news +
                ", time_news=" + time_news + ", content=" + content + ", short_content=" + short_content + ", image=" + image + "]";
    }
}
