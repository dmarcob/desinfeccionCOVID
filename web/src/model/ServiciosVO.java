package model;
/**
 * 
 * @author megalobox team
 * Esta clase implementa el patrón VO de la entidad servicios.
 *
 */
public class ServiciosVO {
	String nombre;
	String descripcion;
	Integer precio;
	public ServiciosVO(String nombre, String descripcion, Integer precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
}
