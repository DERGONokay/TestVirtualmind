package test.restful.usuario.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaDAO <T>
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("TEST");
	EntityManager manager = emf.createEntityManager();
	
	protected void create(T entity) 
	{
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
	}
	@SuppressWarnings("unchecked")
	protected T retrieveById(String table, Integer id)
	{
		Query q = manager.createQuery("SELECT c FROM "+table+" c WHERE c.id = :id");
		q.setParameter("id", id);
		try 
		{
			return (T) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	protected void update(T entity) 
	{		
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();
	}
	protected void delete(T entity) 
	{
		manager.getTransaction().begin();
		manager.remove(entity);
		manager.getTransaction().commit();
	}
}
