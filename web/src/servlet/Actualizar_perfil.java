package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Perfil_usuarioVO;
import model.UserFacade;
import model.UsuarioVO;

/**
 * Servlet implementation class Logged
 */
@WebServlet("/actualizar_perfil")
public class Actualizar_perfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Actualizar_perfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		if (request.getSession().getAttribute("user") == null) { // No hay usuario logado
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			UserFacade dao = new UserFacade();
			Perfil_usuarioVO perfil = new Perfil_usuarioVO(request.getParameter("nickname"), 
					request.getParameter("direccion"), request.getParameter("email"), 
					request.getParameter("telefono"), request.getParameter("nombre"), 
					request.getParameter("apellidos"));	
			dao.updatePerfil(perfil);

			request.getRequestDispatcher("perfil").forward(request, response);
			
		}
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