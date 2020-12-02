package model;

import java.util.Date;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

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
		if (pwd != null){
			this.pwd = hash(pwd);
			//System.out.println(this.pwd);
		}else {
			this.pwd = null;
		}
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	

	  

	public String hash(String input) { 
	    try { 
	            MessageDigest md = MessageDigest.getInstance("MD5"); 
	            byte[] messageDigest = md.digest(input.getBytes()); 
	            BigInteger no = new BigInteger(1, messageDigest); 
	            String hashtext = no.toString(16); 
	            while (hashtext.length() < 32) { 
	                hashtext = "0" + hashtext; 
	            } 
	            return hashtext; 
	        }  
	        catch (NoSuchAlgorithmException e) { 
	            throw new RuntimeException(e); 
	        } 
	    } 
	
	
	/*
	public String hash(String pwd) {
		Integer hash = 7;
		for(int i = 0; i < pwd.length(); i++) {
			hash = hash*31 + pwd.charAt(i);
		}
		return hash.toString();
	}*/
	
}
