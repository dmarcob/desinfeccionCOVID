package servlet;

import model.Perfil_usuarioVO;
import model.ServiciosVO;
import model.SolicitudVO;
import model.UserFacade;
import model.SolicitudFacade;
import model.UsuarioVO;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserFacade facade2 = new UserFacade();
		SolicitudFacade facade = new SolicitudFacade();
		UsuarioVO user, usuario1, usuario2;
		try {
			ServiciosVO ser = new ServiciosVO("Mo", "asd", 42);
			System.out.println("Crear Serv "+facade.addServicio(ser)+"\n");
			
			java.sql.Date f = new java.sql.Date(5000000);
			java.sql.Time h = new java.sql.Time(5000);
			SolicitudVO sol = new SolicitudVO("ass", f, h, "asd", "asd", "Mo", "A");
			System.out.println("Crear Sol "+facade.addSolicitud(sol)+"\n");
			//Perfil_usuario perf1 = new Perfil_usuario("Al", "asd", "adsfgh", "12345", "asd", "asd");
			
			//System.out.println("Modificado perfil:  "+facade.modificarPerfil(perf1)+"\n");
			//usuario1 = new UsuarioVO("Alo", "12345", true);
			//usuario2 = new UsuarioVO("Bob", "54321", false);
			
			//System.out.println("Crear A "+facade.addUser(usuario1)+"\n");
			//System.out.println("Crear B "+facade.addUser(usuario2)+"\n");
			
			//user = facade.getUser("pepe");
			//System.out.println("username = " + user.getnickname());
			//System.out.println("password = " + user.getPwd());
			//request.setAttribute("user", user);
			
			//System.out.println("Validar "+facade.validateUser(user));
			
			response.sendRedirect("index.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}