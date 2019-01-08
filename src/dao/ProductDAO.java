package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import models.Product;

public class ProductDAO implements Execute<Product> {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private String SQL;

	protected ProductDAO(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Product> retrieveAll() {
		// TODO Auto-generated method stub

		List<Product> products = null;
		try {
			session = sessionFactory.openSession();
			SQL = "from PRODUCT";
			session.beginTransaction();
			products = session.createQuery(SQL, Product.class).list();
			session.getTransaction().commit();

		} catch (Exception e) {

			System.out.println("Retrieve All : " + e.getMessage());
		} finally {
			session.close();
		}

		return products;
	}

	@Override
	public Product retrieveById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Product model) {

		try {

			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			/*
			 * SQL = "INSERT INTO PRODUCTS(name,price) values " + model; Query query =
			 * session.createNativeQuery(SQL);
			 * 
			 * query.executeUpdate();
			 */

			session.save(model);

			transaction.commit();

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("PRODUCTDAO INSERT EXCEPTION : " + e.getMessage());
			return false;
		} finally {

			session.close();
			// System.out.println("FINISHED");

		}

		return true;
	}

	@Override
	public boolean update(Object id, Object set) {
		// TODO Auto-generated method stub
		return false;
	}

}
