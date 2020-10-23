package model;
import java.util.Date;


public class Solicitud {
	static Integer idSolicitud = 1;
	String direccion;
	Date fecha;
	Date hora;
	String mensaje;
	String estado;
	String servicio;
	String usuario;
	
	public Solicitud(String direccion, Date fecha, Date hora, String mensaje,
				String estado, String servicio, String usuario) {
		this.direccion = direccion;
		this.fecha = fecha;
		this.hora = hora;
		this.mensaje = mensaje;
		this.estado = estado;
		this.servicio = servicio;
		this.usuario = usuario;
		idSolicitud++;
	}
	
	public Integer getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
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
