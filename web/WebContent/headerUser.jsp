<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="model.UsuarioVO"%>
  <header class="page-head">
    <div class="rd-navbar-wrap">
      <nav data-layout="rd-navbar-fixed" data-sm-layout="rd-navbar-fixed" data-md-device-layout="rd-navbar-fixed" data-md-layout="rd-navbar-static" data-lg-layout="rd-navbar-static" data-lg-device-layout="rd-navbar-static" data-stick-up-clone="false" data-md-stick-up-offset="199px" data-lg-stick-up-offset="199px" class="rd-navbar rd-navbar-corporate rd-navbar-dark">
        <div class="rd-navbar-inner">
          <div class="rd-navbar-middle-panel">
            <div class="rd-navbar-panel">
              <button data-rd-navbar-toggle=".rd-navbar-outer-panel" class="rd-navbar-toggle"><span></span></button>
              <a href="services_log.jsp" class="rd-navbar-brand">
              <div class="rd-navbar-fixed--hidden"><img src="images/logo-desinfecciones-megalo.png" alt="" width="250" height="40"/> </div>
              <div class="rd-navbar-fixed--visible"><img src="images/logo-desinfecciones-megalo.png" alt="" width="250" height="40"/> </div>
              </a> </div>
            <div class="rd-navbar-aside">
              <div data-rd-navbar-toggle=".rd-navbar-aside" class="rd-navbar-aside-toggle"><span></span></div>
              <div class="rd-navbar-aside-content">
                <ul class="block-wrap-list">
                  <li class="block-wrap">
                    <div class="unit unit-sm-horizontal unit-align-center unit-middle unit-spacing-xxs">
                      <div class="unit-left"><span class="icon icon-circle-sm icon-sm-variant-1 icon-venice-blue-filled icon-white mdi mdi-map-marker"></span></div>
                      <div class="unit-body">
                        <address class="contact-info">
                        <a href="#"><span>2381 VÃ­a Hispanidad </span><br>
                        <span>ZGZ 50001. SPA</span></a>
                        </address>
                      </div>
                    </div>
                  </li>
                  <li class="block-wrap">
                    <div class="unit unit-sm-horizontal unit-align-center unit-middle unit-spacing-xxs">
                      <div class="unit-left"><span class="icon icon-circle-sm icon-sm-variant-1 icon-venice-blue-filled icon-white fa-clock-o"></span></div>
                      <div class="unit-body">
                        <address class="contact-info">
                        <span>Lun-Jue: 8:00am-19:00pm</span><span>Sab-Dom: 8:00am-12:00am</span>
                        </address>
                      </div>
                    </div>
                  </li>
                  <li class="block-wrap">
                    <div class="unit unit-sm-horizontal unit-align-center unit-middle unit-spacing-xxs">
                      <div class="unit-left"><span class="icon icon-circle-sm icon-sm-variant-1 icon-venice-blue-filled icon-white mdi mdi-phone"></span></div>
                      <div class="unit-body">
                        <address class="contact-info">
                        <span><a href="callto:#">976 56 84 57</a></span><span><a href="callto:#">976 65 32 84</a></span>
                        </address>
                      </div>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="rd-navbar-outer-panel">
            <div class="rd-navbar-nav-wrap">
              <ul class="rd-navbar-nav">
                <li class="active"><a href="services_log.jsp">Home</a> </li>
                <li><a href="services_log.jsp">Servicios</a></li>
		<li class="nav-item dropdown no-arrow">
                  <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                   <span class="mr-2 d-none d-lg-inline text-gray-600 small">
					<%= ((UsuarioVO)request.getSession().getAttribute("user")).getnickname()%>
					</span>
                   <span class="icon icon-sm-variant-2 icon-primary fa-user"></span>
                 </a>
              <!-- Dropdown - User Information -->
               <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="perfil">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  Cuenta
                  </a>
                  <a class="dropdown-item" href="listar_historial_usuario">
                  <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                  Historial solicitudes
                     </a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="services_log.jsp">
                  <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                  Logout
                  </a>
                </div>
              </li>
              </ul>
            </div>
          </div>
        </div>
      </nav>
    </div>
  </header>
</body>
</html>