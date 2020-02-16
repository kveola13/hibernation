package com.kveola13.hibernation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
    public static void main(String[] args) {
        Person person = new Person();
        /*person.setId(103);
        person.setName("Normie Norwegian");
        person.setNationality("Norwegian");*/

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Person.class);

        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        session.save(person);
        person = (Person) session.get(Person.class, 102);
        transaction.commit();

        System.out.println(person);
    }
}
