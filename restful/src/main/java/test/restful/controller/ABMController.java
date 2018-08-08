package test.restful.controller;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
	public void alta(@RequestBody String body, HttpServletResponse response) throws ParseException
	{
		System.out.println("Dando alta a usuario");
		Usuario u = new Usuario();
		UsuarioDAO udao = new UsuarioDAO();
		JSONObject jsonBody = (JSONObject) new JSONParser().parse(body);
		
		u.setNombre((String)jsonBody.get("nombre"));
		u.setApellido((String)jsonBody.get("apellido"));
		u.setEmail((String)jsonBody.get("email"));
		u.setPassword((String)jsonBody.get("password"));
			
	}
	@RequestMapping(value = "/usuario/baja/{id}", method = RequestMethod.POST)
	public void baja(@PathVariable Integer id)
	{
		UsuarioDAO udao = new UsuarioDAO();
		Usuario u = udao.retireve(id);
		udao.delete(u);
	}
	@RequestMapping(value = "/usuario/modificaion/{id}", method = RequestMethod.POST)
	public void modificacion(@PathVariable Integer id, @RequestBody JSONObject body)
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
