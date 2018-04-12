package ua.training.electriberies.model.dao.interfaces;

import java.util.List;

public interface GenericDAO<E> extends AutoCloseable {
	
	E create(E entity);
	
	E getById(int id);
		
	E update(E entity);
	
	E delete(E entity);
	
	List<E> getAll();

}
