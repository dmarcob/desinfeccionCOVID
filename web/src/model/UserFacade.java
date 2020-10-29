package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.ConnectionManager;

public class UserFacade {
	
	private static String tablaUsuario = "INSERT INTO web.usuario(nickname, pwd, admin) VALUES(?, ?, ?)";
	private static String nuevaTablaPerfil = "INSERT INTO web.perfil_usuario(direccion, email, telefono, nombre, apellidos, nickname, iduser) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static String modificarTablaPerfil = "UPDATE web.perfil_usuario SET direccion=?, email=?, telefono=?, nombre=?, apellidos=? WHERE nickname=?";
	private static String countByUserName = "SELECT count(*) cuenta FROM usuario WHERE nickname = ?";
	private static String countByPerfil = "SELECT count(*) cuenta FROM web.perfil_usuario WHERE nickname = ?";
	private static String findByUserName = "SELECT * FROM usuario WHERE nickname = ?";
	//private static String updateDate = "UPDATE users set last_login = current_timestamp where username = ?";
	
	/** * Busca un registro en la tabla DEMO por ID * 
		@param id Identificador del registro buscado * 
	 * @throws SQLException 
		@returnObjeto DemoVO con el identificador buscado, o null si no seencuentra 
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
	
	public boolean modificarPerfil(Perfil_usuario perf) throws SQLException {
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
		
		System.out.print("n es: "+n);
		if (n==0){
			nuevoP = conn.prepareStatement(nuevaTablaPerfil);
			nuevoP.setString(1, perf.getDireccion());
			nuevoP.setString(2, perf.getEmail());
			nuevoP.setString(3, perf.getTelefono());
			nuevoP.setString(4, perf.getNombre());
			nuevoP.setString(5, perf.getApellidos());
			nuevoP.setString(6, perf.getNickName());
			nuevoP.setInt(7, perf.getIdUser());
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
	
	public boolean validateUser(UsuarioVO user) throws SQLException { 
		boolean result = false;
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
			System.out.println("Número de registros: " + n);
			
			
			// Leemos resultados 
			if(n == 1) {
				// Comparamos contraseñas
				findRs.next();
				String dbpwd = findRs.getString("pwd");
				//dbpwd = hash(dbpwd);
				//System.out.print("db: " + dbpwd);
				//System.out.print("us: " + user.getPwd());
				if (dbpwd.contentEquals(user.getPwd())) {
					//updatePs.execute();
					result = true;
				}
			} else { 
				result = false;  
			} 
			
			// liberamos los recursos utilizados
			findRs.close();
			findPs.close();
			countRs.close();
			countPs.close();
			//updatePs.close();

		} catch(SQLException se) {
			se.printStackTrace();  
		
		} catch(Exception e) {
			e.printStackTrace(System.err); 
		} finally {
			db.ConnectionManager.releaseConnection(conn); 
		}
		
		return result;
	}
		
	
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
	
}
