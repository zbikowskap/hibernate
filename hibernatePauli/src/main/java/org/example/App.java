package org.example;

import org.example.model.Author;
import org.example.model.Car;
import org.example.repository.AuthorRepository;
import org.example.repository.CarRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

public class App {
    public static void main(String[] args) {
        HibernateFactory hibernateFactory = new HibernateFactory();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Author author = new Author();
        author.setFirstName("Adam");
        author.setLastName("Adamski");
        author.setAddress("Gdansk");
// poniżej druga opcja automatycnego zapisu wywołana metodą z repozytorium Autor a nie pojedynczo robione sejvy ja powyżej
        AuthorRepository authorRepository = new AuthorRepository(sessionFactory);
        authorRepository.save(author);
      //  Author authorDB = authorRepository.find(author.getId());
      //  System.out.println(authorDB);

        //to jest to samo co wyżej w komentarzu ale z Optionalem czyli
        //unikając npe
        authorRepository.find(author.getId())
                .ifPresent(autorDB -> System.out.println("Autor DB" + autorDB));

        //lub w spsób z ifem,a  nie lambdą
        Optional<Author> optionalAuthorDB = authorRepository.find(author.getId());
        if (optionalAuthorDB.isPresent()){
            Author authorDB = optionalAuthorDB.get();
            System.out.println("Author DB " + authorDB);
        }

        CarRepository carRepository = new CarRepository(sessionFactory);
        Car car = new Car();
        car.setBrand("fiat");
        car.setName("multipla");
        car.setMaxSpeed(70);
        carRepository.save(car);


        Car carDB = carRepository.find(car.getId());
        System.out.println(carDB);
    }
}
