package test.restful;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import test.restful.usuario.model.Usuario;
import test.restful.usuario.persistencia.UsuarioDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioTest 
{
	static UsuarioDAO udao;
	static Usuario usuario;
	
	/**
	 * Inicializa las variables necesarias para los test.
	 */
	@BeforeClass
	public static void initialize()
	{
		udao = new UsuarioDAO();
		usuario = new Usuario();
		
		usuario.setNombre("nombreTest");
		usuario.setApellido("apellidoTest");
		usuario.setEmail("email@test.com");
		usuario.setPassword("passwordTest");
	}
	/**
	 * Verifica que el usuario se persista de manera adecuada
	 */
	@Test
	public void test1() 
	{
		assertTrue(udao.create(usuario));
	}
	/**
	 * Verifica que el usuario se actualice
	 */
	@Test
	public void test2()
	{
		usuario.setNombre("testUpdate");
		assertTrue(udao.update(usuario));
	}
	/**
	 * Verifica que el usuario pueda ser obtenido de la base de datos
	 */
	@Test
	public void test3()
	{
		assertTrue(udao.retireve(usuario.getId()).getNombre().equals("testUpdate"));
	}
	/**
	 * Verifica que se pueda eliminar el usuario de la base de datos
	 */
	@Test
	public void test4()
	{
		String id = usuario.getId();
		udao.delete(usuario);
		assertTrue(udao.retireve(id) == null);
	}

}
