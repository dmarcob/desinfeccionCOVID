package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Perfil_usuarioVO;
import model.SolicitudFacade;
import model.SolicitudVO;
import model.UserFacade;
import model.UsuarioVO;

/**
 * 
 * @author megalobox team
 * Este servlet se invoca cuando el usuario quiere enviar una solicitud.
 *
 */
@WebServlet("/enviar_solicitud")
public class Enviar_solicitud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enviar_solicitud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Si el usuario no está logeado es redirigido a "login.jsp"
	 * Si el usuario está logeado recoge los datos enviados por el usuario, añade la solicitud a la
	 * base de datos mediante SolicitudFacade y redirige al usuario a "services_log.jsp"
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		if (request.getSession().getAttribute("user") == null) { // No hay usuario logado
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			SolicitudFacade dao = new SolicitudFacade();
			UsuarioVO user = (UsuarioVO) request.getSession().getAttribute("user");
			SolicitudVO solicitud = new SolicitudVO(request.getParameter("direccion"), request.getParameter("fecha"), 
					request.getParameter("hora"),request.getParameter("mensaje"),
					"pendiente", request.getParameter("servicio"), user.getnickname());
			
		     dao.addSolicitud(solicitud);
			
			request.getRequestDispatcher("services_log.jsp").forward(request, response);
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