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
			UserFacade dao = new UserFacade();
			Perfil_usuarioVO perfil = null;
			UsuarioVO user = (UsuarioVO) request.getSession().getAttribute("user");
			System.out.println("user ->" + user.getnickname());
				perfil = dao.getPerfil(user.getnickname());
			
			System.out.println("perfil ->" + perfil.getNombre());
			request.setAttribute("nombre", perfil.getNombre());
			request.setAttribute("apellidos", perfil.getApellidos());
			request.setAttribute("direccion", perfil.getDireccion());
			request.setAttribute("email", perfil.getEmail());
			request.setAttribute("telefono", perfil.getTelefono());			
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