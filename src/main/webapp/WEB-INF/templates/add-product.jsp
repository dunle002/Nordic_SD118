<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <link href="../../css/css/mixins/select2.css" rel="stylesheet" type="text/css">
    <link href="../../css/css/mixins/_text-hide.css" rel="stylesheet" type="text/css">

    <style>
        .input-group-append {
            display: flex;
            flex-direction: column;
        }

        .input-group-append .error-message {
            margin-top: 5px; /* Điều chỉnh khoảng cách giữa input và error message */
        }
    </style>
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
                    <h6 class="collapse-header">Thuộc tính</h6>
                    <a class="collapse-item" href="/thuoc-tinh/view">Quản lí thuộc tính</a>

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
        <form:form method="post" action="/product/add"
                   enctype="multipart/form-data" id="myForm">
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
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">TẠO MỚI SẢN PHẨM</h6>
                        </div>


                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table" width="100%" cellspacing="0">


                                    <div class="container" id="form-add-1">
                                        <input type="hidden" class="form-control"
                                               value="${maZen}"
                                               aria-label="Username" aria-describedby="addon-wrapping" name="ma"
                                               readonly>
                                        <div class="row">
                                            <div class="py-3">
                                                <h7 class="m-0 font-weight-bold text-primary">SẢN PHẨM</h7>
                                            </div>
                                            <div style="width: 100%" class="row">
                                                <div class="input-group flex-nowrap col-md-6">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text">Tên sản phẩm</span>
                                                    </div>

                                                    <input type="text" class="form-control"
                                                           placeholder="Nhập tên sản phẩm" aria-label="Username"
                                                           aria-describedby="addon-wrapping" name="tenSanPham"
                                                           id="productAddName"
                                                           list="productList" autocomplete="off"
                                                    >
                                                    <datalist id="productList">
                                                        <c:forEach items="${tenSanPham}" var="sp">
                                                            <option class="select2-dropdown"
                                                                    value="${sp.tenSanPham}">${sp.tenSanPham}</option>
                                                        </c:forEach>
                                                    </datalist>
                                                    <span class="error-icon" data-toggle="tooltip"
                                                          data-placement="right" title=""></span>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="input-group flex-nowrap">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text">Thương hiệu</span>
                                                        </div>
                                                        <select class="form-control" id="thuong-hieu-select"
                                                                aria-label="Username"
                                                                aria-describedby="addon-wrapping" name="thuongHieu"
                                                        >
                                                            <c:forEach var="item" items="${thuongHieuList}">
                                                                <option value="${item.id}">${item.tenThuongHieu}</option>
                                                            </c:forEach>
                                                        </select>
                                                        <div class="input-group-append">
                                                            <a class="btn btn-primary" type="button" id="id-thuong-hieu"
                                                               style="border-radius:0;height: 41px"><i
                                                                    class="fa fa-plus" aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                            <br>
                                            <div class="py-3">
                                                <h7 class="m-0 font-weight-bold text-primary">THUỘC TÍNH</h7>
                                            </div>
                                            <br>
                                            <div class="container">

                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="input-group flex-nowrap">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text">Loại giày</span>
                                                            </div>
                                                            <select class="form-control"
                                                                    aria-label="Username"
                                                                    aria-describedby="addon-wrapping"
                                                                    id="loaiday-select" name="loaiGiay">
                                                                <c:forEach var="item" items="${loaiDay}">
                                                                    <option value="${item.id}">${item.tenTheLoai}</option>
                                                                </c:forEach>
                                                            </select>
                                                            <div class="input-group-append">
                                                                <a class="btn btn-primary" type="button"
                                                                   id="id-loai-giay"
                                                                   style="border-radius:0;height: 41px"><i
                                                                        class="fa fa-plus" aria-hidden="true"></i></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="input-group flex-nowrap">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text">Chất liệu</span>
                                                            </div>
                                                            <select class="form-control"
                                                                    aria-label="Username" id="chatlieu-select"
                                                                    aria-describedby="addon-wrapping">
                                                                <c:forEach var="item" items="${chatLieuList}">
                                                                    <option value="${item.id}">${item.tenChatLieu}</option>
                                                                </c:forEach>
                                                            </select>
                                                            <div class="input-group-append">
                                                                <a class="btn btn-primary" type="button"
                                                                   id="id-chat-lieu"
                                                                   style="border-radius:0;height: 41px"><i
                                                                        class="fa fa-plus" aria-hidden="true"></i></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row" style="padding-top: 20px">
                                                    <div class="col-md-6">
                                                        <div class="input-group flex-nowrap">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text">Đế giày</span>
                                                            </div>
                                                            <select class="form-control" id="degiay-select"
                                                                    aria-label="Username"
                                                                    aria-describedby="addon-wrapping"
                                                            >
                                                                <c:forEach var="item" items="${deGiayList}">
                                                                    <option value="${item.id}">${item.loaiDe}</option>
                                                                </c:forEach>
                                                            </select>
                                                            <div class="input-group-append">
                                                                <a class="btn btn-primary" type="button" id="id-de-giay"
                                                                   style="border-radius:0;height: 41px"><i
                                                                        class="fa fa-plus" aria-hidden="true"></i></a>
                                                            </div>
                                                            <span class="error-message"></span>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="input-group mb-3">
                                                            <div class="input-group-prepend">
                                                    <span class="input-group-text"
                                                    >Ảnh</span>
                                                            </div>
                                                            <div class="custom-file">
                                                                <input type="file" class="custom-file-input"
                                                                       aria-describedby="inputGroupFileAddon01"
                                                                       name="image31" id="imageNumber2">
                                                                <label class="custom-file-label" for="imageNumber2">Chọn
                                                                    ảnh</label>
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                                <div class="row" style="padding-top: 20px">
                                                    <div class="col-md-6">
                                                        <div class="input-group flex-nowrap">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text">Màu sắc</span>
                                                            </div>
                                                            <select id="my-select" multiple
                                                                    class="form-control">
                                                                <c:forEach var="item" items="${mauSacList}">
                                                                    <option value="${item.id}">${item.tenMau}</option>
                                                                </c:forEach>
                                                            </select>
                                                            <div class="input-group-append">
                                                                <a class="btn btn-primary" type="button" id="id-mau-sac"
                                                                   style="border-radius:0;height: 41px"><i
                                                                        class="fa fa-plus" aria-hidden="true"></i></a>
                                                            </div>

                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="input-group flex-nowrap">
                                                            <div class="input-group-prepend">
                                                                <span class="input-group-text">Kích cỡ</span>
                                                            </div>
                                                            <select class="form-control" id="kichco-select" multiple
                                                                    aria-label="Username"
                                                                    aria-describedby="addon-wrapping"
                                                            >
                                                                <c:forEach var="item" items="${coList}">
                                                                    <option value="${item.id}">${item.size}</option>
                                                                </c:forEach>
                                                            </select>
                                                            <div class="input-group-append">
                                                                <a class="btn btn-primary" type="button" id="id-kich-co"
                                                                   style="border-radius:0;height: 41px"><i
                                                                        class="fa fa-plus" aria-hidden="true"></i></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div id="selected-options"></div>

                                            </div>


                                        </div>
                                        <div class="modal-footer d-flex justify-content-center">
                                            <div class="input-group col-12" style="padding-top: 20px">
                                                <div class="input-group-prepend">
                                                    <span class="input-group-text">Mô tả sản phẩm</span>
                                                </div>
                                                <textarea class="form-control" aria-label="With textarea" name="moTa"
                                                          id="productAddDescribe"></textarea>
                                                <span class="error-icon" data-toggle="tooltip" data-placement="right"
                                                      title=""></span>

                                            </div>
                                            <div style="padding-left: 7px;padding-top: 10px" id="trangThaiDiv">
                                                <label>Trạng thái:</label>
                                                <div class="form-check-inline">
                                                    <input class="form-check-input" type="radio"
                                                           value=1 name="trangThai" required>
                                                    <label class="form-check-label">
                                                        Hiển thị
                                                    </label>
                                                </div>
                                                <div class="form-check-inline">
                                                    <input class="form-check-input" type="radio"
                                                           value=0 name="trangThai" required>
                                                    <label class="form-check-label">
                                                        Không hiển thị
                                                    </label>
                                                </div>

                                            </div>
                                        </div>


                                    </div>

                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">CHI TIẾT SẢN PHẨM</h6>
                            </div>
                            <button type="submit" class="btn-primary"
                                    style="width: 120px;float: right; border-radius: 2px;padding-right: 20px">Thêm
                            </button>
                            <a class="btn-primary" id="editButton"
                                    style="width: 120px;height: 30px;float: right;margin-right: 10px;padding-bottom: 10px;text-align: center">Chỉnh sửa
                            </a>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" width="100%" cellspacing="0">
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th>Tên sản phẩm</th>
                                        <th>Loại giày</th>
                                        <th>Để giày</th>
                                        <th>Chất liệu</th>
                                        <th>Giá</th>
                                        <th>Số lượng</th>
                                        <th>Trạng thái</th>
                                        <th></th>
                                        <th>Ảnh</th>
                                    </tr>
                                    </thead>
                                    <tbody>



                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>


                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
        </form:form>

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

    <%--            modal thuong hieu--%>
    <div class="modal fade" id="thuongHieuModal" tabindex="-1" role="dialog"
         aria-labelledby="productDetailModalLabel" aria-hidden="true"

    >
        <div class="modal-dialog" role="document" style="max-width: 50%;
                                            margin: 0 auto;">
            <div class="modal-content" style="width: 100%">
                <div class="modal-header">
                    <h5 class="modal-title" >Thương hiệu</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form:form method="post" action="/thuong-hieu/add" modelAttribute="thuongHieuAdd"
                           enctype="multipart/form-data">
                    <div class="modal-body" style="width: 100%">

                    </div>
                </form:form>
            </div>
        </div>
    </div>
