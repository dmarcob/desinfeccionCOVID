package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserFacade;
import model.UsuarioVO;

/**
 * Servlet implementation class Signin
 */
@WebServlet(description = "Servlet de autenticación del usuario", urlPatterns = { "/signin" })
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
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
			UsuarioVO user = new UsuarioVO(request.getParameter("nickname"), request.getParameter("password"), false);
			boolean valido = dao.validateUser(user);
			if (valido) {
				Perfil_usuarioVO n
				user.setPwd(null);
				request.getSession().setAttribute("user",user);
				request.getRequestDispatcher("logged.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "invalid password");
				request.getRequestDispatcher("signin.jsp").forward(request, response);
			}
		}
		}catch(Exception e) {
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