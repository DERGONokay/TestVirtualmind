package test.restful.usuario.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad para representar un usuario
 * @author Damian Lisas
 */
@Entity
@Table(name = "User")
public class Usuario
{
	/**
	 * Valor unico que representa al usuario dentro de la base de datos
	 */
	@Id
	private String id = UUID.randomUUID().toString();
	
	/**
	 * Nombre del usuario
	 */
	@Column(name = "nombre")
	private String nombre;
	
	/**
	 * Apellido del usuario
	 */
	@Column(name = "apellido")
	private String apellido;
	
	/**
	 * Email del usuario
	 */
	@Column(name = "email")
	private String email;
	
	/**
	 * Contrasena del usuario
	 */
	@Column(name = "password")
	private String password;
	
	/**
	 * Constructor vacio para Hibernate
	 */
	public Usuario(){ }
	public Usuario(String id, String nombre, String apellido, String email, String password)
	{
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString()
	{
		return "{\n"
				+ "	ID = "+this.id+"\n"
				+ "	Nombre = "+this.nombre+"\n"
				+ "	Apellido = "+this.apellido+"\n"
				+ "	Email = "+this.email+"\n"
				+ "	Password = "+this.password+"\n"
				+ "}\n";
	}
}
