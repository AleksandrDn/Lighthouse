package com.springapp.mvc.entity;

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
@Table(name = "gallery")
public class Gallery implements Serializable {

    // private static final long serialVersionUID = -5527566248002296042L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_gallery;
    private String image_url;

    public Gallery() {  }

    public Long getId_gallery() {
        return id_gallery;
    }

    public void setId_gallery(Long id_gallery) {
        this.id_gallery = id_gallery;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    @Override
    public String toString() {
        return "Gallery [id_gallery=" + id_gallery + ", image_url=" + image_url + "]";
    }
}
