package com.springapp.mvc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "avatar")
public class Avatar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id_avatar;
    private String custom_img;
    private String default_img;

    @OneToOne()
    @JoinColumn(name = "email")
    private Account account;

    public String getId_avatar() {
        return id_avatar;
    }

    public void setId_avatar(String id_avatar) {
        this.id_avatar = id_avatar;
    }

    public String getCustom_img() {
        return custom_img;
    }

    public void setCustom_img(String custom_img) {
        this.custom_img = custom_img;
    }

    public String getDefault_img() {
        return default_img;
    }

    public void setDefault_img(String default_img) {
        this.default_img = default_img;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return default_img;
    }

}
