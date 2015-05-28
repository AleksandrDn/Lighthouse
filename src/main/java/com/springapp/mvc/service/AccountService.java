package com.springapp.mvc.service;

import com.springapp.mvc.entity.Account;
import com.springapp.mvc.entity.AccountRoles;
import com.springapp.mvc.entity.Avatar;
import com.springapp.mvc.entity.Client;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("accountService")
@EnableTransactionManagement
@Transactional
public class AccountService {

    protected static Logger logger = Logger.getLogger("service");

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retrieves all persons
     *
     * @return a list of persons
     */
    public List<Account> getAll() {
        logger.debug("Retrieving all persons");

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM Account");

        // Retrieve all
        return query.list();
    }

    public List<Account> getAccountFromEmail(String email) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM Account WHERE email='" + email + "'");

        // Retrieve all
        return query.list();
    }

    public String getRole(String email)
    {
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM AccountRoles WHERE email='" + email + "'");

        // Retrieve all
        return query.list().get(0).toString();
    }

    public void add(Account account)
    {

        Session session = sessionFactory.getCurrentSession();

        session.save(account);
    }

    public void addUserRole(AccountRoles accountRoles)
    {

        Session session = sessionFactory.getCurrentSession();

        session.save(accountRoles);
    }

    public String getFirstName(String email)
    {
        // Retrieve all
        Client client = ((Account)getAccountFromEmail(email).get(0)).getClient();
        String name = client.getFirst_name().split(" ")[0];
        if (name.length() > 11)
            name = name.substring(0, 10);
        return name;
    }
    public String getFullFirstName(String email)
    {
        Client client = ((Account)getAccountFromEmail(email).get(0)).getClient();
        String name = client.getFirst_name();
        return name;
    }
    public String getLastName(String email)
    {
        Client client = ((Account)getAccountFromEmail(email).get(0)).getClient();
        String name = client.getLast_name();
        return name;
    }
    public String getPhone(String email)
    {
        Client client = ((Account)getAccountFromEmail(email).get(0)).getClient();
        String phone = client.getPhone();
        return phone;
    }

    public String getAvatar(String email)
    {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM Avatar WHERE email='" + email + "'");
        Avatar avatar = (Avatar)query.list().get(0);
        if (avatar == null)
            return "none image";
        if (avatar.getCustom_img() != null)
            return avatar.getCustom_img();
        else
            return avatar.getDefault_img();
    }
    public void addDefaultAvatar(Avatar avatar)
    {
        Session session = sessionFactory.getCurrentSession();

        session.save(avatar);
    }
}