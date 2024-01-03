<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>NORDIC | SD118</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="../../images/create_logo_with_content_Nordic_Shoes_and_back.jpg" type="image/jpeg">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">

    <link rel="stylesheet" type="text/css" href="../../css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../css/animate.css">

    <link rel="stylesheet" type="text/css" href="../../css/owl.carousel.min.css">
    <link rel="stylesheet" type="text/css" href="../../css/owl.theme.default.min.css">
    <link rel="stylesheet" type="text/css" href="../../css/magnific-popup.css">

    <link rel="stylesheet" type="text/css" href="../../css/aos.css">

    <link rel="stylesheet" type="text/css" href="../../css/ionicons.min.css">

    <link rel="stylesheet" type="text/css" href="../../css/bootstrap-datepicker.css">
    <link rel="stylesheet" type="text/css" href="../../css/jquery.timepicker.css">


    <link rel="stylesheet" type="text/css" href="../../css/flaticon.css">
    <link rel="stylesheet" type="text/css" href="../../css/icomoon.css">

    <link rel="stylesheet" type="text/css" href="../../css/style.css"/>

</head>
<body class="goto-here">
<div class="py-1 bg-black">
    <div class="container">
        <div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
            <div class="col-lg-12 d-block">
                <div class="row d-flex">
                    <div class="col-md pr-4 d-flex topper align-items-center">
                        <div class="icon mr-2 d-flex justify-content-center align-items-center"><span
                                class="icon-phone2"></span></div>
                        <span class="text">+ 1235 2355 98</span>
                    </div>
                    <div class="col-md pr-4 d-flex topper align-items-center">
                        <div class="icon mr-2 d-flex justify-content-center align-items-center"><span
                                class="icon-paper-plane"></span></div>
                        <span class="text">youremail@email.com</span>
                    </div>
                    <div class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right">
                        <span class="text">3-5 Business days delivery &amp; Free Returns</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="/home">Nordic Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav"
                aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a href="/home" class="nav-link">Home</a></li>
                <li class="nav-item"><a href="/shop" class="nav-link">Shop</a></li>

                <li class="nav-item"><a href="/about" class="nav-link">About</a></li>
                <li class="nav-item"><a href="/blog" class="nav-link">Blog</a></li>
                <li class="nav-item"><a href="/contact" class="nav-link">Contact</a></li>
                <li class="nav-item cta cta-colored"><a href="/cart" class="nav-link"><span
                        class="icon-shopping_cart"></span></a></li>

            </ul>
        </div>
    </div>
</nav>
<!-- END nav -->

<div class="hero-wrap hero-bread" style="background-image: url('images/bg_6.jpg');">
    <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
                <p class="breadcrumbs"><span class="mr-2"><a href="/home">Home</a></span> <span>Cart</span></p>
                <h1 class="mb-0 bread">My Wishlist</h1>
            </div>
        </div>
    </div>
</div>

<section class="ftco-section ftco-cart">
    <div class="container">
        <div class="row">
            <div class="col-md-12 ftco-animate">
                <div class="cart-list">
                    <table class="table">
                        <thead class="thead-primary">
                        <tr class="text-center">
                            <th></th>
                            <th>Image</th>
                            <th>Product</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listGioHangChiTiet}" var="cartItem">
                            <tr class="text-center">
                                <td class="product-remove">
                                    <a href="/delete/${cartItem.id}">
                                        <span class="ion-ios-close"></span>
                                    </a>
                                </td>
                                <td>
                                    <div class="img-box">
                                        <img style="width: 250px; height: 200px;"
                                             src="${cartItem.chiTietSanPham.photo}">
                                    </div>
                                </td>
                                <td>
                                    <p>${cartItem.chiTietSanPham.sanPham.tenSanPham}</p>
                                </td>
                                <td class="price">
                                <span>
                                    <fmt:formatNumber value="${cartItem.donGia}" type="currency"
                                                      currencyCode="VND" pattern="#,##0"></fmt:formatNumber>đ
                                </span>
                                </td>
                                <td class="quantity">
                                    <div class="input-group mb-3">
                                        <input type="text" name="quantity"
                                               class="quantity form-control input-number"
                                               value="${cartItem.soLuong}" min="1" max="100">
                                    </div>
                                </td>
                                <td class="total">
                                <span>
    <fmt:formatNumber value="${cartItem.soLuong * cartItem.donGia}" type="currency" currencyCode="VND"
                      pattern="#,##0"></fmt:formatNumber>₫
</span>
                                </td>
                            </tr>
                            <!-- END TR-->
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div class="row justify-content-start">
            <div class="col col-lg-5 col-md-6 mt-5 cart-wrap ftco-animate">
                <form action="/pay/vnpayajax" method="post" class="billing-form">
                    <div class="cart-total mb-3">
                        <h3>Cart Totals</h3>
                        <p class="d-flex">
                            <span>Tổng Tiền:</span>
                            <c:set var="totalAmount" value="0"/>
                            <c:forEach items="${listGioHangChiTiet}" var="c">
                                <c:set var="subtotal" value="${c.soLuong * c.donGia}"/>
                                <c:set var="totalAmount" value="${totalAmount + subtotal}"/>
                            </c:forEach>
                            <fmt:formatNumber var="formattedTotalAmount" value="${totalAmount}" type="currency"
                                              currencyCode="VND" pattern="#,##0"/>
                            <span style="color: red">${formattedTotalAmount} đ</span>
                        </p>
                        <hr>
                    </div>
                    <button type="submit" class="btn btn-primary">Thanh toán</button>
                </form>
            </div>
        </div>

    </div>
