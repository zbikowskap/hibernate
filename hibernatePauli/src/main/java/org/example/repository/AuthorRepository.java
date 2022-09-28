package org.example.repository;

import lombok.AllArgsConstructor;
import org.example.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

@AllArgsConstructor
public class AuthorRepository {
    private SessionFactory sessionFactory;

    public void save(Author author){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(author); // inaczej save
        transaction.commit();
        session.close();
    }

    public Optional< Author> find(Integer id){
        Session session = sessionFactory.openSession();
        Author author = session.find(Author.class, id);
        session.close();
        return Optional.ofNullable(author);
    }


}
