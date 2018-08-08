package test.restful.usuario.persistencia;

import test.restful.usuario.model.Usuario;

public class UsuarioDAO extends JpaDAO <Usuario>
{

	public void crear(Usuario usuario) 
	{
		create(usuario);
	}
	
	public Usuario obtener(int id)
	{
		
		return retrieveById("Usuario",id);
	}

	public void actualizar(Usuario usuario) 
	{
		update(usuario);
	}

	public void eliminar(Usuario usuario) 
	{
		delete(usuario);
	}
	
}
