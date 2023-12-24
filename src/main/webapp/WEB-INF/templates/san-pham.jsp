<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Tables</title>

    <link href="../../vendor/fontawesome-free/css/all.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="../../css/sb-admin-2.css" rel="stylesheet">

    <link href="../../vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <link href="../../vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    <link href="../../css/css/mixins/_text-hide.css" rel="stylesheet">


</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/admin/view">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item">
            <a class="nav-link" href="/admin/view">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Interface
        </div>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-cog"></i>
                <span>Components</span>
            </a>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Custom Components:</h6>
                    <a class="collapse-item" href="buttons.html">Buttons</a>
                    <a class="collapse-item" href="cards.html">Cards</a>
                </div>
            </div>
        </li>

        <!-- Nav Item - Utilities Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
               aria-expanded="true" aria-controls="collapseUtilities">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Utilities</span>
            </a>
            <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">Custom Utilities:</h6>
                    <a class="collapse-item" href="utilities-color.html">Colors</a>
                    <a class="collapse-item" href="utilities-border.html">Borders</a>
                    <a class="collapse-item" href="utilities-animation.html">Animations</a>
                    <a class="collapse-item" href="utilities-other.html">Other</a>
                </div>
            </div>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Addons
        </div>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
               aria-expanded="true" aria-controls="collapsePages">
                <i class="fas fa-fw fa-table"></i>
                <span>Sản phẩm</span>
            </a>
            <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="/product/view">Danh sách sản phẩm</a>
                    <div class="collapse-divider"></div>
                    <a class="collapse-item" href="/product/view-add">Tạo sản phẩm</a>
                </div>
            </div>
        </li>

        <!-- Nav Item - Charts -->
        <li class="nav-item">
            <a class="nav-link" href="charts.html">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Charts</span></a>
        </li>

        <!-- Nav Item - Tables -->
        <li class="nav-item active">
            <a class="nav-link" href="/product/view">
                <i class="fas fa-fw fa-table"></i>
                <span>Sản phẩm</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <form class="form-inline">
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>
                </form>



                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->



                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>
                            <img class="img-profile rounded-circle"
                                 src="../../images/about.jpg">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Profile
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                Settings
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                Activity Log
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Logout
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">Tables</h1>
                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Danh sách sản phẩm</h6>
                    </div>
<%--                    <div style="position: relative;left: 1100px; margin-top: 20px">--%>
<%--                        <button type="button" class="btn btn-outline-primary" data-toggle="modal"--%>
<%--                                data-target="#addModal"--%>
<%--                                style="width: 100px; height: 40px; margin-right: 10px ">--%>
<%--                            <i class="fas fa-duotone fa-plus"></i>--%>
<%--                        </button>--%>

<%--                    </div>--%>


                    <div class="card-body">
<%--                        <form:form modelAttribute="productForm" action="/product/update" method="post" enctype="multipart/form-data">--%>
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th>STT</th>
                                    <th>Mã</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Màu sắc</th>
                                    <th>Kích cỡ</th>
                                    <th>Ảnh nền</th>
                                    <th>Giá</th>
                                    <th>Số lượng</th>
                                    <th>Trạng thái</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th></th>
                                    <th>STT</th>
                                    <th>Mã</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Màu sắc</th>
                                    <th>Kích cỡ</th>
                                    <th>Ảnh nền</th>
                                    <th>Giá</th>
                                    <th>Số lượng</th>
                                    <th>Trạng thái</th>
                                    <th>Action</th>
                                </tr>
                                </tfoot>
                                <tbody>
                                <c:forEach items="${product}" var="pro" varStatus="i">
                                    <tr>
                                        <th><input type="checkbox" value="${pro.idProductDetail}" id="check"></th>
                                        <th>${i.index+1}</th>
                                        <th>${pro.sanPham.ma}</th>
                                        <td>${pro.sanPham.tenSanPham}</td>
                                        <td>${pro.mauSac.tenMau}</td>
                                        <td><input class="input-group flex-nowrap" id="productSize" type="text" name="productId" value="${pro.kichCo.size}"></td>
                                        <td><img style="height: 100px" width="100px" src="${pro.photo}"></td>

                                        <td><input class="input-group flex-nowrap currency-input" type="text" id="productAddPrice" name="productId" value="${pro.donGia}"></td>
                                        <td><input class="input-group flex-nowrap" type="text" id="productAddQuantity" name="productId" value="${pro.soLuong}"></td>
                                        <td>${pro.trangThai==1?"còn hàng":"hết hàng"}</td>
                                        <td>
                                            <a class="btn btn-primary btn-detail" data-product-id="${pro.idProductDetail}">
                                                <i class="fa fa-wrench" aria-hidden="true"></i>
                                            </a>
                                        </td>

                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                            <button type="submit" class="btn btn-primary" style="float: right" >Lưu</button>
                            <button type="submit" class="btn btn-primary" style="float: right">Xóa</button>
                        </div>
