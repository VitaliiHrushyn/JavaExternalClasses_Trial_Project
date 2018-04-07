package ua.training.electriberies.model.dao.interfaces;

import java.util.List;

public interface DAOInterface<E, K> {
	
	 List<E> getAll();
	 E getById(K id);
	 E update(E entity);
	 boolean delete(K id);
	 boolean create(E entity);

}
