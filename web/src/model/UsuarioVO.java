package model;

import java.util.Date;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.PoolConnectionManager;

/**
 * tabla users
 * @author sisinf
 *
 */
public class UsuarioVO {
	private String nickname;
	private String pwd;
	private boolean admin;
	
	/**
	 * Constructor
	 * @param nickname
	 * @param password
	 */
	public UsuarioVO(String nickname, String pwd) {
		this.nickname = nickname;
		setPwd(pwd);
		this.admin = false;
	}
	
	public UsuarioVO(String nickname, String pwd, Boolean admin) {
		this.nickname = nickname;
		setPwd(pwd);
		this.admin=admin;
	}
	
	public String getnickname() {
		return nickname;
	}
	public void setnickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = hash(pwd);
		System.out.println(this.pwd);
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	private String hash(String pwd) {
		Integer hash = 7;
		for(int i = 0; i < pwd.length(); i++) {
			hash = hash*31 + pwd.charAt(i);
		}
		return hash.toString();
	}
	
}
