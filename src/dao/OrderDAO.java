/**
 * 
 */
package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import models.Order;

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

	protected OrderDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Order> retrieveAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order retrieveById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Order model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object id, Object set) {
		// TODO Auto-generated method stub
		return false;
	}

}