<%--                        </form:form>--%>
                    </div>
                </div>

            </div>
<%--            modal detail--%>
            <div class="modal fade" id="productDetailModal" tabindex="-1" role="dialog" aria-labelledby="productDetailModalLabel" aria-hidden="true"

            >
                <div class="modal-dialog" role="document" style="max-width: 50%;
                                            margin: 0 auto;">
                    <div class="modal-content" style="width: 100%">
                        <div class="modal-header">
                            <h5 class="modal-title" id="productDetailModalLabel">Chi tiết sản phẩm</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form:form method="post" action="/product/update" modelAttribute="product"
                                   enctype="multipart/form-data" id="myForm">
                        <div class="modal-body"style="width: 100%">

                        </div>
                        </form:form>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->
<%--        <form:form modelAttribute="productForm" action="/product/update" method="post">--%>
<%--        <c:forEach items="${product}" var="pro" varStatus="i">--%>
<%--            <tr>--%>
<%--                <!-- Các cột dữ liệu -->--%>
<%--                ...--%>
<%--                <td>--%>
<%--                    <!-- Biểu mẫu chỉnh sửa -->--%>

<%--                        <input type="hidden" name="productId" value="${pro.idProductDetail}">--%>
<%--                        <!-- Các trường chỉnh sửa -->--%>
<%--                        <!-- Ví dụ: -->--%>

<%--                        <!-- Các trường khác -->--%>
<%--                        ...--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--            <button type="submit" class="btn btn-primary">Lưu</button>--%>
<%--        </form:form>--%>
<%--        <div class="modal" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"--%>
<%--             aria-hidden="true">--%>
<%--            <div class="modal-dialog" role="document">--%>
<%--                <div class="modal-content">--%>
<%--                    <div class="modal-header text-center">--%>
<%--                        <h4 class="modal-title w-100 font-weight-bold">Thêm sản phẩm</h4>--%>
<%--                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                            <span aria-hidden="true">x</span>--%>
<%--                        </button>--%>
<%--                    </div>--%>
<%--                    <div class="modal-body mx-3">--%>
<%--                        <form:form method="post" action="/product/add" modelAttribute="product"--%>
<%--                                   enctype="multipart/form-data">--%>
<%--                            <div class="container"  id="form-add-1">--%>

<%--                                <div class="row">--%>
<%--                                    <div class="col-6">--%>
<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                <span class="input-group-text"><i--%>
<%--                                                        class="fas fa-solid fa-id-card"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <input type="text" class="form-control"--%>
<%--                                                   value="${maZen}"--%>
<%--                                                   aria-label="Username" aria-describedby="addon-wrapping" name="ma" readonly>--%>
<%--                                        </div>--%>
<%--                                        <br>--%>
<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                    <span class="input-group-text"><i--%>
<%--                                                            class="fas fa-solid fa-file-signature"></i></span>--%>
<%--                                            </div>--%>

<%--                                            <input type="text" class="form-control"--%>
<%--                                                   placeholder="Nhập tên sản phẩm"--%>
<%--                                                   aria-label="Username" aria-describedby="addon-wrapping" name="tenSanPham" id="productAddName">--%>

