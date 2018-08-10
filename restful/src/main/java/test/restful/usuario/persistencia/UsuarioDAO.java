package test.restful.usuario.persistencia;

import java.util.List;

import test.restful.usuario.model.Usuario;

/**
 * DAO para la persistencia de un usuario
 * @author Damian Lisas
 */
public class UsuarioDAO extends JpaDAO <Usuario>
{
	/**
	 * Persiste un usuario en la base de datos
	 * @param usuario Usuario a persistir
	 */
	public boolean create(Usuario usuario) 
	{
		try
		{
			createEntity(usuario);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Obtiene un usuario de la base de datos por su id
	 * @param id Id del usuario en la base de datos
	 * @return Usuario
	 */
	public Usuario retireve(String id)
	{
		return retrieveEntityById(Usuario.class,id);
	}
	/**
	 * Obtiene todos los usuarios de la base de datos
	 * @return Lista de usuarios
	 */
	public List<Usuario> retrieveAll()
	{
		return (List<Usuario>) retrieveAllEntities("Usuario");
	}
	/**
	 * Actualiza un usuario en la base de datos
	 * @param usuario Usuario a actualizar
	 */
	public boolean update(Usuario usuario) 
	{
		try
		{
			updateEntity(usuario);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Elimina a un usuario de la base de datos
	 * @param usuario Usuario a eliminar
	 */
	public boolean delete(Usuario usuario) 
	{
		try
		{
			deleteEntity(usuario);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
}
