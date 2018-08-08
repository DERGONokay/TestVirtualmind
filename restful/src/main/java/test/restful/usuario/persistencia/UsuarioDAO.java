package test.restful.usuario.persistencia;

import java.util.List;

import test.restful.usuario.model.Usuario;

public class UsuarioDAO extends JpaDAO <Usuario>
{
	
	public void create(Usuario usuario) 
	{
		createEntity(usuario);
	}
	
	public Usuario retireve(int id)
	{
		
		return retrieveEntityById("Usuario",id);
	}
	public List<Usuario> retrieveAll()
	{
		return (List<Usuario>) retrieveAllEntities("Usuario");
	}

	public void update(Usuario usuario) 
	{
		updateEntity(usuario);
	}

	public void delete(Usuario usuario) 
	{
		deleteEntity(usuario);
	}
}