<%--                                            <span class="error-icon" data-toggle="tooltip" data-placement="right" title=""></span>--%>
<%--                                        </div>--%>
<%--                                        <br>--%>
<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                        <span class="input-group-text"><i--%>
<%--                                                                class="fas fa-solid fa-money-bill-wave"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <input type="text" class="form-control"--%>
<%--                                                   placeholder="Nhập giá sản phẩm"--%>
<%--                                                   aria-label="Username" aria-describedby="addon-wrapping" name="donGia" id="productAddPrice">--%>
<%--                                            <span class="error-icon" data-toggle="tooltip" data-placement="right" title=""></span>--%>
<%--                                        </div>--%>
<%--                                        <br>--%>
<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                        <span class="input-group-text"><i--%>
<%--                                                                class="fas fa-solid fa-bars"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <input type="text" class="form-control"--%>
<%--                                                   placeholder="Nhập số lượng sản phẩm"--%>
<%--                                                   aria-label="Username" aria-describedby="addon-wrapping" name="soLuong" id="productAddQuantity">--%>
<%--                                            <span class="error-icon" data-toggle="tooltip" data-placement="right" title=""></span>--%>

<%--                                        </div>--%>
<%--                                        <br>--%>
<%--                                        <div class="input-group mb-3">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                    <span class="input-group-text"--%>
<%--                                                    ><i class="fas fa-solid fa-upload"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <div class="custom-file">--%>
<%--                                                <input type="file" class="custom-file-input"--%>
<%--                                                       aria-describedby="inputGroupFileAddon01" name="image1" required>--%>
<%--                                                <label class="custom-file-label">Chọn ảnh đại điện</label>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <div class="input-group mb-3">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                    <span class="input-group-text"--%>
<%--                                                    ><i class="fas fa-solid fa-upload"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <div class="custom-file">--%>
<%--                                                <input type="file" class="custom-file-input"--%>
<%--                                                       aria-describedby="inputGroupFileAddon01" name="image2" required>--%>
<%--                                                <label class="custom-file-label">Chọn ảnh kèm theo 1</label>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>


<%--                                    </div>--%>
<%--                                    <div class="col-6">--%>

<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                <span class="input-group-text"><i--%>
<%--                                                        class="fas fa-solid fa-id-card"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <select class="form-control"--%>
<%--                                                    aria-label="Username" aria-describedby="addon-wrapping" name="loaiGiay">--%>
<%--                                                <option selected disabled>Chọn loại giày</option>--%>
<%--                                                <c:forEach var="item" items="${loaiDay}">--%>
<%--                                                    <option value="${item.id}">${item.tenTheLoai}</option>--%>
<%--                                                </c:forEach>--%>
<%--                                            </select>--%>
<%--                                            <span class="error-message"></span>--%>
<%--                                        </div>--%>
<%--                                        <br>--%>
<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                <span class="input-group-text"><i--%>
<%--                                                        class="fas fa-solid fa-id-card"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <select class="form-control"--%>
<%--                                                    aria-label="Username" aria-describedby="addon-wrapping" name="chatLieu">--%>
<%--                                                <option selected disabled>Chọn chất liệu</option>--%>
<%--                                                <c:forEach var="item" items="${chatLieuList}">--%>
<%--                                                    <option value="${item.id}">${item.tenChatLieu}</option>--%>
<%--                                                </c:forEach>--%>
<%--                                            </select>--%>
<%--                                            <span class="error-message"></span>--%>
<%--                                        </div>--%>
<%--                                        <br>--%>
<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                <span class="input-group-text"><i--%>
<%--                                                        class="fas fa-solid fa-id-card"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <select class="form-control"--%>
<%--                                                    aria-label="Username" aria-describedby="addon-wrapping" name="mauSac">--%>
<%--                                                <option selected disabled>Chọn màu sắc giày</option>--%>
<%--                                                <c:forEach var="item" items="${mauSacList}">--%>
<%--                                                    <option value="${item.id}">${item.tenMau}</option>--%>
<%--                                                </c:forEach>--%>
<%--                                            </select>--%>
<%--                                            <span class="error-message"></span>--%>
<%--                                        </div>--%>
<%--                                        <br>--%>
<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                <span class="input-group-text"><i--%>
<%--                                                        class="fas fa-solid fa-id-card"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <select class="form-control"--%>
<%--                                                    aria-label="Username" aria-describedby="addon-wrapping" name="kichCo">--%>
<%--                                                <option selected disabled>Chọn kích cỡ giày</option>--%>
<%--                                                <c:forEach var="item" items="${coList}">--%>
<%--                                                    <option value="${item.id}">${item.size}</option>--%>
<%--                                                </c:forEach>--%>
<%--                                            </select>--%>
<%--                                            <span class="error-message"></span>--%>
<%--                                        </div>--%>
<%--                                        <br>--%>
<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                <span class="input-group-text"><i--%>
<%--                                                        class="fas fa-solid fa-id-card"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <select class="form-control"--%>
<%--                                                    aria-label="Username" aria-describedby="addon-wrapping" name="deGiay">--%>
<%--                                                <option selected disabled>Chọn loại đế giày</option>--%>
<%--                                                <c:forEach var="item" items="${deGiayList}">--%>
<%--                                                    <option value="${item.id}">${item.loaiDe}</option>--%>
<%--                                                </c:forEach>--%>
<%--                                            </select>--%>
<%--                                            <span class="error-message"></span>--%>
<%--                                        </div>--%>

