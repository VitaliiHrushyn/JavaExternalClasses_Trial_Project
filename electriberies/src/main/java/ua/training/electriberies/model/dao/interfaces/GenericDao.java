//package ua.training.electriberies.model.dao.interfaces;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public interface GenericDao<T> {
//	
//	 List<T> getAll() throws SQLException;
//	 
//	 T getById(int id) throws SQLException;
//	 
//	 T update(T entity) throws SQLException;
//	 
//	 boolean delete(int id) throws SQLException;
//	 
//	 boolean create(T entity) throws SQLException;
//	 
//	 /** Создает новую запись и соответствующий ей объект */
//	 public T create() throws SQLException;
//
//	 /** Создает новую запись, соответствующую объекту object */
//	 public T persist(T object)  throws SQLException;
//
//}
