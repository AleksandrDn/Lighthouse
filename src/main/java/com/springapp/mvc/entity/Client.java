package com.springapp.mvc.entity;

import javax.persistence.*;
import java.io.Serializable;

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
@Table(name = "client")
public class Client implements Serializable {

    // private static final long serialVersionUID = -5527566248002296042L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_client;
    private String last_name;
    private String first_name;
    private String passport;
    private String phone;

//    @OneToOne(mappedBy = "client")
//    private Account account;

//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Client() {  }

    @Override
    public String toString() {
        return "Client [id_client=" + id_client + ", last_name=" + last_name + "]";
    }
}
