<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Deerhost Template">
    <meta name="keywords" content="Deerhost, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>DEERHOST | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,600,700,800,900&display=swap"
        rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="assets/css/flaticon.css" type="text/css">
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="assets/css/index-principio/styles.css" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Offcanvas Menu Begin -->
    <div class="offcanvas__menu__overlay"></div>
    <div class="offcanvas__menu__wrapper">
        <div class="canvas__close">
            <span class="fa fa-times-circle-o"></span>
        </div>
        <div class="offcanvas__logo">
            <a href="index.jsp"><img src="assets/img/logo.png" alt=""></a>
        </div>
        <nav class="offcanvas__menu mobile-menu">
            <ul>
                <li class="active"><a href="./index.html">Home</a></li>
                <li><a href="./about.html">About</a></li>
                <li><a href="./hosting.html">Hosting</a></li>
                <li><a href="#">Pages</a>
                    <ul class="dropdown">
                        <li><a href="./pricing.html">Pricing</a></li>
                        <li><a href="./blog-details.html">Blog Details</a></li>
                        <li><a href="./404.html">404</a></li>
                    </ul>
                </li>
                <li><a href="./blog.html">News</a></li>
                <li><a href="./contact.html">Contact</a></li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="offcanvas__auth">
            <ul>
                <li><a href="#"><span class="fa fa-user"></span> Login / Register</a></li>
            </ul>
        </div>
        <div class="offcanvas__info">
            <ul>
                <li><span class="icon_phone"></span> +1 123-456-7890</li>
                <li><span class="fa fa-envelope"></span> Support@gmail.com</li>
            </ul>
        </div>
    </div>
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
    <header class="header-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-3">
                    <div class="header__logo">
                        <a href="index.jsp"><h2 class="texto_m">MULTIVERSO</h2></a>
                    </div>
                </div>
            </div>
            <div class="canvas__open">
                <span class="fa fa-bars"></span>
            </div>
        </div>
    </header>
    <!-- Header End -->

    <!-- Hero Section Begin -->
    <section class="hero-section">
        <div class="hero__slider owl-carousel">
            <div class="hero__item set-bg" src="assets/img/hero/hero-1.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="hero__text">
                                <h5>Que tengas una buena experiencia</h5>
                                <h2>Bienvenido a Multiverso</h2>
                                <a href="ventas?condicion=dashboard" class="primary-btn">Acceder al dashboard</a>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="hero__img">
                                <img src="multiversoo.jpeg">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="hero__item set-bg" src="assets/img/hero/hero-1.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="hero__text">
                                <h5>Aqu?? podras registrar en el inventario</h5>
                                <h2>Bienvenido al inventario</h2>
                                <a href="ventas?condicion=dashboard" class="primary-btn">Inventario</a>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="hero__img">
                                <img src="../webapp/assets/img/inventario.jpg" alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Choose Plan Section Begin -->
    <section class="choose-plan-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="plan__text">
                        <ul>
                            
                            <li></li>
                            <li></li>
                            <li></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Choose Plan Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer-section">
        <div class="footer__top">

        </div>
        <div class="footer__text set-bg" src="assets/img/footer-bg.png">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-6 col-sm-12">
                        <div class="footer__text-about">
                            <div class="footer__logo">
                                <a href="index.jsp"><h2 class="texto_m">MULTIVERSO</h2></a>
                            </div>
                            <p>Multiverso es una empresa que se dedica a vender productos por mercado libre, este sistema de informaci??n facilita los procesos de inventario al momento de registrar ventas y compras  </p>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-6 col-sm-6">
                        <div class="footer__text-widget">
                                <h5>Compa??ia</h5>
                            <ul>
                                <li><a href="#">Sobre</a></li>
                                <li><a href="#">Multimedia</a></li>
                                <li><a href="#">Productos y compras</a></li>
                                <li><a href="#">Ventas</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-12">
                        <div class="footer__text-widget">
                            <h5>CONTACTANOS</h5>
                            <ul class="footer__widget-info">
                                <li><span class="fa fa-map-marker"></span> 500 Pilos, Suba, Rinc??n<br />
                                    ZZ-96110 Colombia</li>
                                <li><span class="fa fa-mobile"></span> 125-711-811 | 125-668-886</li>
                                <li><span class="fa fa-headphones"></span> multiversoSupport.hosting@gmail.com</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="footer__text-copyright">
                    <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> Derechos Reservados | Todos los derechos de autor <i class="fa fa-heart" aria-hidden="true"></i> para <a href="https://colorlib.com" target="_blank">Multiverso.</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="assets/js/jquery-3.3.1.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery.slicknav.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>
    <script src="assets/js/main.js"></script>
</body>

</html>