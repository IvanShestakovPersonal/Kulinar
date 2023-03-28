package com.tms.kulinar.repository;

import com.tms.kulinar.domain.Feedback;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class FeedbackRepository {
    public  SessionFactory sessionFactory;

    public FeedbackRepository() {
       sessionFactory=new Configuration().configure().buildSessionFactory();
    }

    public ArrayList<Feedback> getAllFeedback(){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Query query=session.createQuery("from Feedback ");
        ArrayList<Feedback> list= (ArrayList<Feedback>) query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    public Feedback getFeedbackByName(String name){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Feedback feedback=session.get(Feedback.class,name);
        session.getTransaction().commit();
        session.close();
        return feedback;
    }
    public void createFeedback(Feedback feedback){
       Session session= sessionFactory.openSession();
       session.beginTransaction();
       session.save(feedback);
       session.getTransaction().commit();
       session.close();

   }
    public void updateFeedback(Feedback feedback){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(feedback);
        session.getTransaction().commit();
        session.close();

    }
    public void deleteFeedback(Feedback feedback){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.delete(feedback);
        session.getTransaction().commit();
        session.close();
    }
}
