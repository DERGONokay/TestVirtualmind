package test.restful.usuario.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Clase para representar las operaciones CRUD
 * @author Damian Lisas
 * @param <T>
 */
public class JpaDAO <T>
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("TEST");
	EntityManager manager = emf.createEntityManager();
	
	/**
	 * Persiste una entidad en la base de datos
	 * @param entity Entidad a persistir
	 */
	protected void createEntity(T entity) 
	{
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
	}
	/**
	 * Obtiene una entidad de la base de datos segun su id
	 * @param theClass Clase de la entidad
	 * @param id Id de la entidad dentro de la base de datos
	 * @return Entidad
	 */
	protected T retrieveEntityById(Class<T> theClass, String id)
	{
		manager.getTransaction().begin();
		T entity = (T)manager.find(theClass, id);
		manager.getTransaction().commit();
		
		return entity;
	}
	/**
	 * Obtiene todas las entidades de su tabla correspondiente
	 * @param entityName Nombre de la clase de la entidad
	 * @return Lista de entidades
	 */
	@SuppressWarnings("unchecked")
	protected List<T> retrieveAllEntities(String entityName)
	{
		Query q = manager.createQuery("FROM "+entityName);
		return (List<T>) q.getResultList();
	}
	/**
	 * Actualiza una entidad dentro de la base de datos
	 * @param entity Entidad a actualizar
	 */
	protected void updateEntity(T entity) 
	{		
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();
	}
	/**
	 * Elimina una entidad de la base de datos
	 * @param entity Entidad a eliminar
	 */
	protected void deleteEntity(T entity) 
	{
		manager.getTransaction().begin();
		manager.remove(entity);
		manager.getTransaction().commit();
	}
}
