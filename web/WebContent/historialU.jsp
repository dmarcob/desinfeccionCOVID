<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="wide wow-animation">
<head>
<title>Home</title>
<meta name="format-detection" content="telephone=no">
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="utf-8">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css"
	href="css/css.css?family=Open+Sans:400,700,400italic,600italic,900">
<link rel="stylesheet" href="css/style.css">
<!--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="https://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]-->
</head>
<body>
	<%@ page import="java.util.List"%>
	<%@ page import="model.SolicitudVO"%>
	<div class="page">
		<%@ include file='headerUser.jsp'%>
		<main>
			<section class="section-40 section-lg-64 bg-gray-lighter">
				<div class="breadcrumbs-wrap">
					<div class="shell text-center">
						<div class="wrap-sm-justify-horizontal">
							<div class="text-sm-left">
								<h1>Historial de solicitudes</h1>
							</div>
							<div class="offset-top-22 offset-sm-top-0 text-sm-right">
								<ul class="breadcrumbs-custom">
									<li><a href="index.html">Home</a></li>
									<li class="active">Historial de solicitudes</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</section>
			<section class="section-40 section-lg-64 bg-gray">
				<div class="shell">

					<%
						int solicitudesPorPagina = (int) request.getAttribute("solicitudesPorPagina");
					List<SolicitudVO> lista = (List<SolicitudVO>) request.getAttribute("lista_solicitudes");
					if (lista != null) {
						for (SolicitudVO solicitud : lista) {
					%>
					<div class="range range-sm-center range-md-left offset-top-30">
						<div class="cell-sm-9 cell-md-12 bg-gray-lighter">
							<div class="p-3 row-md-2">
								<div class="row offtop-sm-12 bg-gray-lighter">
									<br>
									<div class="col-sm-10">
										<h4>
											<%
												out.print(solicitud.getDireccion());
											%>
										</h4>
									</div>
									<div class="col-sm-2">
										<p>
											Estado:
											<%out.print(solicitud.getEstado());%>
										</p>
									</div>
								</div>
							</div>
							<br>
							<div class="row-sm-12">
								<p style="color: black";>
									Fecha:
									<%out.print(solicitud.getFecha());%>
								</p>
								<p style="color: black";>
									Hora:
									<%out.print(solicitud.getHora());%>
								</p>
								<p style="color: black";>
									Comentario:
									<%out.print(solicitud.getMensaje());%>
								</p>
								<br>
							</div>
						</div>
					</div>
					<%
						}
					%>
					<%
						}
					%>

					<div class="offset-top-35 offset-sm-top-60">
						<ul class="pagination">
							<%
								int numPaginas = (int) request.getAttribute("numPaginas");
							int paginaActual = (int) request.getAttribute("paginaActual");
							for (int i = 1; i <= numPaginas; i++) {
								if (i == paginaActual) {
							%>
							<li class="active">
								<%
									} else {
								%>
							
							<li>
								<%
									}
								%> <a
								href=<%out.print("listar_historial_usuario?paginaPinchada=" + i);%>>
									<%
										out.print(i);
									%>
							</a>
							</li>
							<%
								}
							%>
						
					</div>
				</div>
			</section>
		</main>





		<footer class="page-foot bg-gray-dark">
			<div class="shell text-center text-sm-left">
				<div class="range range-sm-center">
					<div class="cell-sm-10 cell-md-12">
						<div class="range range-md-justify">
							<div class="cell-sm-6 cell-md-3 wrap-lg-justify-vertical">
								<div class="brand-wrap">
									<a href="index.html" class="brand"><img
										src="images/logo-desinfecciones-megalo.png" alt="" width="250"
										height="40" /></a>
								</div>
								<div class="offset-top-30 offset-sm-top-65">
									<ul class="list-inline list-inline-xs">
										<li><a href="#"
											class="icon icon-xs icon-gray fa-facebook"></a></li>
										<li><a href="#" class="icon icon-xs icon-gray fa-twitter"></a></li>
										<li><a href="#"
											class="icon icon-xs icon-gray fa-pinterest-p"></a></li>
										<li><a href="#" class="icon icon-xs icon-gray fa-vimeo"></a></li>
										<li><a href="#" class="icon icon-xs icon-gray fa-google"></a></li>
										<li><a href="#" class="icon icon-xs icon-gray fa-rss"></a></li>
									</ul>
								</div>
							</div>
							<div class="cell-md-4 cell-lg-5 offset-top-55 offset-md-top-0">
								<div class="range">
									<div class="cell-xs-12">
										<h5 class="h5-variant-1">Contáctanos</h5>
										<hr>
									</div>
									<div
										class="cell-xs-5 cell-sm-6 cell-md-12 cell-lg-6 offset-top-18 text-xs-left">
										<address class="contact-info contact-info-contrast">
											<div class="unit unit-xs-horizontal unit-spacing-xs">
												<div class="unit-left icon-adjust-vertical">
													<span class="icon icon-xs icon-white mdi mdi-phone"></span>
												</div>
												<div class="unit-body">
													<span><a href="callto:#">976 56 84 57</a></span><span><a
														href="callto:#">976 65 32 84</a></span>
												</div>
											</div>
											<div
												class="unit unit-xs-horizontal unit-middle unit-spacing-xs offset-top-22 offset-xs-top-18">
												<div class="unit-left icon-adjust-vertical">
													<span class="icon icon-xs icon-white mdi mdi-email-outline"></span>
												</div>
												<div class="unit-body">
													<a href="#a88b" class="link-primary-contrast"><span
														class="__cf_email__"
														data-cfemail="ed84838b82ad8988808281848386c3829f8a">megalo@gmail.com</span></a>
												</div>
											</div>
										</address>
									</div>
									<div
										class="cell-xs-7 cell-sm-6 cell-md-12 cell-lg-6 offset-top-22 offset-xs-top-18 inset-lg-left-9 text-xs-left">
										<address class="contact-info contact-info-contrast">
											<div class="unit unit-xs-horizontal unit-spacing-xs">
												<div class="unit-left icon-adjust-vertical">
													<span class="icon icon-xs icon-white mdi mdi-map-marker"></span>
												</div>
												<div class="unit-body">
													<a href="#" class="nowrap">2381 Vía Hispanidad<br>
														ZGZ 50001. SPA
													</a>
												</div>
											</div>
											<div
												class="unit unit-xs-horizontal unit-spacing-xs offset-top-22">
												<div class="unit-left icon-adjust-vertical">
													<span class="icon icon-xs icon-white mdi fa-clock-o"></span>
												</div>
												<div class="unit-body">
													<span>Lun-Jue: 8:00am-19:00pm</span><span>Sab-Dom:
														8:00am-12:00am</span>
												</div>
											</div>
										</address>
									</div>
								</div>
							</div>
						</div>
						<div class="range offset-top-55 offset-sm-top-60 offset-lg-top-88">
							<div class="cell-xs-12">
								<p class="rights">
									&#169;&nbsp;<span id="copyright-year"></span>&nbsp;All Rights
									Reserved&nbsp;<a href="privacy.html" class="link-gray">Terms
										of Use and Privacy Policy</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</div>
	<div id="form-output-global" class="snackbars"></div>
	<div tabindex="-1" role="dialog" aria-hidden="true" class="pswp">
		<div class="pswp__bg"></div>
		<div class="pswp__scroll-wrap">
			<div class="pswp__container">
				<div class="pswp__item"></div>
				<div class="pswp__item"></div>
				<div class="pswp__item"></div>
			</div>
			<div class="pswp__ui pswp__ui--hidden">
				<div class="pswp__top-bar">
					<div class="pswp__counter"></div>
					<button title="Close (Esc)"
						class="pswp__button pswp__button--close"></button>
					<button title="Share" class="pswp__button pswp__button--share"></button>
					<button title="Toggle fullscreen"
						class="pswp__button pswp__button--fs"></button>
					<button title="Zoom in/out" class="pswp__button pswp__button--zoom"></button>
					<div class="pswp__preloader">
						<div class="pswp__preloader__icn">
							<div class="pswp__preloader__cut">
								<div class="pswp__preloader__donut"></div>
							</div>
						</div>
					</div>
				</div>
				<div
					class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
					<div class="pswp__share-tooltip"></div>
				</div>
				<button title="Previous (arrow left)"
					class="pswp__button pswp__button--arrow--left"></button>
				<button title="Next (arrow right)"
					class="pswp__button pswp__button--arrow--right"></button>
				<div class="pswp__caption">
					<div class="pswp__caption__cent"></div>
				</div>
			</div>
		</div>
	</div>
	<script src="js/core.min.js"></script>
	<script src="js/script.js"></script>
</body>
</html>
