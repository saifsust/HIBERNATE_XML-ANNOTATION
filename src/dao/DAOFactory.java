package dao;

import org.hibernate.SessionFactory;

public class DAOFactory {

	private SessionFactory sessionFactory;

	public DAOFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Execute buildExecution(String model) {

		if (model.equals("CUSTOMER")) {
			return new CustomerDAO(sessionFactory);
		}

		if (model.equals("PRODUCT")) {
			return new ProductDAO(sessionFactory);
		}

		if (model.equals("ORDER")) {
			return new OrderDAO(sessionFactory);
		}

		return null;
	}

}
