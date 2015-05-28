package com.springapp.mvc.service;

import com.springapp.mvc.entity.Account;
import com.springapp.mvc.entity.Client;
import com.springapp.mvc.entity.News;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("clientService")
@EnableTransactionManagement
@Transactional
public class ClientService {

    protected static Logger logger = Logger.getLogger("service");

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public String getFirstName(String email) {
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM Client WHERE email='" + email + "'");

        // Retrieve all
        Client client = (Client) query.list().get(0);
        String name = client.getFirst_name().split(" ")[0];
        if (name.length() > 11)
            name = name.substring(0, 10);
        return name;
    }

    public Long getId(String email) {
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM Client WHERE email='" + email + "'");

        // Retrieve all
        Client client = (Client) query.list().get(0);
        return client.getId_client();
    }

    public void add(Client client) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        session.save(client);
    }

    public List<Client> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Client");
        return  query.list();
    }
}