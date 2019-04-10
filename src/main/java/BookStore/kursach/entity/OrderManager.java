package BookStore.kursach.entity;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class OrderManager {
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
 
    public void create(Order order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
		session.close();
    }
 
    public Order read(long id) {
		Session session = sessionFactory.openSession();
		Order order = session.get(Order.class, id);
		session.close();
		return order;
    }
    
    public List<Order> readAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Order");
		List<Order> orders = query.list();
		session.close();
		return orders;
	}
 
    public void update(Order order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(order);
		session.getTransaction().commit();
		session.close();
    }
    
    public void delete(Order order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(order);
		session.getTransaction().commit();
		session.close();
    }
}
