package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Perfil_usuarioVO;
import model.SolicitudVO;
import model.SolicitudFacade;
import model.UserFacade;
import model.UsuarioVO;

/**
 * Servlet implementation class Logged
 */
@WebServlet("/listar_historial_admin")
public class Listar_historial_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listar_historial_admin() {
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
				//Se fija el número de solicitudes mostradas por página
				int solicitudesPorPagina = 3;
				
				//Se actualiza el estado del historial
				String estado = "pendiente";
				
				System.out.println("ESTADO ->" + request.getParameter("estado"));
				if (request.getParameter("estado") != null) {
					estado = (String)request.getParameter("estado");
					//System.out.println("NUEVO ESTADO ->" + estado);
				}
				request.setAttribute("estado",estado);
				
				
				request.setAttribute("solicitudesPorPagina", solicitudesPorPagina);

				SolicitudFacade dao = new SolicitudFacade();
				UsuarioVO user = (UsuarioVO) request.getSession().getAttribute("user");
				//Se obtiene el número de solicitudes totales del usuario logeado
				int numSolicitudes = dao.numSolicitudesEstado(estado);
				System.out.println("NUM SOLICITUDES ->" + numSolicitudes);
				//Se obtiene el número de páginas totales a mostrar
				int numPaginas = (int)Math.ceil(numSolicitudes/(double)solicitudesPorPagina);
				request.setAttribute("numPaginas", numPaginas);
				
				int paginaActual = 1;
				if (request.getParameter("paginaPinchada") != null) {
					//Se actualiza la página que se debe mostrar
					paginaActual = Integer.parseInt(request.getParameter("paginaPinchada"));
				}
				//Se actualiza la página actual que debemos mostrar
				request.removeAttribute("paginaActual");
				request.setAttribute("paginaActual", paginaActual);
				//Obtenemos 3 solicitudes del usuario logeado, ordenadas de la más reciente a la más antigua.
				//El offset de las tres solicitudes mostradas corresponde al valor (paginaActual - 1) * solicitudesPorPagina
				
				
				List<SolicitudVO> l  = dao.historialEstado(estado, paginaActual, solicitudesPorPagina);
				System.out.println("LISTA TAMAÑO ->" + l.size());
				
				
				request.removeAttribute("lista_solicitudes");
				request.setAttribute("lista_solicitudes", l);

				System.out.println("paginaActualllll ->" + request.getParameter("paginaPinchada"));
				request.getRequestDispatcher("historialAdmin.jsp").forward(request, response);

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