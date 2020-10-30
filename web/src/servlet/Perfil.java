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
@WebServlet("/perfil")
public class Perfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Perfil() {
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
				//Usuario logeado
				if (request.getParameter("nombre") != null) {
					//Usuario ha actualizado su información de perfil
					UserFacade dao = new UserFacade();
					UsuarioVO user = (UsuarioVO) request.getSession().getAttribute("user");
					Perfil_usuarioVO perfil = new Perfil_usuarioVO(user.getnickname(), 
						request.getParameter("direccion"), request.getParameter("email"), 
						request.getParameter("telefono"), request.getParameter("nombre"), 
						request.getParameter("apellidos"));	
					dao.updatePerfil(perfil);
					//Se actualiza el perfil de la sesión
					request.getSession().removeAttribute("perfil");
					request.getSession().setAttribute("perfil",perfil);
				} 
				//Haya o no actualizado la información de perfil, se muestra el perfil actual de la sesión
				request.getRequestDispatcher("perfil.jsp").forward(request, response);
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