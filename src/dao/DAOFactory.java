package dao;

import org.hibernate.SessionFactory;

public class DAOFactory {

	private SessionFactory sessionFactory;

	public DAOFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Execute buildExecution(String model) {

		if (model.equalsIgnoreCase("CUSTOMER") || model.equalsIgnoreCase("customer")) {
			return new CustomerDAO(sessionFactory);
		}

		if (model.equalsIgnoreCase("PRODUCT") || model.equalsIgnoreCase("product")) {
			return new ProductDAO(sessionFactory);
		}

		if (model.equalsIgnoreCase("ORDER") || model.equalsIgnoreCase("order")) {
			return new OrderDAO(sessionFactory);
		}

		return null;
	}

}
