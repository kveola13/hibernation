package com.kveola13.hibernation;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Nation norwayNation = new Nation();
        norwayNation.setId(1);
        norwayNation.setName("Norway");
        norwayNation.setContinent("Europe");
        norwayNation.setNationalLanguage("Norwegian");

        Nation belgiumNation = new Nation();
        belgiumNation.setId(2);
        belgiumNation.setName("Belgium");
        belgiumNation.setContinent("Europe");
        belgiumNation.setNationalLanguage("French");

        Name name = new Name();
        name.setFirstName("Norman");
        name.setMiddleName("Norwege");
        name.setLastName("Noreg");

        University university = new University();
        university.setId(1);
        university.setName("UiO");
        university.setLocation("Norway");

        Person person = new Person();
        person.setId(1);
        person.setName(name);
        person.setNationality("Norwegian");
        person.getNation().addAll(Arrays.asList(norwayNation, belgiumNation));
        person.setUniversity(university);

        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Nation.class)
                .addAnnotatedClass(University.class);

        ServiceRegistry registry = new ServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(norwayNation);
        session.save(belgiumNation);
        session.save(university);
        session.save(person);
        Query query = session.createQuery("from people where id=1");
        query.setCacheable(true);
        person = (Person) query.uniqueResult();
        System.out.println(person);
        session.getTransaction().commit();
        session.close();
        Session secondSession = sessionFactory.openSession();
        secondSession.beginTransaction();
        Query secondQuery = secondSession.createQuery("from people where id=1");
        secondQuery.setCacheable(true);
        person = (Person) secondQuery.uniqueResult();
        System.out.println(person);
/*        System.out.println(person.getName());
        Collection<Nation> nations = person.getNation();

        for (Nation nation: nations){
            System.out.println(nation.toString());
        }*/
        secondSession.getTransaction().commit();
//        transaction.commit();
        secondSession.close();
    }
}
