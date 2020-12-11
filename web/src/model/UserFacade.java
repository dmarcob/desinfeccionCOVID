package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionManager;
/**
 * 
 * @author megalobox team
 * Esta clase implementa el patrón DAO utilizado para las operaciones 
 * de inserción y modificación y búsqueda de usuarios y perfiles de usuario.
 *
 */
public class UserFacade {
	
	private static String tablaUsuario = "INSERT INTO web.usuario(nickname, pwd, admin) VALUES(?, ?, ?)";
	private static String nuevaTablaPerfil = "INSERT INTO web.perfil_usuario(direccion, email, telefono, nombre, apellidos, nickname, iduser) VALUES(?, ?, ?, ?, ?, ?, DEFAULT)";
	private static String modificarTablaPerfil = "UPDATE web.perfil_usuario SET direccion=?, email=?, telefono=?, nombre=?, apellidos=? WHERE nickname=?";
	private static String countByUserName = "SELECT count(*) cuenta FROM usuario WHERE nickname = ?";
	private static String countByPerfil = "SELECT count(*) cuenta FROM web.perfil_usuario WHERE nickname = ?";
	private static String findByUserName = "SELECT * FROM usuario WHERE nickname = ?";
	//private static String modifyUser = "SELECT * FROM usuario WHERE nickname = ?";
	
