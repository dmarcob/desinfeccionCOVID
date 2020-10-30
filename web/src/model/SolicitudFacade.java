package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionManager;

public class SolicitudFacade {
	
	private static String tablaServicios = "INSERT INTO web.servicios(nombre, descripcion, precio) VALUES(?, ?, ?)";
	private static String tablaSolicitud = "INSERT INTO web.solicitud(direccion, fecha, hora, mensaje, estado, idsolicitud, servicio, usuario) VALUES(?, ?, ?, ?, ?, DEFAULT, ?, ?)";
	private static String selectByUsuarioAndOffset = "SELECT * FROM web.solicitud WHERE usuario=? ORDER BY idsolicitud DESC LIMIT ? OFFSET ?";
	private static String selectByEstado = "SELECT * FROM web.solicitud WHERE estado=?";
	private static String countByUsuario = "SELECT count(*) cuenta FROM web.solicitud WHERE usuario = ?";

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
			nuevoU.setString(2, solicitude.getFecha());
			nuevoU.setString(3, solicitude.getHora());
			nuevoU.setString(4, solicitude.getMensaje());
			nuevoU.setString(5, solicitude.getEstado());
			nuevoU.setString(6, solicitude.getServicio());
			nuevoU.setString(7, solicitude.getUsuario());
			
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
	
	public List<SolicitudVO> historialUsuario(UsuarioVO user, int paginaActual, int solicitudesPorPagina) throws SQLException {
		ResultSet result = null;
		Connection conn = null;
		List<SolicitudVO> l = null;
		
		try {
			conn = ConnectionManager.getConnection();
			int offset = (paginaActual - 1) * solicitudesPorPagina;
			PreparedStatement solicitudesN = conn.prepareStatement(selectByUsuarioAndOffset);
			solicitudesN.setString(1, user.getnickname());
			solicitudesN.setInt(2, solicitudesPorPagina);
			solicitudesN.setInt(3, offset);
			System.out.println("offset ->"+ offset);

			result = solicitudesN.executeQuery();
			l = new ArrayList();
			while (result.next()) {
				l.add(new SolicitudVO(result.getString("direccion"), result.getString("fecha"), 
								result.getString("hora"),result.getString("mensaje"),
								result.getString("estado"), result.getString("servicio"), result.getString("usuario")));
				System.out.println(result.getString("direccion"));
			}
			
		} catch(SQLException se) {
			se.printStackTrace();  
		
		} catch(Exception e) {
			e.printStackTrace(System.err); 
		} finally {
			db.ConnectionManager.releaseConnection(conn); 
		}
		return l;
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
	
	public int numSolicitudesUsuario(UsuarioVO usuario) {
		int resultado = 0;
		Connection conn = null;	
		try {
			conn = ConnectionManager.getConnection();
			PreparedStatement solicitudesU = conn.prepareStatement(countByUsuario);
			solicitudesU.setString(1, usuario.getnickname());
			ResultSet countRs = solicitudesU.executeQuery();
			countRs.next();
			resultado = countRs.getInt(1);
			System.out.println("Número de solicitudes usuario: " + resultado);
		} catch(SQLException se) {
			se.printStackTrace();  	
		}
		return resultado;
	}
}