<%--    modal chất liệu--%>
    <div class="modal fade" id="chatLieuModal" tabindex="-1" role="dialog"
         aria-labelledby="productDetailModalLabel" aria-hidden="true"

    >
        <div class="modal-dialog" role="document" style="max-width: 50%;
                                            margin: 0 auto;">
            <div class="modal-content" style="width: 100%">
                <div class="modal-header">
                    <h5 class="modal-title">Chất liệu</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form:form method="post" action="/chat-lieu/add" modelAttribute="chatLieuAdd"
                           enctype="multipart/form-data">
                    <div class="modal-body" style="width: 100%">

                    </div>
                </form:form>
            </div>
        </div>
    </div>
<%--    Màu sắc--%>
    <div class="modal fade" id="mauSacModal" tabindex="-1" role="dialog"
         aria-labelledby="productDetailModalLabel" aria-hidden="true"

    >
        <div class="modal-dialog" role="document" style="max-width: 50%;
                                            margin: 0 auto;">
            <div class="modal-content" style="width: 100%">
                <div class="modal-header">
                    <h5 class="modal-title">Màu sắc</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form:form method="post" action="/mau-sac/add" modelAttribute="mauSacAdd"
                           enctype="multipart/form-data">
                    <div class="modal-body" style="width: 100%">

                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<%--Kích cỡ--%>
