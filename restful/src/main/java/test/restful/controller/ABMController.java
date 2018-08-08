package test.restful.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.restful.usuario.model.Usuario;
import test.restful.usuario.persistencia.UsuarioDAO;

@RestController
public class ABMController 
{
	@RequestMapping(value = "/usuario/alta", method = RequestMethod.POST)
	public void alta(@RequestBody JSONObject body) throws JSONException
	{
		Usuario u = new Usuario();
		UsuarioDAO udao = new UsuarioDAO();
		
		u.setNombre((String)body.get("nombre"));
		u.setApellido((String)body.get("apellido"));
		u.setEmail((String)body.get("email"));
		u.setPassword((String)body.get("password"));
		
		udao.create(u);
	}
	@RequestMapping(value = "/usuario/baja/{id}", method = RequestMethod.POST)
	public void baja(@PathVariable Integer id)
	{
		UsuarioDAO udao = new UsuarioDAO();
		Usuario u = udao.retireve(id);
		udao.delete(u);
	}
	@RequestMapping(value = "/usuario/modificaion/{id}", method = RequestMethod.POST)
	public void modificacion(@PathVariable Integer id, @RequestBody JSONObject body) throws JSONException
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
