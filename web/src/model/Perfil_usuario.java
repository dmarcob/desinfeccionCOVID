package model;

public class Perfil_usuario {
	static Integer idUser = 1; 
	String nickName;
	String direccion;
	String email;
	String telefono;
	String nombre;
	String apellidos;
	
	public Perfil_usuario(String nickName, String direccion, String email,
			String telefono, String nombre, String apellidos) {
		this.nickName = nickName;
		this.direccion = direccion;
		this.email = email;
		this.telefono =telefono;
		this.nombre = nombre;
		this.apellidos = apellidos;
		idUser++;
	}
	
	public static Integer getIdUser() {
		return idUser;
	}
	public static void setIdUser(Integer idUser) {
		Perfil_usuario.idUser = idUser;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
}
