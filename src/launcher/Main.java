package launcher;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.DAOFactory;
import dao.Execute;
import models.Address;
import models.Customer;
import models.Product;

public class Main {

	private void hibernate() throws Exception {

		SessionFactory sessionFactory = new Configuration().configure("/configs/hibernate.cfg.xml")
				.buildSessionFactory();

		DAOFactory dao = new DAOFactory(sessionFactory);
		Execute execute = dao.buildExecution("PRODUCT");

		Product model = new Product();
		model.setName("LUX");
		model.setPrice(220.5);
		execute.insert(model);

		List<Product> prods = execute.retrieveAll();

		System.out.println("hello");
		for (Product prod : prods) {
			System.out.println(prod.getProduct_id() + " " + prod);
		}

		execute = dao.buildExecution("CUSTOMER");
		// System.out.println(execute.retrieveById(3));

		Address address = new Address("Mogda2", "Mohakhali", "DHAKA");
		Customer model2 = new Customer("LITON", "SAIFUL", address);

		execute.insert(model2);

		List<Customer> lists = execute.retrieveAll();

		for (Customer customer : lists) {
			System.out.println(customer);
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
