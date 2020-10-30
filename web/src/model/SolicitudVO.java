package model;



public class SolicitudVO {
	String direccion;
	String fecha;
	String hora;
	String mensaje;
	String estado;
	String servicio;
	String usuario;
	
	public SolicitudVO(String direccion, String fecha, String hora, String mensaje,
				String estado, String servicio, String usuario) {
		this.direccion = direccion;
		this.fecha = fecha;
		this.hora = hora;
		this.mensaje = mensaje;
		this.estado = estado;
		this.servicio = servicio;
		this.usuario = usuario;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
