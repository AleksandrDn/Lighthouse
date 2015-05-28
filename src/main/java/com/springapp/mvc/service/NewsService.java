package com.springapp.mvc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import com.springapp.mvc.entity.News;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Service("newsService")
@EnableTransactionManagement
@Transactional
public class NewsService {

    protected static Logger logger = Logger.getLogger("service");

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retrieves all persons
     *
     * @return a list of persons
     */
    public List<News> getAll() {
        logger.debug("Retrieving all persons");

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM  News");

        // Retrieve all
        return  query.list();
    }

    public ArrayList<News> getBlock(int part, int newsInBlock) {
        ArrayList<News> block = new ArrayList<News>();

        List<News> allNews = getAll();
        Collections.reverse(allNews);
        int bottomBorder = part * newsInBlock;
        int topBorder = bottomBorder + newsInBlock;
        if (topBorder >= allNews.size()) topBorder = allNews.size();
        for (int i = bottomBorder; i < topBorder; i++)
            block.add(allNews.get(i));
        // Retrieve all
        return block;
    }

    /**
     * Retrieves a single person
     */
    public News get(Long id) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        News news = (News) session.get(News.class, id);

        return news;
    }
    /**
     * Adds a new person
     */
    public void add(News news) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Save
        session.save(news);
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
        Query query = session.createQuery("FROM News WHERE id_news='" + id + "'");
        if (!query.list().isEmpty())
            session.delete(query.list().get(0));
    }

    /**
     * Edits an existing person
     */
    public void edit(News news) {
        logger.debug("Editing existing person");

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person via id
        News existingNews = (News) session.get(News.class, news.getId_news());

        // Assign updated values to this person
        existingNews.setTitle(news.getTitle());
        existingNews.setContent(existingNews.getContent());

        // Save updates
        session.save(existingNews);
    }

    public List<News> getAllReverse() {

        List<News> allNews = getAll();
        Collections.reverse(allNews);

        return  allNews;
    }
}
/*
INSERT INTO `sanatorium`.`news` (`content`, `date_news`, `image`, `short_content`, `time_news`, `title`) VALUES ('Наш санаторий участвовал в конкурсе санаторно-рекреационных учреждений и полчил первое место. Спасибо нашим сотрудникам и отдыхающим за поддержку. Будем еще больше улучшать качество нашего сервиса.', '2015-04-29', '/news_images/news1.jpg', 'Наш санаторий участвовал в конкурсе санаторно-рекреационных учреждений и полчил первое место.', '16:00:00', 'Участие санатория в конкурсе');

 */
