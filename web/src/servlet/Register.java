package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserFacade;
import model.UsuarioVO;
import model.Perfil_usuarioVO;

/**
 * Servlet implementation class Signin
 */
@WebServlet(description = "Servlet de autenticación del usuario", urlPatterns = { "/register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		UserFacade dao = new UserFacade();		
		
		if (request.getParameter("email") == null){//TODO hacer cosas guays de errores
			System.out.print("\nsi!\n");
			request.setAttribute("error", "email pocho");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else {
			System.out.print("\nsino!\n");
			boolean existe = dao.existUser(request.getParameter("nickname"));
			if (!existe) {
				//
				System.out.print("\n NO EXISTE\n");
				UsuarioVO user = new UsuarioVO(request.getParameter("nickname"), request.getParameter("password"));
				Perfil_usuarioVO nuevo = new Perfil_usuarioVO(request.getParameter("nickname"), request.getParameter("direccion"), request.getParameter("email"), request.getParameter("telefono"), request.getParameter("nombre"), request.getParameter("apellidos"));		
				
				dao.addUser(user);
				dao.modificarPerfil(nuevo);
				user.setPwd(null);
				request.getSession().setAttribute("user",user);
				request.getRequestDispatcher("services_log.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "usuario existente");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}
		}catch(SQLException e) {
			System.out.print("\nSQL murió!\n");
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