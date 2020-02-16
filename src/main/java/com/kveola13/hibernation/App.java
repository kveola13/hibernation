package com.kveola13.hibernation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
    public static void main(String[] args) {
        Nation norwayNation = new Nation();
        norwayNation.setId(1);
        norwayNation.setName("Norway");
        norwayNation.setContinent("Europe");
        norwayNation.setNationalLanguage("Norwegian");

        Name name = new Name();
        name.setFirstName("Norman");
        name.setMiddleName("Norwege");
        name.setLastName("Noreg");

        Person person = new Person();
        person.setId(1);
        person.setName(name);
        person.setNationality("Norwegian");
        person.setNation(norwayNation);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Nation.class);

        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(norwayNation);
        session.save(person);
//        person = (Person) session.get(Person.class, 102);
//        session.getTransaction().commit();
        transaction.commit();
    }
}
