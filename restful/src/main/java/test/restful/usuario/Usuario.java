package test.restful.usuario;

//id, nombre, apellido, email, password
public class Usuario
{
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	
	/**
	 * Constructor vacio para Hibernate
	 */
	public Usuario()
	{
		
	}
	public Usuario(int id, String nombre, String apellido, String email, String password)
	{
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
