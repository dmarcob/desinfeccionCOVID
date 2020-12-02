package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import model.Perfil_usuarioVO;
import model.SolicitudVO;
import model.SolicitudFacade;
import model.UserFacade;
import model.UsuarioVO;

/**
 * Servlet implementation class Logged
 */
@WebServlet("/update_estado")
public class update_estado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_estado() {
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
				SolicitudFacade dao = new SolicitudFacade();
				UsuarioVO user = (UsuarioVO) request.getSession().getAttribute("user");
				String estado = request.getParameter("estado");
				String accion = request.getParameter("accion");
				int idSolicitud = Integer.parseInt(request.getParameter("idSolicitud"));
				if (accion.equals("aceptar")) {
					System.out.println("ACEPTADAAAA!!!!!");
					dao.modificarSolicitud("aceptada", idSolicitud);
					String destinatario = dao.emailSolicitud(idSolicitud);
					enviarEmail(destinatario);
					
				} else if (accion.equals("denegar")) {
					dao.modificarSolicitud("denegada", idSolicitud);
				} else {
					//caso finalizar
					dao.modificarSolicitud("finalizada", idSolicitud);
					System.out.println("FINALIZADA!!!!!");
				}
				
				
				
				request.getRequestDispatcher("listar_historial_admin?estado=" + estado).forward(request, response);

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
	
	protected void enviarEmail (String destinatario) {
		//TODO: Implementar este método como mejora :)
	}

}