<div class="modal fade" id="kichCoModal" tabindex="-1" role="dialog"
     aria-labelledby="productDetailModalLabel" aria-hidden="true"

>
    <div class="modal-dialog" role="document" style="max-width: 50%;
                                            margin: 0 auto;">
        <div class="modal-content" style="width: 100%">
            <div class="modal-header">
                <h5 class="modal-title">Kích cỡ</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form:form method="post" action="/kich-co/add" modelAttribute="kichCoAdd"
                       enctype="multipart/form-data">
                <div class="modal-body" style="width: 100%">

                </div>
            </form:form>
        </div>
    </div>
</div>
<%--Loại giày--%>
<div class="modal fade" id="loaiDayModal" tabindex="-1" role="dialog"
     aria-labelledby="productDetailModalLabel" aria-hidden="true"

>
    <div class="modal-dialog" role="document" style="max-width: 50%;
                                            margin: 0 auto;">
        <div class="modal-content" style="width: 100%">
            <div class="modal-header">
                <h5 class="modal-title">Loại giày</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form:form method="post" action="/loai-giay/add" modelAttribute="loaiGiayAdd"
                       enctype="multipart/form-data">
                <div class="modal-body" style="width: 100%">

                </div>
            </form:form>
        </div>
    </div>
</div>
<%--Đế giày--%>
<div class="modal fade" id="deGiayModal" tabindex="-1" role="dialog"
     aria-labelledby="productDetailModalLabel" aria-hidden="true"