	/**
	 * Añade un usuario no administrador a la base de datos
	 * @param user
	 * @return  true = operación realizada con éxito | false = operación no se ha podido realizar
	 * @throws SQLException
	 */
	public boolean addUser(UsuarioVO user) throws SQLException {
		boolean result = false;
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
			
			
			PreparedStatement nuevoU = conn.prepareStatement(tablaUsuario);
			nuevoU.setString(1, user.getnickname());
			nuevoU.setString(2, user.getPwd());
			nuevoU.setBoolean(3, user.isAdmin());
			
			nuevoU.executeUpdate();
			
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
	 * Actualiza el perfil de un usuario existente
	 * @param perfil
	 * @return true = operación realizada con éxito | false = operación no se ha podido realizar
	 * @throws SQLException
	 */
	public boolean updatePerfil(Perfil_usuarioVO perfil) throws SQLException {
		boolean result = false;
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getConnection();
		
			PreparedStatement nuevoU = conn.prepareStatement(modificarTablaPerfil);

			nuevoU.setString(1, perfil.getDireccion());
			nuevoU.setString(2, perfil.getEmail());
			nuevoU.setString(3, perfil.getTelefono());
			nuevoU.setString(4, perfil.getNombre());
			nuevoU.setString(5, perfil.getApellidos());
			nuevoU.setString(6, perfil.getNickName());

			nuevoU.executeUpdate();
			
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
	 * Si no exite el perfil del usuario lo crea, en caso contrario lo actualiza
	 * @param perf
	 * @return true = operación realizada con éxito | false = operación no se ha podido realizar
	 * @throws SQLException
	 */
	public boolean modificarPerfil(Perfil_usuarioVO perf) throws SQLException {
		boolean result = false;
		Connection conn = null;
	
	  try {
		conn = ConnectionManager.getConnection();
		
		PreparedStatement countPs = conn.prepareStatement(countByPerfil);
		countPs.setString(1, perf.getNickName());
		ResultSet countRs = countPs.executeQuery();
		countRs.next();
		int n = countRs.getInt(1);
		PreparedStatement nuevoP;
		
		if (n==0){
			nuevoP = conn.prepareStatement(nuevaTablaPerfil);
			nuevoP.setString(1, perf.getDireccion());
			nuevoP.setString(2, perf.getEmail());
			nuevoP.setString(3, perf.getTelefono());
			nuevoP.setString(4, perf.getNombre());
			nuevoP.setString(5, perf.getApellidos());
			nuevoP.setString(6, perf.getNickName());
		}else {
			nuevoP = conn.prepareStatement(modificarTablaPerfil);
			nuevoP.setString(1, perf.getDireccion());
			nuevoP.setString(2, perf.getEmail());
			nuevoP.setString(3, perf.getTelefono());
			nuevoP.setString(4, perf.getNombre());
			nuevoP.setString(5, perf.getApellidos());
			nuevoP.setString(6, perf.getNickName());
		}
		
		nuevoP.executeUpdate();
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
	 * Comprueba si "user" es válido.
	 * @param user
	 * @return 0 = usuario no válido.
	 * 		   1 = usuario normal válido.
	 * 		   2 = usuario administrador válido.
	 * @throws SQLException
	 */
	public int validateUser(UsuarioVO user) throws SQLException { 
		int result = 0;
		Connection conn = null;
		
		try {
			// Abrimos la conexión e inicializamos los parámetros 

			conn = ConnectionManager.getConnection(); 
			PreparedStatement countPs = conn.prepareStatement(countByUserName);
			PreparedStatement findPs = conn.prepareStatement(findByUserName);
			//PreparedStatement updatePs = conn.prepareStatement(updateDate);
			countPs.setString(1, user.getnickname());
			findPs.setString(1, user.getnickname());
			//updatePs.setString(1, user.getnickname());
			
			// Ejecutamos la consulta 
			ResultSet findRs = findPs.executeQuery();
			ResultSet countRs = countPs.executeQuery();
			
			countRs.next();
			int n = countRs.getInt(1);
			
			
			// Leemos resultados 
			if(n == 1) {
				// Comparamos contraseñas
				findRs.next();
				String dbpwd = findRs.getString("pwd");
				Boolean dbadmin = findRs.getBoolean("admin");
			
				if (dbpwd.contentEquals(user.getPwd())) {
					if (dbadmin) {
						result = 2;
					} else {
						result = 1;
					}
				}
			} else { 
				result = 0;  
			} 
			
			// liberamos los recursos utilizados
			findRs.close();
			findPs.close();
			countRs.close();
			countPs.close();

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
	 * @param username
	 * @return usuario cuyo nickname corresponde a "username"
	 * @throws SQLException
	 */
	public UsuarioVO getUser(String username) throws SQLException {
		Connection conn = null;
		UsuarioVO user = null;

		try {
			// Abrimos la conexión e inicializamos los parámetros 
			conn = ConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement("Select * from usuario where nickname= ?");
			ps.setString(1, username);
			ResultSet rset = ps.executeQuery();
			rset.next();
			user = new UsuarioVO(rset.getString("nickname"), rset.getString("pwd"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.ConnectionManager.releaseConnection(conn);
		}
		return user;
	}
	
	/**
	 * 
	 * @param username
	 * @return Devuelve el perfil de usuario cuyo nickname es igual a "username"
	 * @throws SQLException
	 */
	public Perfil_usuarioVO getPerfil(String username) throws SQLException {
		Connection conn = null;
		Perfil_usuarioVO perfil = null;

		try {
			// Abrimos la conexión e inicializamos los parámetros 
			conn = ConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement("Select * from perfil_usuario where nickname= ?");
			ps.setString(1, username);
			ResultSet rset = ps.executeQuery();
			rset.next();
			
			perfil = new Perfil_usuarioVO(rset.getString("nickname"), rset.getString("direccion"), 
					rset.getString("email"), rset.getString("telefono"), rset.getString("nombre"), rset.getString("apellidos"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.ConnectionManager.releaseConnection(conn);
		}
		return perfil;
	}
	
	
	/**
	 * 
	 * @param username
	 * @return true = el usuario cuyo nickname es igual a "username" existe en la base de datos. En
	 * caso contrario devuelve false.
	 * @throws SQLException
	 */
	public Boolean existUser(String username) throws SQLException {
		Connection conn = null;
		Boolean existe = false;

		try {
			// Abrimos la conexión e inicializamos los parámetros 
			conn = ConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement("Select * from usuario where nickname= ?");
			ps.setString(1, username);
			ResultSet rset = ps.executeQuery();
			existe = rset.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.ConnectionManager.releaseConnection(conn);
		}
		return existe;
	}
	
}

