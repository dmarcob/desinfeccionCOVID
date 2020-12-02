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
import utils.SendEmail;

/**
 * 
 * @author megalobox team
 * Este servlet se invoca cuando el administrador acepta, deniega o finaliza una solicitud
 *
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
	 * Si el administrador no está logeado es redirigido a "login.jsp"
	 * En caso contrario, actualiza el estado de la solicitud seleccionada.
	 * Si el administrador ha aceptado o denegado la solicitud, se le envía un correo
	 * al usuario que ha la ha generado indicándole la decisión del administrador.
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
				String direccion = request.getParameter("direccion");
				int idSolicitud = Integer.parseInt(request.getParameter("idSolicitud"));
				String destinatario = dao.emailSolicitud(idSolicitud);
				SendEmail email = new SendEmail();
				if (accion.equals("aceptar")) {
					dao.modificarSolicitud("aceptada", idSolicitud);
					email.sendEmail(destinatario,"[Desinfecciones Megalo] Petición de desinfección."
							,"Su petición de desinfección a la dirección: " +  direccion + " ha sido aceptada.");
					
				} else if (accion.equals("denegar")) {
					dao.modificarSolicitud("denegada", idSolicitud);
					email.sendEmail(destinatario,"[Desinfecciones Megalo] Petición de desinfección."
							,"Su petición de desinfección a la dirección: " +  direccion + " ha sido denegada.");
				} else {
					//caso finalizar
					dao.modificarSolicitud("finalizada", idSolicitud);
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
}