package com.springapp.mvc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "account")
public class Account  implements Serializable {
//    @GenericGenerator(name = "generator", strategy = "foreign",
//            parameters = @Parameter(name = "property", value = "stock"))
    @Id
    private String email;
    private String password;
    private String enabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    private Client client;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public Account(){}

    @Override
    public String toString() {
        return "Account [pass=" + password + ", email=" + email + "]";
    }

}
