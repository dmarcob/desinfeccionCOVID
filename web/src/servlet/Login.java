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
 * 
 * @author megalobox team
 * Este servlet se invoca cuando un usuario quiere logearse en su cuenta.
 *
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
     * Este servlet se invoca cuando el usuario quiere iniciar sesión.
     * Si el usuario no existe se le redirige a "login.jsp" indicandole el error,
     * Si el usuario existe, dependiendo de si es administrador o no, se invoca
     * el servlet "listar_historial_admin" o se le redirige a "services_log.jsp" respectivamente.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		UserFacade dao = new UserFacade();		
			UsuarioVO user = new UsuarioVO(request.getParameter("nickname"), request.getParameter("password"), false);
			int valido = dao.validateUser(user);
			if (valido > 0) {
				//Usuario existente
				request.getSession().setAttribute("user",user);
				user.setPwd(null);
				if (valido == 2) {
					//Usuario existente y rol administrador
					request.getRequestDispatcher("listar_historial_admin").forward(request, response);

				} else {
					//Usuario existente y rol cliente
					Perfil_usuarioVO perfil = dao.getPerfil(request.getParameter("nickname"));
					request.getSession().setAttribute("perfil",perfil);
					request.getRequestDispatcher("services_log.jsp").forward(request, response);
				}
			} else {
				//usuario no existente
				request.setAttribute("error", "Contraseña invalida o usuario no existente");
				request.getRequestDispatcher("login.jsp").forward(request, response);
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