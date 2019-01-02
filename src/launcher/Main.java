package launcher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import models.Customer;

public class Main {

	public static void main(String[] args) {
		
		try {

		Customer customer = new Customer("SAIFUL", "saiful.sust.cse@gmail.com");

		Configuration config = new Configuration().configure("/configs/hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class);

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction trans = session.beginTransaction();

		session.save(customer);
		trans.commit();
		}catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());
		}

	}
}
