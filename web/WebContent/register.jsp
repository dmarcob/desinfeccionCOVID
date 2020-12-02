<!DOCTYPE html>
<html lang="en" class="wide wow-animation">
<head>
<title>Home</title>
<link rel="Stylesheet" href="css/validar_registro.css">
<meta name="format-detection" content="telephone=no">
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="utf-8">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="css/css.css?family=Open+Sans:400,700,400italic,600italic,900">
<link rel="stylesheet" href="css/style.css">
<!--[if lt IE 10]>
    <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="https://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
    <script src="js/html5shiv.min.js"></script>
		<![endif]-->
</head>
<body>
<div class="page">
  <header class="page-head">
    <div class="rd-navbar-wrap">
      <nav data-layout="rd-navbar-fixed" data-sm-layout="rd-navbar-fixed" data-md-device-layout="rd-navbar-fixed" data-md-layout="rd-navbar-static" data-lg-layout="rd-navbar-static" data-lg-device-layout="rd-navbar-static" data-stick-up-clone="false" data-md-stick-up-offset="199px" data-lg-stick-up-offset="199px" class="rd-navbar rd-navbar-corporate rd-navbar-dark">
        <div class="rd-navbar-inner">
          <div class="rd-navbar-middle-panel">
            <div class="rd-navbar-panel">
              <button data-rd-navbar-toggle=".rd-navbar-outer-panel" class="rd-navbar-toggle"><span></span></button>
              <a href="index.html" class="rd-navbar-brand">
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
                        <a href="#"><span>2381 Vía Hispanidad </span><br>
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
                <li class="active"><a href="index.html">Home</a> </li>
                <li><a href="services.html">Servicios</a></li>
                <li><a href="login.html">Iniciar sesion</a></li>
              </ul>
            </div>
          </div>
        </div>
      </nav>
    </div>
  </header>
  <main class="page-content">
    <section class="section-40 section-lg-64 bg-gray-lighter">
      <div class="breadcrumbs-wrap">
        <div class="shell text-center">
          <div class="wrap-sm-justify-horizontal">
            <div class="text-sm-left">
              <h1>Crear cuenta</h1>
            </div>
            <div class="offset-top-22 offset-sm-top-0 text-sm-right">
              <ul class="breadcrumbs-custom">
                <li><a href="index.html">Home</a></li>
                <li class="active">Registro</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="section-60 section-sm-top-75">
      <div class="shell">
        <div class="range range-sm-center">
          <div class="cell-sm-6 cell-md-5 cell-lg-4">
            <div class="responsive-tabs responsive-tabs-default responsive-tabs-horizontal responsive-tabs-silver-chalice">
              <ul class="resp-tabs-list text-center">
                <li>Registro</li>
              </ul>
              	<% if (request.getAttribute("error") != null) { %> 
				<div class="alert alert-danger" >
				<%= request.getAttribute("error") %>
				</div>
				<% } %>
              <div class="resp-tabs-container offset-top-40">
                <div class="animated fadeIn">
                  <div class="offset-top-25">
                    <form class="rd-mailform text-left" id=formulario-registro method="get" action="register">
                      <div class="form-group">
                        <label for="register-username" class="form-label-outside">Nickname</label>
                        <input 	id="register-nickname" type="text" name="nickname" class="form-control">
                      </div>
                      <div class="form-group">
                        <label for="register-username" class="form-label-outside">Nombre completo</label>
                        <input id="register-nombre" type="text" name="nombre" class="form-control">
                      </div>
                      <div class="form-group">
                        <label for="register-username" class="form-label-outside">Apellidos</label>
                        <input id="register-apellidos" type="text" name="apellidos" class="form-control">
                      </div>
                      <div class="form-group">
                        <label for="register-username" class="form-label-outside">Direccion oficina</label>
                        <input id="register-direccion" type="text" name="direccion" class="form-control">
                      </div>
                      <div class="form-group offset-top-18">
                        <label for="register-email" class="form-label-outside">E-Mail</label>
                        <input id="register-email" type="email" name="email" class="form-control">
                      </div>
                      <div class="form-group offset-top-18">
                        <label for="register-email" class="form-label-outside">Telefono</label>
                        <input id="register-telefono" type="tel" name="telefono" pattern="[0-9]{9}"  class="form-control">
                      </div>
                      <div class="form-group offset-top-18">
                        <label for="register-password" class="form-label-outside">Contraseña</label>
                        <input id="register-password" type="password" name="password" class="form-control">
                      </div>
                      <div class="form-group offset-top-18">
                        <label for="register-confirm-password" class="form-label-outside">Confirmar contraseña</label>
                        <input id="register-confirm-password" type="password" name="confirmPassword" class="form-control">
                      </div>
                      <div class="offset-top-18 text-center">
			 <!--  <a href="login.html" class="btn btn-info" type="submit" role="button">Registrar</a> -->
			  			<button type="submit" class="btn btn-primary">Registrar</button>
                      </div>
                      <div class="group group-middle offset-top-30 text-center">
                        <p> �Ya tienes cuenta? <a href="login.jsp">Inicia sesion aqui�</a></p>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
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
              <div class="brand-wrap"><a href="index.html" class="brand"><img src="images/logo-desinfecciones-megalo.png" alt="" width="250" height="40"/></a></div>
              <div class="offset-top-30 offset-sm-top-65">
                <ul class="list-inline list-inline-xs">
                  <li><a href="#" class="icon icon-xs icon-gray fa-facebook"></a></li>
                  <li><a href="#" class="icon icon-xs icon-gray fa-twitter"></a></li>
                  <li><a href="#" class="icon icon-xs icon-gray fa-pinterest-p"></a></li>
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
                <div class="cell-xs-5 cell-sm-6 cell-md-12 cell-lg-6 offset-top-18 text-xs-left">
                  <address class="contact-info contact-info-contrast">
                  <div class="unit unit-xs-horizontal unit-spacing-xs">
                    <div class="unit-left icon-adjust-vertical"><span class="icon icon-xs icon-white mdi mdi-phone"></span></div>
                    <div class="unit-body"><span><a href="callto:#">976 56 84 57</a></span><span><a href="callto:#">976 65 32 84</a></span></div>
                  </div>
                  <div class="unit unit-xs-horizontal unit-middle unit-spacing-xs offset-top-22 offset-xs-top-18">
                    <div class="unit-left icon-adjust-vertical"><span class="icon icon-xs icon-white mdi mdi-email-outline"></span></div>
                    <div class="unit-body"><a href="#a88b" class="link-primary-contrast"><span class="__cf_email__" data-cfemail="ed84838b82ad8988808281848386c3829f8a">megalo@gmail.com</span></a></div>
                  </div>
                  </address>
                </div>
                <div class="cell-xs-7 cell-sm-6 cell-md-12 cell-lg-6 offset-top-22 offset-xs-top-18 inset-lg-left-9 text-xs-left">
                  <address class="contact-info contact-info-contrast">
                  <div class="unit unit-xs-horizontal unit-spacing-xs">
                    <div class="unit-left icon-adjust-vertical"><span class="icon icon-xs icon-white mdi mdi-map-marker"></span></div>
                    <div class="unit-body"><a href="#" class="nowrap">2381 Vía Hispanidad<br>
                      ZGZ 50001. SPA</a></div>
                  </div>
                  <div class="unit unit-xs-horizontal unit-spacing-xs offset-top-22">
                    <div class="unit-left icon-adjust-vertical"><span class="icon icon-xs icon-white mdi fa-clock-o"></span></div>
                    <div class="unit-body"><span>Lun-Jue: 8:00am-19:00pm</span><span>Sab-Dom: 8:00am-12:00am</span></div>
                  </div>
                  </address>
                </div>
              </div>
            </div>
          </div>
          <div class="range offset-top-55 offset-sm-top-60 offset-lg-top-88">
            <div class="cell-xs-12">
              <p class="rights">&#169;&nbsp;<span id="copyright-year"></span>&nbsp;All Rights Reserved&nbsp;<a href="privacy.html" class="link-gray">Terms of Use and Privacy Policy</a> </p>
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
        <button title="Close (Esc)" class="pswp__button pswp__button--close"></button>
        <button title="Share" class="pswp__button pswp__button--share"></button>
        <button title="Toggle fullscreen" class="pswp__button pswp__button--fs"></button>
        <button title="Zoom in/out" class="pswp__button pswp__button--zoom"></button>
        <div class="pswp__preloader">
          <div class="pswp__preloader__icn">
            <div class="pswp__preloader__cut">
              <div class="pswp__preloader__donut"></div>
            </div>
          </div>
        </div>
      </div>
      <div class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
        <div class="pswp__share-tooltip"></div>
      </div>
      <button title="Previous (arrow left)" class="pswp__button pswp__button--arrow--left"></button>
      <button title="Next (arrow right)" class="pswp__button pswp__button--arrow--right"></button>
      <div class="pswp__caption">
        <div class="pswp__caption__cent"></div>
      </div>
    </div>
  </div>
</div>
<script src="js/core.min.js"></script>
<script src="js/script.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script src="js/validar_registro.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
</body>
<!-- End Google Tag Manager -->
</html>
