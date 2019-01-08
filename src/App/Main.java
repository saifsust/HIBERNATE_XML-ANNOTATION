package App;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.DAOFactory;
import dao.Execute;
import models.Address;
import models.Customer;
import models.Order;
import models.Product;

public class Main {

	private void hibernate() throws Exception {

		SessionFactory sessionFactory = new Configuration().configure("/configs/hibernate.cfg.xml")
				.buildSessionFactory();

		DAOFactory dao = new DAOFactory(sessionFactory);
		Execute execute = dao.buildExecution("customer");

		Address address = new Address("Mohakhali", "Khilgaon", "DHAKA");

		Customer customer = new Customer("SAIFUL", "ISLAM", address);

		// execute.insert(customer);

		/*
		 * List<Customer> customers = execute.retrieveAll();
		 * 
		 * for (Customer cstmr : customers) {
		 * 
		 * System.out.println(cstmr); }
		 */

		execute = dao.buildExecution("product");

		Product product = new Product("LUX SABAN", 230.67);

		// execute.insert(product);
		/*
		 * List<Product> products = execute.retrieveAll();
		 * 
		 * for (Product prdct : products) { System.out.println(prdct); }
		 */

		execute = dao.buildExecution("ORDER");

		List<Product> prodts = new ArrayList<>();
		customer.setCustomerId(2);
		product.setProductId(3);
		Order order = new Order(product);

		// execute.insert(order);

		// System.out.println(execute.retrieveById(2));

		System.out.println(execute.retrieveById(1));
		/*
		 * List<Order> orders = execute.retrieveAll();
		 * 
		 * for (Order odr : orders) { System.out.println(odr); }
		 */

		List<Order> prdcts = execute.retrieveAll();

		for (Order prdct : prdcts) {
			System.out.println(prdct);
		}

	}

	public static void main(String[] args) {

		try {
			new Main().hibernate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
}
