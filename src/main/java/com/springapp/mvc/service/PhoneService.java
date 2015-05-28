package com.springapp.mvc.service;

import com.springapp.mvc.entity.Phone;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("phoneService")
@EnableTransactionManagement
@Transactional
public class PhoneService {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<Phone> getPhone(String phone_type) {

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM Phone WHERE type='" + phone_type + "'");

        // Retrieve all
        return query.list();
    }

    public void edit(String phoneType, String newPhoneNumber) {
        Session session = sessionFactory.getCurrentSession();

        Phone existingPhone = (Phone) session.get(Phone.class, phoneType);

        existingPhone.setPhone_number(newPhoneNumber);
        // Save updates
        session.save(existingPhone);
    }
}
