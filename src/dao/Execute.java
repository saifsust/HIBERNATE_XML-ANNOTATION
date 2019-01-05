package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public interface Execute<Model> {

	public List<Model> retrieveAll();

	public Model retrieveById(Object id);

	public boolean insert(Model model);

	public boolean update(Object id, Object set);

	
}
