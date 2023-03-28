package com.tms.kulinar.repository;

import com.tms.kulinar.domain.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class ProductsRepository {
    public SessionFactory sessionFactory;

    public ProductsRepository() {
        sessionFactory=new Configuration().configure().buildSessionFactory();
    }

    public ArrayList<Products> getAllProducts(){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Query query=session.createQuery("from Products ");
        ArrayList<Products> list= (ArrayList<Products>) query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    public Products getProductsByProduct_name(String product_name){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Products products=session.get(Products.class,product_name);
        session.getTransaction().commit();
        session.close();
        return products;
    }
    public void createProducts(Products products){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.save(products);
        session.getTransaction().commit();
        session.close();

    }
    public void updateProducts(Products products){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(products);
        session.getTransaction().commit();
        session.close();

    }
    public void deleteProducts(Products products){
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        session.delete(products);
        session.getTransaction().commit();
        session.close();
    }
}