</section>


<footer class="ftco-footer ftco-section">
    <div class="container">
        <div class="row">
            <div class="mouse">
                <a href="#" class="mouse-icon">
                    <div class="mouse-wheel"><span class="ion-ios-arrow-up"></span></div>
                </a>
            </div>
        </div>
        <div class="row mb-5">
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Minishop</h2>
                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia.</p>
                    <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                        <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                        <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                        <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4 ml-md-5">
                    <h2 class="ftco-heading-2">Menu</h2>
                    <ul class="list-unstyled">
                        <li><a href="#" class="py-2 d-block">Shop</a></li>
                        <li><a href="#" class="py-2 d-block">About</a></li>
                        <li><a href="#" class="py-2 d-block">Journal</a></li>
                        <li><a href="#" class="py-2 d-block">Contact Us</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-4">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Help</h2>
                    <div class="d-flex">
                        <ul class="list-unstyled mr-l-5 pr-l-3 mr-4">
                            <li><a href="#" class="py-2 d-block">Shipping Information</a></li>
                            <li><a href="#" class="py-2 d-block">Returns &amp; Exchange</a></li>
                            <li><a href="#" class="py-2 d-block">Terms &amp; Conditions</a></li>
                            <li><a href="#" class="py-2 d-block">Privacy Policy</a></li>
                        </ul>
                        <ul class="list-unstyled">
                            <li><a href="#" class="py-2 d-block">FAQs</a></li>
                            <li><a href="#" class="py-2 d-block">Contact</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md">
                <div class="ftco-footer-widget mb-4">
                    <h2 class="ftco-heading-2">Have a Questions?</h2>
                    <div class="block-23 mb-3">
                        <ul>
                            <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span>
                            </li>
                            <li><a href="#"><span class="icon icon-phone"></span><span
                                    class="text">+2 392 3929 210</span></a></li>
                            <li><a href="#"><span class="icon icon-envelope"></span><span class="text">info@yourdomain.com</span></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-center">

                <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    Copyright &copy;<script>document.write(new Date().getFullYear());</script>
                    All rights reserved | This template is made with <i class="icon-heart color-danger"
                                                                        aria-hidden="true"></i> by <a
                            href="https://colorlib.com" target="_blank">Colorlib</a>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                </p>
            </div>
        </div>
    </div>
</footer>


<!-- loader -->
<div id="ftco-loader" class="show fullscreen">
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                stroke="#F96D00"/>
    </svg>
</div>


<script src="../../js/jquery.min.js"></script>
<script src="../../js/jquery-migrate-3.0.1.min.js"></script>
<script src="../../js/popper.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/jquery.easing.1.3.js"></script>
<script src="../../js/jquery.waypoints.min.js"></script>
<script src="../../js/jquery.stellar.min.js"></script>
<script src="../../js/owl.carousel.min.js"></script>
<script src="../../js/jquery.magnific-popup.min.js"></script>
<script src="../../js/aos.js"></script>
<script src="../../js/jquery.animateNumber.min.js"></script>
<script src="../../js/bootstrap-datepicker.js"></script>
<script src="../../js/scrollax.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
<script src="../../js/google-map.js"></script>
<script src="../../js/main.js"></script>

<script>
    $(document).ready(function () {

        var quantitiy = 0;
        $('.quantity-right-plus').click(function (e) {
            e.preventDefault();
            // Get the field name
            var quantity = parseInt($('#quantity').val());

            $('#quantity').val(quantity + 1);


            // Increment

        });

        $('.quantity-left-minus').click(function (e) {
            // Stop acting like a button
            e.preventDefault();
            // Get the field name
            var quantity = parseInt($('#quantity').val());

            // If is not undefined

            // Increment
            if (quantity > 0) {
                $('#quantity').val(quantity - 1);
            }
        });

    });

    function showNotification(title, message, redirectUrl) {
        var overlay = document.createElement("div");
        overlay.className = "overlay";

        var notification = document.createElement("div");
        notification.className = "notification";

        var titleLabel = document.createElement("h3");
        titleLabel.innerHTML = title;

        var messageLabel = document.createElement("p");
        messageLabel.innerHTML = message;

        var okButton = document.createElement("button");
        okButton.innerHTML = "Xác Nhận";
        okButton.onclick = function () {
            // Handle OK button action
            window.location.href = redirectUrl;
        };

        var closeButton = document.createElement("button");
        closeButton.innerHTML = "Đóng Luôn";
        closeButton.onclick = function () {
            document.body.removeChild(overlay);
        };

        notification.appendChild(titleLabel);
        notification.appendChild(messageLabel);
        notification.appendChild(okButton);
        notification.appendChild(closeButton);

        overlay.appendChild(notification);
        document.body.appendChild(overlay);
    }

    function preventDefault(event) {
        event.preventDefault();
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
        integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
        integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
        crossorigin="anonymous"></script>
</body>
</html>