<%--                                        <div class="input-group mb-3" style="padding-top: 15px">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                    <span class="input-group-text"--%>
<%--                                                    ><i class="fas fa-solid fa-upload"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <div class="custom-file">--%>
<%--                                                <input type="file" class="custom-file-input"--%>
<%--                                                       aria-describedby="inputGroupFileAddon01" name="image3" id="imageNumber2">--%>
<%--                                                <label class="custom-file-label" for="imageNumber2">Chọn ảnh kèm theo 2</label>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>


<%--                                    </div>--%>
<%--                                    <div class="input-group col-12">--%>
<%--                                        <div class="input-group-prepend">--%>
<%--                                            <span class="input-group-text">Mô tả sản phẩm</span>--%>
<%--                                        </div>--%>
<%--                                        <textarea class="form-control" aria-label="With textarea" name="moTa" id="productAddDescribe"></textarea>--%>
<%--                                        <span class="error-icon" data-toggle="tooltip" data-placement="right" title=""></span>--%>

<%--                                    </div>--%>
<%--                                    <div style="padding-left: 7px;padding-top: 10px">--%>
<%--                                        <label>Trạng thái:</label>--%>
<%--                                        <div class="form-check-inline">--%>
<%--                                            <input class="form-check-input" type="radio"--%>
<%--                                                   value=1 name="trangThai" required>--%>
<%--                                            <label class="form-check-label" >--%>
<%--                                                Còn hàng--%>
<%--                                            </label>--%>
<%--                                        </div>--%>
<%--                                        <div class="form-check-inline">--%>
<%--                                            <input class="form-check-input" type="radio"--%>
<%--                                                   value=0 name="trangThai" required>--%>
<%--                                            <label class="form-check-label" >--%>
<%--                                                Hết hàng--%>
<%--                                            </label>--%>
<%--                                        </div>--%>

<%--                                    </div>--%>

<%--                                </div>--%>
<%--                                <div class="modal-footer d-flex justify-content-center">--%>
<%--                                    <button class="btn btn-outline-primary" type="submit">Update</button>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </form:form>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        Update sản phẩm--%>

<%--        <div class="modal" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"--%>
<%--             aria-hidden="true">--%>
<%--            <div class="modal-dialog" role="document">--%>
<%--                <div class="modal-content">--%>
<%--                    <div class="modal-header text-center">--%>
<%--                        <h4 class="modal-title w-100 font-weight-bold">Cập nhật sản phẩm</h4>--%>
<%--                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                            <span aria-hidden="true">x</span>--%>
<%--                        </button>--%>
<%--                    </div>--%>
<%--                    <div class="modal-body mx-3">--%>
<%--                        <form:form method="post" action="/product/update/{id}" modelAttribute="product"--%>
<%--                                   enctype="multipart/form-data">--%>
<%--                            <div class="container"  id="form-add-1">--%>

<%--                                <div class="row">--%>
<%--                                    <div class="col-6">--%>
<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                <span class="input-group-text"><i--%>
<%--                                                        class="fas fa-solid fa-id-card"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <input type="text" class="form-control"--%>
<%--                                                   value="${maZen}"--%>
<%--                                                   aria-label="Username" aria-describedby="addon-wrapping" name="ma" readonly>--%>
<%--                                        </div>--%>
<%--                                        <br>--%>
<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                    <span class="input-group-text"><i--%>
<%--                                                            class="fas fa-solid fa-file-signature"></i></span>--%>
<%--                                            </div>--%>

