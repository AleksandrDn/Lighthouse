package com.springapp.mvc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "account_roles")
public class AccountRoles implements Serializable {
        //    @GenericGenerator(name = "generator", strategy = "foreign",
//            parameters = @Parameter(name = "property", value = "stock"))
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id_account_roles;
    private String ROLE;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email")
    private Account account;

    public String getId_account_roles() {
        return id_account_roles;
    }

    public void setId_account_roles(String id_account_roles) {
        this.id_account_roles = id_account_roles;
    }

    public String getROLE() {
        return ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return ROLE;
    }

}
