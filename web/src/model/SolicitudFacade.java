package model;
/**
 * 
 * @author megalobox team
 * Esta clase implementa el patrón DAO utilizado para las operaciones 
 * de inserción y búsqueda de solicitudes y servicios en la base de datos.
 *
 */
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
	private static String modificarSolicitud = "UPDATE web.solicitud SET estado=? WHERE idsolicitud=?";
	private static String selectByUsuarioAndOffset = "SELECT * FROM web.solicitud WHERE usuario=? ORDER BY idsolicitud DESC LIMIT ? OFFSET ?";
	private static String selectByEstado = "SELECT * FROM web.solicitud WHERE estado=? ORDER BY idsolicitud ASC LIMIT ? OFFSET ?";
	private static String countByUsuario = "SELECT count(*) cuenta FROM web.solicitud WHERE usuario = ?";
	private static String countByEstado = "SELECT count(*) cuenta FROM web.solicitud WHERE estado = ?";
	private static String selectEmail = "SELECT email FROM web.perfil_usuario WHERE nickname = (SELECT usuario from web.solicitud where idsolicitud = ?)";



	/**
	 * Inserta un servicio no existente en la base de datos.
	 * @param service
	 * @return true = operación realizada con éxito | false = operación no se ha podido realizar
	 * @throws SQLException
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
	
	/**
	 * Añade una solicitud nueva de servicio realizada por un usuario
	 * registrado.
	 * @param solicitude
	 * @return true = operación realizada con éxito | false = operación no se ha podido realizar
	 * @throws SQLException
	 */
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
	
	
	/**
	 * Modifica el estado de una solicitud existente en la base de datos
	 * por petición del administrador.
	 * @param estado
	 * @param idSolicitud
	 * @return true = operación realizada con éxito | false = operación no se ha podido realizar
	 * @throws SQLException
	 */
	public boolean modificarSolicitud(String estado, int idSolicitud) throws SQLException {
		boolean result = false;
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			
			
			PreparedStatement nuevoU = conn.prepareStatement(modificarSolicitud);
			nuevoU.setString(1, estado);
			nuevoU.setInt(2, idSolicitud);
			
			
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
	
	/**
	 *
	 * @param user
	 * @param paginaActual
	 * @param solicitudesPorPagina
	 * @return Devuelve la lista de solicitudes realizadas por el usuario "user" correspondientes a la página
	 * "páginaActual", de tamaño "solicitudesPorPagina".
	 * @throws SQLException
	 */
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

			result = solicitudesN.executeQuery();
			l = new ArrayList();
			while (result.next()) {
				l.add(new SolicitudVO(result.getString("direccion"), result.getString("fecha"), 
								result.getString("hora"),result.getString("mensaje"),
								result.getString("estado"), result.getString("servicio"), result.getString("usuario")));
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
	
	/**
	 * 
	 * @param estado
	 * @param paginaActual
	 * @param solicitudesPorPagina
	 * @return Devuelve una lista de solicitudes cuyo estado corresponde a "estado", en la página "paginaActual",
	 * de tamaño "solicitudesPorPagina".
	 * @throws SQLException
	 */
	public List<SolicitudVO> historialEstado(String estado, int paginaActual, int solicitudesPorPagina) throws SQLException {
		ResultSet result = null;
		Connection conn = null;
		List<SolicitudVO> l = null;
		
		try {
			conn = ConnectionManager.getConnection();
			int offset = (paginaActual - 1) * solicitudesPorPagina;
			PreparedStatement solicitudesN = conn.prepareStatement(selectByEstado);
			solicitudesN.setString(1, estado);
			solicitudesN.setInt(2, solicitudesPorPagina);
			solicitudesN.setInt(3, offset);

			result = solicitudesN.executeQuery();
			l = new ArrayList();
			while (result.next()) {
				SolicitudVO solicitud= new SolicitudVO(result.getString("direccion"), result.getString("fecha"), 
						result.getString("hora"),result.getString("mensaje"),
						result.getString("estado"), result.getString("servicio"), result.getString("usuario"));
				solicitud.setId(result.getInt("idsolicitud"));
				l.add(solicitud);
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
	
	
	/**
	 * 
	 * @param usuario
	 * @return Número solicitudes realizadas por el usuario "usuario"
	 */
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
		} catch(SQLException se) {
			se.printStackTrace();  	
		}
		return resultado;
	}
	
	public int numSolicitudesEstado(String estado) {
		int resultado = 0;
		Connection conn = null;	
		try {
			conn = ConnectionManager.getConnection();
			PreparedStatement solicitudesU = conn.prepareStatement(countByEstado);
			solicitudesU.setString(1, estado);
			ResultSet countRs = solicitudesU.executeQuery();
			countRs.next();
			resultado = countRs.getInt(1);
		} catch(SQLException se) {
			se.printStackTrace();  	
		}
		return resultado;
	}
	
	/**
	 * 
	 * @param id
	 * @return Una cadena  correspondiente al email del usuario que ha enviado una solicitud de id "id"
	 */
	public String emailSolicitud(int id) {
		String email = null;
		Connection conn = null;	
		try {
			conn = ConnectionManager.getConnection();
			PreparedStatement solicitudesU = conn.prepareStatement(selectEmail);
			solicitudesU.setInt(1, id);
			ResultSet countRs = solicitudesU.executeQuery();
			countRs.next();
			email = countRs.getString(1);
		} catch(SQLException se) {
			se.printStackTrace();  	
		}
		return email;
		
	}
	
}