>
    <div class="modal-dialog" role="document" style="max-width: 50%;
                                            margin: 0 auto;">
        <div class="modal-content" style="width: 100%">
            <div class="modal-header">
                <h5 class="modal-title">Đế giày</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form:form method="post" action="/de-giay/add" modelAttribute="deGiayAdd"
                       enctype="multipart/form-data">
                <div class="modal-body" style="width: 100%">

                </div>
            </form:form>
        </div>
    </div>
</div>
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

<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
     aria-labelledby="productDetailModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document" style="max-width: 50%;
                                            margin: 0 auto;">
        <div class="modal-content" style="width: 100%">
            <div class="modal-header">
                <h5 class="modal-title" id="productDetailModalLabel">Chỉnh sửa</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div style="justify-content: center">
                <div class="modal-body" style="justify-content: center">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1">Số lượng</span>
                        </div>
                        <input type="text" class="form-control" id="editQuantity" name="editQuantity"
                               aria-label="Username"
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon2">Đơn giá</span>
                        </div>
                        <input type="text" class="form-control" aria-label="Username"
                               aria-describedby="basic-addon2" id="editPrice" name="editPrice">
                    </div>

                </div>
            </div>

            <div class="modal-footer " style="justify-content: center">
                <button class="btn btn-primary" id="saveButton" type="button" data-dismiss="modal">Sửa</button>
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
<script src="../../js/custom-js.js"></script>

<script src="../../js/demo/datatables-demo.js"></script>
<script src="../../js/demo/modal-add.js"></script>

</script>
<script>
    // var fomatSoLuong = new NumericInput();

    document.addEventListener('DOMContentLoaded', function() {
        document.addEventListener('input', function(event) {
            var target = event.target;
            if (target.classList.contains('numberGia') && !target.fomatDonGia) {
                target.fomatDonGia = new FomatDonGia(target);
            }else if(target.classList.contains('numberSoLuong') && !target.fomatDonGia) {
                target.fomatDonGia = new FomatDonGia(target);
            }
        });
    });

    <c:if test="${not empty alertType}">
    window.onload = function () {
        alert("${alertMessage}");
    };
    </c:if>
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.1.0-rc.0/js/select2.min.js"></script>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/blueimp-file-upload/10.12.0/js/jquery.fileupload.js"></script>--%>

<script>
    document.getElementById("myForm").addEventListener("submit", function (event) {
        var mauSacInput = document.getElementsByName("mauSac")[0];
        if (!mauSacInput) {
            event.preventDefault(); // Ngăn chặn gửi biểu mẫu
            alert("Vui lòng tạo sản phẩm!");
        }
    });

    var searchInput = document.getElementById('productAddName');
    var datalist = document.getElementById('productList');
    var options = Array.from(datalist.options);

    var showLimit = 5; // Số lượng tùy chỉnh muốn hiển thị

    searchInput.addEventListener('input', function () {
        var searchValue = searchInput.value.toLowerCase().trim();
        var matchingOptions = options.filter(function (option) {
            return option.value.toLowerCase().includes(searchValue);
        });

        var limitedOptions = matchingOptions.slice(0, showLimit);

        datalist.innerHTML = '';

        limitedOptions.forEach(function (option) {
            datalist.appendChild(option.cloneNode(true));
        });
    });

    searchInput.addEventListener('focus', function () {
        datalist.innerHTML = '';

        options.slice(0, showLimit).forEach(function (option) {
            datalist.appendChild(option.cloneNode(true));
        });
    });
</script>
<script>
    document.addEventListener('DOMContentLoaded', function() {
        var editModal = document.getElementById('editModal');
        var editButton = document.getElementById('editButton');
        var saveButton = document.getElementById('saveButton');
        var editQuantityInput = document.getElementById('editQuantity');
        var editPriceInput = document.getElementById('editPrice');

        editButton.addEventListener('click', function () {
            $(editModal).modal('show');
        });

        saveButton.addEventListener('click', function () {
            var selectedCheckboxes = document.querySelectorAll('input[name="id-check"]:checked');
            var editQuantity = editQuantityInput.value;
            var editPrice = editPriceInput.value;

            for (var i = 0; i < selectedCheckboxes.length; i++) {
                var row = selectedCheckboxes[i].parentNode.parentNode;
                var quantityInput = row.querySelector('input[name="soLuong"]');
                var priceInput = row.querySelector('input[name="donGia"]');

                quantityInput.value = editQuantity;
                priceInput.value = editPrice;
            }

            $(editModal).modal('hide');
        });
    });

</script>
</body>

</html>