package test.restful.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.restful.usuario.model.Usuario;
import test.restful.usuario.persistencia.UsuarioDAO;

/**
 * Controlador para el manejo de los usuarios dentro de la base de datos
 * @author Damian Lisas
 */
@RestController
public class ABMController 
{
	/**
	 * Devuelve todos los usuarios en la base de datos
	 * @return Una lista de usuarios
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public List<Usuario> usuario()
	{
		UsuarioDAO udao = new UsuarioDAO();
		
		return udao.retrieveAll();
	}
	/**
	 * Crea un nuevo usuario y lo almacena en la base de datos
	 * @param body Datos del usuario
	 */
	@RequestMapping(value = "/usuario/alta", method = RequestMethod.POST)
	public void alta(@RequestBody JSONObject body)
	{
		Usuario u = new Usuario();
		UsuarioDAO udao = new UsuarioDAO();
		
		u.setNombre((String)body.get("nombre"));
		u.setApellido((String)body.get("apellido"));
		u.setEmail((String)body.get("email"));
		u.setPassword((String)body.get("password"));
		
		udao.create(u);		
	}
	/**
	 * Elimina un usuario de la base de datos segun su id
	 * @param id Id del usuario en la base de datos
	 */
	@RequestMapping(value = "/usuario/baja/{id}", method = RequestMethod.POST)
	public void baja(@PathVariable String id)
	{
		UsuarioDAO udao = new UsuarioDAO();
		Usuario u = udao.retireve(id);
		
		udao.delete(u);
	}
	/**
	 * Modifica al usuario segun su id
	 * @param id Id del usuario en la base de datos
	 * @param body Los nuevos datos del usuario
	 */
	@RequestMapping(value = "/usuario/modificaion/{id}", method = RequestMethod.POST)
	public void modificacion(@PathVariable String id, @RequestBody JSONObject body)
	{
		UsuarioDAO udao = new UsuarioDAO();
		Usuario u = udao.retireve(id);
		
		u.setNombre((String)body.get("nombre"));
		u.setApellido((String)body.get("apellido"));
		u.setEmail((String)body.get("email"));
		u.setPassword((String)body.get("password"));
		
		udao.update(u);
	}
}
