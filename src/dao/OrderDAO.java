/**
 * 
 */
package dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import models.Customer;
import models.Order;
import models.Product;

/**
 *
 * @author SAIFUL ISLAM
 * @BATCH SUST CSE 2013-14
 * @Email : saiful.sust.cse@gmail.com
 * @Facebok : https://www.facebook.com/SaifulIslamLitonSust
 */
public class OrderDAO implements Execute<Order> {

	private SessionFactory sessionFactory;
	private Session session;
	private String SQL;
	private Transaction transaction;

	protected OrderDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Order> retrieveAll() {

		List<Order> orders = null;
		try {
			SQL = "select * from PRODUCTS left join ORDERS on (ORDERS.FK_PRODUCT_ID = PRODUCTS.PRODUCT_ID)";
			transaction = null;
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			orders = session.createNativeQuery(SQL, Order.class).list();

			transaction.commit();

		} catch (Exception ex) {
			// TODO: handle exception

			if (transaction == null)
				transaction.rollback();

			System.out.println("INSERT : " + ex.getMessage());
		} finally {
			session.close();
		}
		return orders;
	}

	@Override
	public Order retrieveById(Object id) {

		Order order = null;
		try {
			transaction = null;

			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			order = session.get(Order.class, (int) id);
			transaction.commit();

		} catch (Exception ex) {

			System.out.println("RETRIEVE BY ID : " + ex.getMessage());

			if (transaction == null)
				transaction.rollback();
		} finally {
			session.close();
		}

		return order;
	}

	@Override
	public boolean insert(Order model) {
		try {
			transaction = null;
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(model);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction == null)
				transaction.rollback();
			System.out.println("ORDER INSERT : " + ex.getMessage());
		} finally {

			session.close();
		}
		return false;
	}

	@Override
	public boolean update(Object id, Object set) {
		// TODO Auto-generated method stub
		return false;
	}

}