<%--                                            <input type="text" class="form-control"--%>
<%--                                                   placeholder="Nhập tên sản phẩm"--%>
<%--                                                   aria-label="Username" aria-describedby="addon-wrapping" name="tenSanPham" id="productAddName">--%>

<%--                                            <span class="error-icon" data-toggle="tooltip" data-placement="right" title=""></span>--%>
<%--                                        </div>--%>
<%--                                        <br>--%>
<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                        <span class="input-group-text"><i--%>
<%--                                                                class="fas fa-solid fa-money-bill-wave"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <input type="text" class="form-control"--%>
<%--                                                   placeholder="Nhập giá sản phẩm"--%>
<%--                                                   aria-label="Username" aria-describedby="addon-wrapping" name="donGia" id="productAddPrice">--%>
<%--                                            <span class="error-icon" data-toggle="tooltip" data-placement="right" title=""></span>--%>
<%--                                        </div>--%>
<%--                                        <br>--%>
<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                        <span class="input-group-text"><i--%>
<%--                                                                class="fas fa-solid fa-bars"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <input type="text" class="form-control"--%>
<%--                                                   placeholder="Nhập số lượng sản phẩm"--%>
<%--                                                   aria-label="Username" aria-describedby="addon-wrapping" name="soLuong" id="productAddQuantity">--%>
<%--                                            <span class="error-icon" data-toggle="tooltip" data-placement="right" title=""></span>--%>

<%--                                        </div>--%>
<%--                                        <br>--%>
<%--                                        <div class="input-group mb-3">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                    <span class="input-group-text"--%>
<%--                                                    ><i class="fas fa-solid fa-upload"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <div class="custom-file">--%>
<%--                                                <input type="file" class="custom-file-input"--%>
<%--                                                       aria-describedby="inputGroupFileAddon01" name="image1" required>--%>
<%--                                                <label class="custom-file-label">Chọn ảnh đại điện</label>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>
<%--                                        <div class="input-group mb-3">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                    <span class="input-group-text"--%>
<%--                                                    ><i class="fas fa-solid fa-upload"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <div class="custom-file">--%>
<%--                                                <input type="file" class="custom-file-input"--%>
<%--                                                       aria-describedby="inputGroupFileAddon01" name="image2" required>--%>
<%--                                                <label class="custom-file-label">Chọn ảnh kèm theo 1</label>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>


<%--                                    </div>--%>
<%--                                    <div class="col-6">--%>

<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                <span class="input-group-text"><i--%>
<%--                                                        class="fas fa-solid fa-id-card"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <select class="form-control"--%>
<%--                                                    aria-label="Username" aria-describedby="addon-wrapping" name="loaiGiay">--%>
<%--                                                <option selected disabled>Chọn loại giày</option>--%>
<%--                                                <c:forEach var="item" items="${loaiDay}">--%>
<%--                                                    <option value="${item.id}">${item.tenTheLoai}</option>--%>
<%--                                                </c:forEach>--%>
<%--                                            </select>--%>
<%--                                            <span class="error-message"></span>--%>
<%--                                        </div>--%>
<%--                                        <br>--%>
<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                <span class="input-group-text"><i--%>
<%--                                                        class="fas fa-solid fa-id-card"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <select class="form-control"--%>
<%--                                                    aria-label="Username" aria-describedby="addon-wrapping" name="chatLieu">--%>
<%--                                                <option selected disabled>Chọn chất liệu</option>--%>
<%--                                                <c:forEach var="item" items="${chatLieuList}">--%>
<%--                                                    <option value="${item.id}">${item.tenChatLieu}</option>--%>
<%--                                                </c:forEach>--%>
<%--                                            </select>--%>
<%--                                            <span class="error-message"></span>--%>
<%--                                        </div>--%>
<%--                                        <br>--%>
<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                <span class="input-group-text"><i--%>
<%--                                                        class="fas fa-solid fa-id-card"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <select class="form-control"--%>
<%--                                                    aria-label="Username" aria-describedby="addon-wrapping" name="mauSac">--%>
<%--                                                <option selected disabled>Chọn màu sắc giày</option>--%>
<%--                                                <c:forEach var="item" items="${mauSacList}">--%>
<%--                                                    <option value="${item.id}">${item.tenMau}</option>--%>
<%--                                                </c:forEach>--%>
<%--                                            </select>--%>
<%--                                            <span class="error-message"></span>--%>
<%--                                        </div>--%>
<%--                                        <br>--%>
<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                <span class="input-group-text"><i--%>
<%--                                                        class="fas fa-solid fa-id-card"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <select class="form-control"--%>
<%--                                                    aria-label="Username" aria-describedby="addon-wrapping" name="kichCo">--%>
<%--                                                <option selected disabled>Chọn kích cỡ giày</option>--%>
<%--                                                <c:forEach var="item" items="${coList}">--%>
<%--                                                    <option value="${item.id}">${item.size}</option>--%>
<%--                                                </c:forEach>--%>
<%--                                            </select>--%>
<%--                                            <span class="error-message"></span>--%>
<%--                                        </div>--%>
<%--                                        <br>--%>
<%--                                        <div class="input-group flex-nowrap">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                <span class="input-group-text"><i--%>
<%--                                                        class="fas fa-solid fa-id-card"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <select class="form-control"--%>
<%--                                                    aria-label="Username" aria-describedby="addon-wrapping" name="deGiay">--%>
<%--                                                <option selected disabled>Chọn loại đế giày</option>--%>
<%--                                                <c:forEach var="item" items="${deGiayList}">--%>
<%--                                                    <option value="${item.id}">${item.loaiDe}</option>--%>
<%--                                                </c:forEach>--%>
<%--                                            </select>--%>
<%--                                            <span class="error-message"></span>--%>
<%--                                        </div>--%>

