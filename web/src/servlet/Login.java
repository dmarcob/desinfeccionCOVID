package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Perfil_usuarioVO;
import model.UserFacade;
import model.UsuarioVO;

/**
 * Servlet implementation class Signin
 */
@WebServlet(description = "Servlet de autenticación del usuario", urlPatterns = { "/signin" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		UserFacade dao = new UserFacade();		
		
		if (false){//TODO hacer cosas guays de errores
			System.out.print("\nsi!\n");
			request.setAttribute("error", "email pocho");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			System.out.print("\nsino!\n");
			UsuarioVO user = new UsuarioVO(request.getParameter("nickname"), request.getParameter("password"), false);
			int valido = dao.validateUser(user);
			if (valido > 0) {
				Perfil_usuarioVO n;
				user.setPwd(null);
				request.getSession().setAttribute("user",user);
				request.setAttribute("nombre", user.getnickname());
				if (valido == 2) {
					System.out.println("SOY ADMIN");
					request.getRequestDispatcher("historialP.jsp").forward(request, response);

				} else {
					System.out.println("NO SOY NADAAA");

					request.getRequestDispatcher("services_log.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("error", "Contraseña invalida o usuario no existente");
				request.getRequestDispatcher("login.jsp").forward(request, response);
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