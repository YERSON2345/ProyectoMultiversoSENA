<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

      <!DOCTYPE html>
      <html lang="en">

      <head>
         <!-- basic -->
         <meta charset="utf-8">
         <meta http-equiv="X-UA-Compatible" content="IE=edge">
         <!-- mobile metas -->
         <meta name="viewport" content="width=device-width, initial-scale=1">
         <meta name="viewport" content="initial-scale=1, maximum-scale=1">
         <!-- site metas -->
         <title>Inicio|Multiverso</title>
         <meta name="keywords" content="">
         <meta name="description" content="">
         <meta name="author" content="">
         <!-- bootstrap css -->
         <link rel="stylesheet" href="assets/css/bootstrap.min.css">
         <!-- style css -->
         <link rel="stylesheet" href="assets/css/index-good/style.css">
         <!-- responsive-->
         <link rel="stylesheet" href="assets/css/index-good/responsive.css">
         <!-- awesome fontfamily -->
         <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
         <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
      </head>
      <!-- body -->

      <body class="main-layout">
         <!-- loader  -->
         <div class="loader_bg">
            <div class="loader"><img src="assets/img/load.gif" /></div>
         </div>
         <!-- end loader -->
         <!-- header -->
         <header>
            <div class="header">
               <div class="container-fluid">
                  <div class="row d_flex">
                     <div class=" col-md-2 col-sm-3 col logo_section">
                        <div class="full">
                           <div class="center-desk">
                              <div class="logo">
                                 <a href="index.html"><img class="multiverso" src="assets/img/multiversoo.jpeg"
                                       alt="#" /></a>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="col-md-8 col-sm-9">
                        <nav class="navigation navbar navbar-expand-md navbar-dark ">
                           <button class="navbar-toggler" type="button" data-toggle="collapse"
                              data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false"
                              aria-label="Toggle navigation">
                              <span class="navbar-toggler-icon"></span>
                           </button>
                           <div class="collapse navbar-collapse" id="navbarsExample04">
                              <ul class="navbar-nav mr-auto">
                                 <li class="nav-item active">
                                    <a class="nav-link" href="#">Inicio</a>
                                 </li>
                                 <li class="nav-item">
                                    <a class="nav-link" href="producto?accion=listar">Inventario</a>
                                 </li>
                                 <li class="nav-item">
                                    <a class="nav-link" href="ventas?condicion=dashboard">Dashboard</a>
                                 </li>
                                 <li class="nav-item">
                                    <a class="nav-link" href="usuario?condicion=formulario">Registrarse</a>
                                 </li>
                                 <li class="nav-item">
                                    <a class="nav-link" href="usuario?condicion=login">Login</a>
                                 </li>
                              </ul>
                           </div>
                        </nav>
                     </div>
                  </div>
               </div>
            </div>
         </header>
         <!-- end header -->
         <!-- start slider section -->
         <div id="top_section" class="banner_main">
            <div class="container">
               <div class="row">
                  <div class="col-md-12">
                     <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                           <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                           <li data-target="#myCarousel" data-slide-to="1"></li>
                           <li data-target="#myCarousel" data-slide-to="2"></li>
                           <li data-target="#myCarousel" data-slide-to="3"></li>
                        </ol>
                        <div class="carousel-inner">
                           <div class="carousel-item active">
                              <div class="container-fluid">
                                 <div class="carousel-caption relative">
                                    <div class="bluid">
                                       <br><br><br><br><br>
                                       <h1>Multiverso<br> </h1>
                                       <a class="read_more" href="ventas?condicion=dashboard">Dashboard</a>
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <div class="carousel-item">
                              <div class="container-fluid">
                                 <div class="carousel-caption relative">
                                    <div class="bluid">
                                       <br><br><br><br><br>
                                       <h1>Multiverso<br> </h1>
                                       <a class="read_more" href="producto?accion=listar">Inventario</a>
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <div class="carousel-item">
                              <div class="container-fluid">
                                 <div class="carousel-caption relative">
                                    <div class="bluid">
                                       <br><br><br><br><br>
                                       <h1>Multiverso<br> </h1>
                                       <a class="read_more" href="ventas?condicion=dashboard">Dashboard</a>
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <div class="carousel-item">
                              <div class="container-fluid">
                                 <div class="carousel-caption relative">
                                    <div class="bluid">
                                       <br><br><br><br><br>
                                       <h1>Multiverso <br> </h1>
                                       <a class="read_more" href="producto?accion=listar">Inventario</a>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
                           <i class="fa fa-angle-left" aria-hidden="true"></i>
                           <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
                           <i class="fa fa-angle-right" aria-hidden="true"></i>
                           <span class="sr-only">Next</span>
                        </a>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <!-- end slider section -->
         <!-- footer -->
         <footer>
            <div class="footer">
               <div class="container">
                  <div class="row">
                     <div class="col-md-3">
                        <a class="logo_footer" href="index.html"><img src="assets/img/multiversoo.jpeg" alt="#" /></a>
                     </div>
                     <div class="col-md-3 col-sm-6">
                        <div class="Informa helpful">
                           <h3>Enlaces utiles</h3>
                           <ul>
                              <li><a href="#">Inicio</a></li>
                              <li><a href="producto?condicion=consultarProducto">Inventario</a></li>
                              <li><a href="ventas?condicion=dashboard">Dashboard</a></li>
                              <li><a href="usuario?condicion=formulario">Registrarse</a></li>
                              <li><a href="usuario?condicion=form">Login</a></li>
                           </ul>
                        </div>
                     </div>
                     <div class="col-md-3 col-sm-6">
                        <div class="Informa">
                           <h3>Compañia</h3>
                           <ul>
                              <li>Bienvenido a Multiverso
                              </li>
                              <li>una microempresa la cual
                              </li>
                              <li>se basa en llevar inventario,
                              </li>
                              <li>ventas,etc...
                              </li>
                              <li>Al toque mi rey
                              </li>
                           </ul>
                        </div>
                     </div>
                     <div class="col-md-3 col-sm-6">
                        <div class="Informa conta">
                           <h3>Contactanos</h3>
                           <ul>
                              <li> <a href="Javascript:void(0)"> <i class="fa fa-map-marker" aria-hidden="true"></i>
                                    Pilos, Suba, Rincón
                                 </a>
                              </li>
                              <li> <a href="Javascript:void(0)"><i class="fa fa-phone" aria-hidden="true"></i> Call +57
                                    3123155542
                                 </a>
                              </li>
                              <li> <a href="Javascript:void(0)"> <i class="fa fa-envelope" aria-hidden="true"></i>
                                    multiSupport@gmail.com
                                 </a>
                              </li>
                           </ul>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="copyright text_align_left">
                  <div class="container">
                     <div class="row d_flex">
                        <div class="col-md-6">
                           <p>© 2020 All Rights Reserved. <a href="https://html.design/"> Multiverso</a></p>
                        </div>
                        <div class="col-md-6">
                           <ul class="social_icon text_align_center">
                              <li> <a href="Javascript:void(0)"><i class="fa fa-facebook-f"></i></a></li>
                              <li> <a href="Javascript:void(0)"><i class="fa fa-twitter"></i></a></li>
                              <li> <a href="Javascript:void(0)"><i class="fa fa-linkedin-square"
                                       aria-hidden="true"></i></a></li>
                              <li> <a href="Javascript:void(0)"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                              </li>
                              <li> <a href="Javascript:void(0)"><i class="fa fa-youtube-play"
                                       aria-hidden="true"></i></a></li>
                           </ul>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </footer>
         <!-- end footer -->
         <!-- Javascript files-->
         <script src="assets/js/JS-index/jquery.min.js"></script>
         <script src="assets/js/JS-index/bootstrap.bundle.min.js"></script>
         <script src="assets/js/jquery-3.0.0.min.js"></script>
         <script src="assets/js/JS-index/custom.js"></script>
      </body>

      </html>