<%--                                        <div class="input-group mb-3" style="padding-top: 15px">--%>
<%--                                            <div class="input-group-prepend">--%>
<%--                                                    <span class="input-group-text"--%>
<%--                                                    ><i class="fas fa-solid fa-upload"></i></span>--%>
<%--                                            </div>--%>
<%--                                            <div class="custom-file">--%>
<%--                                                <input type="file" class="custom-file-input"--%>
<%--                                                       aria-describedby="inputGroupFileAddon01" name="image3" id="imageNumber2">--%>
<%--                                                <label class="custom-file-label" for="imageNumber2">Chọn ảnh kèm theo 2</label>--%>
<%--                                            </div>--%>
<%--                                        </div>--%>


<%--                                    </div>--%>
<%--                                    <div class="input-group col-12">--%>
<%--                                        <div class="input-group-prepend">--%>
<%--                                            <span class="input-group-text">Mô tả sản phẩm</span>--%>
<%--                                        </div>--%>
<%--                                        <textarea class="form-control" aria-label="With textarea" name="moTa" id="productAddDescribe"></textarea>--%>
<%--                                        <span class="error-icon" data-toggle="tooltip" data-placement="right" title=""></span>--%>

<%--                                    </div>--%>
<%--                                    <div style="padding-left: 7px;padding-top: 10px">--%>
<%--                                        <label>Trạng thái:</label>--%>
<%--                                        <div class="form-check-inline">--%>
<%--                                            <input class="form-check-input" type="radio"--%>
<%--                                                   value=1 name="trangThai" required>--%>
<%--                                            <label class="form-check-label" >--%>
<%--                                                Còn hàng--%>
<%--                                            </label>--%>
<%--                                        </div>--%>
<%--                                        <div class="form-check-inline">--%>
<%--                                            <input class="form-check-input" type="radio"--%>
<%--                                                   value=0 name="trangThai" required>--%>
<%--                                            <label class="form-check-label" >--%>
<%--                                                Hết hàng--%>
<%--                                            </label>--%>
<%--                                        </div>--%>

<%--                                    </div>--%>

<%--                                </div>--%>
<%--                                <div class="modal-footer d-flex justify-content-center">--%>
<%--                                    <button class="btn btn-outline-primary" type="submit">Update</button>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </form:form>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2020</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
    <script src="../../vendor/jquery/jquery.min.js"></script>
    <script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="../../vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="../../js/sb-admin-2.js"></script>






<script src="../../vendor/datatables/jquery.dataTables.min.js"></script>
<script src="../../vendor/datatables/dataTables.bootstrap4.min.js"></script>


<script src="../../js/demo/datatables-demo.js"></script>
<script src="../../js/demo/modal-custom.js"></script>


</body>

</html>