package com.kveola13.hibernation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Person person = new Person();
        person.setId(101);
        person.setName("Francis Frenchman");
        person.setNationality("French");

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Person.class);
/*
        configuration.configure("hibernate.cfg.xml");
*/
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
    }
}
