package test.restful.usuario.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaDAO <T>
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("TEST");
	EntityManager manager = emf.createEntityManager();
	
	protected void createEntity(T entity) 
	{
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
	}
	@SuppressWarnings("unchecked")
	protected T retrieveEntityById(String entityName, Integer id)
	{
		Query q = manager.createQuery("SELECT c FROM "+entityName+" c WHERE c.id = :id");
		q.setParameter("id", id);
		try 
		{
			return (T) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	protected List<T> retrieveAllEntities(String entityName)
	{
		Query q = manager.createQuery("FROM "+entityName);
		return (List<T>) q.getResultList();
	}
	protected void updateEntity(T entity) 
	{		
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();
	}
	protected void deleteEntity(T entity) 
	{
		manager.getTransaction().begin();
		manager.remove(entity);
		manager.getTransaction().commit();
	}
}
