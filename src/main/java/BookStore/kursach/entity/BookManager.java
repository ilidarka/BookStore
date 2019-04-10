package BookStore.kursach.entity;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BookManager {
    protected SessionFactory sessionFactory;
 
    public void setup() {
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() 
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}
    }
 
    public void exit() {
    	sessionFactory.close();
    }
 
    public void create(Book book) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
		session.close();
    }
 
    public Book read(long id) {
		Session session = sessionFactory.openSession();
		Book book = session.get(Book.class, id);
		session.close();
		return book;
    }
    
    public List<Book> readAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Book");
		List<Book> books = query.list();
		session.close();
		return books;
	}
    
    public String getCount(String queryString) {
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	Query query = session.createQuery(queryString);
    	session.getTransaction().commit();
    	return query.list().get(0).toString();
    }
 
    public void update(Book book) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(book);
		session.getTransaction().commit();
		session.close();
    }
    
    public void delete(Book book) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(book);
		session.getTransaction().commit();
		session.close();
    }
}