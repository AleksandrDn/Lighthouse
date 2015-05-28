package com.springapp.mvc.service;

import com.springapp.mvc.entity.News;
import com.springapp.mvc.entity.Reviews;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("reviewsService")
@EnableTransactionManagement
@Transactional
public class ReviewsService {

    protected static Logger logger = Logger.getLogger("service");

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retrieves all persons
     *
     * @return a list of persons
     */
    public List<Reviews> getAll() {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM  Reviews");

        // Retrieve all
        return  query.list();
    }

    public ArrayList<Reviews> getBlock(int part, int newsInBlock) {
        ArrayList<Reviews> block = new ArrayList<Reviews>();

        List<Reviews> allReviews = getAll();
        Collections.reverse(allReviews);
        int bottomBorder = part * newsInBlock;
        int topBorder = bottomBorder + newsInBlock;
        if (topBorder >= allReviews.size()) topBorder = allReviews.size();
        for (int i = bottomBorder; i < topBorder; i++)
            block.add(allReviews.get(i));
        // Retrieve all
        return block;
    }

    public Reviews get(Long id) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Reviews reviews = (Reviews) session.get(Reviews.class, id);

        return reviews;
    }

    public void add(Reviews reviews) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Save
        session.save(reviews);
    }

    /**
     * Deletes an existing person
     * @param id the id of the existing person
     */
    public void delete(Integer id) {
        logger.debug("Deleting existing news");
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Query query = session.createQuery("FROM Reviews WHERE id_review='" + id + "'");
        if (!query.list().isEmpty())
        {
            query.list().get(0);
            session.delete(query.list().get(0));
        }
    }

    public List<Reviews> getAllReverse() {

        List<Reviews> allReviews = getAll();
        Collections.reverse(allReviews);

        return  allReviews;
    }
}
