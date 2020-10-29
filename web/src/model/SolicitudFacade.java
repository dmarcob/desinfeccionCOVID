package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import db.ConnectionManager;

public class SolicitudFacade {
	
	private static String tablaServicios = "INSERT INTO web.servicios(nombre, descripcion, precio) VALUES(?, ?, ?)";
	private static String tablaSolicitud = "INSERT INTO web.solicitud(direccion, fecha, hora, mensaje, estado, idsolicitud, servicio, usuario) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	private static String selectByName = "SELECT * FROM web.solicitud WHERE nickname=?";
	private static String selectByEstado = "SELECT * FROM web.solicitud WHERE estado=?";
	//private static String updateDate = "UPDATE users set last_login = current_timestamp where username = ?";
	
	/** * Busca un registro en la tabla DEMO por ID * 
		@param id Identificador del registro buscado * 
	 * @throws SQLException 
		@returnObjeto DemoVO con el identificador buscado, o null si no seencuentra 
	*/
	
	public boolean addServicio(ServiciosVO service) throws SQLException {
		boolean result = false;
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			
			
			PreparedStatement nuevoU = conn.prepareStatement(tablaServicios);
			nuevoU.setString(1, service.getNombre());
			nuevoU.setString(2, service.getDescripcion());
			nuevoU.setInt(3, service.getPrecio());
			
			nuevoU.executeUpdate();
			
			result = true;
		} catch(SQLException se) {
			se.printStackTrace();  
		
		} catch(Exception e) {
			e.printStackTrace(System.err); 
		} finally {
			db.ConnectionManager.releaseConnection(conn); 
		}
		return result;
	}
	
	public boolean addSolicitud(SolicitudVO solicitude) throws SQLException {
		boolean result = false;
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			
			
			PreparedStatement nuevoU = conn.prepareStatement(tablaSolicitud);
			nuevoU.setString(1, solicitude.getDireccion());
			nuevoU.setDate(2, solicitude.getFecha());
			nuevoU.setTime(3, solicitude.getHora());
			nuevoU.setString(4, solicitude.getMensaje());
			nuevoU.setString(5, solicitude.getEstado());
			nuevoU.setInt(6, solicitude.getIdSolicitud());
			nuevoU.setString(7, solicitude.getServicio());
			nuevoU.setString(8, solicitude.getUsuario());
			
			nuevoU.executeUpdate();
			
			result = true;
		} catch(SQLException se) {
			se.printStackTrace();  
		
		} catch(Exception e) {
			e.printStackTrace(System.err); 
		} finally {
			db.ConnectionManager.releaseConnection(conn); 
		}
		return result;
	}
	
	public ResultSet historialUsuario(UsuarioVO user) throws SQLException {
		ResultSet result = null;
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			
			
			PreparedStatement solicitudesN = conn.prepareStatement(selectByName);
			solicitudesN.setString(1, user.getnickname());
			
			result = solicitudesN.executeQuery();
			
		} catch(SQLException se) {
			se.printStackTrace();  
		
		} catch(Exception e) {
			e.printStackTrace(System.err); 
		} finally {
			db.ConnectionManager.releaseConnection(conn); 
		}
		return result;
	}
	
	public ResultSet historialEstado(String estado) throws SQLException {
		ResultSet result = null;
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			
			
			PreparedStatement solicitudesE = conn.prepareStatement(selectByEstado);
			solicitudesE.setString(1, estado);
			
			result = solicitudesE.executeQuery();
			
		} catch(SQLException se) {
			se.printStackTrace();  
		
		} catch(Exception e) {
			e.printStackTrace(System.err); 
		} finally {
			db.ConnectionManager.releaseConnection(conn); 
		}
		return result;
	}
}

