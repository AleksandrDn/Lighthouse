package com.springapp.mvc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone")
public class Phone implements Serializable {

    @Id
    private String type;
    private String phone_number;

    public Phone() {  }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString()
    {
        return phone_number;
    }
}
