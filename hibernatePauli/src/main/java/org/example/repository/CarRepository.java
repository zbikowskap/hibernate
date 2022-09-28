package org.example.repository;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.example.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ToString
public class CarRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private SessionFactory sessionFactory;

    public CarRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Car car){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(car);
        transaction.commit();

        session.close();
    }
    public Car find(Integer id){
        Session session = sessionFactory.openSession();
        Car car = session.find(Car.class, id);
        session.close();
        return car;
    }
}
