package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import models.Address;
import models.Customer;

public class CustomerDAO implements Execute<Customer> {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private String SQL;

	protected CustomerDAO(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Customer> retrieveAll() {

		List<Customer> customers = null;
		SQL = "from CUSTOMER";

		try {

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			customers = session.createQuery(SQL).list();
			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception\
			System.out.println("CustomerDAO : " + e.getMessage());
		} finally {
			session.close();

		}

		return customers;
	}

	@Override
	public Customer retrieveById(Object id) {
		Customer customer = null;
		try {
			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			customer = session.get(Customer.class, (Integer) id);

			transaction.commit();

		} catch (Exception e) {
			System.out.println("CustomerDAO  retrieveById : " + e.getMessage());
		} finally {
			session.close();
		}
		return customer;
	}

	@Override
	public boolean insert(Customer model) {

		try {

			session = sessionFactory.openSession();

			transaction = session.beginTransaction();
			session.save(model);
			transaction.commit();

		} catch (Exception ex) {
			System.out.println("CUSTOMER_DAO : " + ex.getMessage());

		} finally {
			session.close();
			// session.clear();

		}
		return false;
	}

	@Override
	public boolean update(Object id, Object set) {
		// TODO Auto-generated method stub
		return false;
	}

}
