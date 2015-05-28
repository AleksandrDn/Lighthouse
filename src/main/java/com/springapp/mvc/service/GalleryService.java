package com.springapp.mvc.service;

import com.springapp.mvc.entity.Gallery;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("galleryService")
@EnableTransactionManagement
@Transactional
public class GalleryService {

    protected static Logger logger = Logger.getLogger("service");

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retrieves all persons
     *
     * @return a list of persons
     */
    public List<Gallery> getAll() {
        logger.debug("Retrieving all persons");

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM  Gallery");

        // Retrieve all
        return query.list();
    }

    /**
     * Retrieves a single person
     */
    public Gallery get(Integer id) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Gallery gallery = (Gallery) session.get(Gallery.class, id);

        return gallery;
    }

    /**
     * Adds a new person
     */
    public void add(Gallery gallery) {
        logger.debug("Adding new person");

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Save
        session.save(gallery);
    }

    /**
     * Deletes an existing person
     *
     * @param id the id of the existing person
     */
    public void delete(Integer id) {
        logger.debug("Deleting existing news");

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Gallery gallery = (Gallery) session.get(Gallery.class, id);

        // Delete
        session.delete(gallery);
    }
}