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
                    <div style="position: relative;left: 1100px; margin-top: 20px">
                        <button type="button" class="btn btn-outline-primary" data-toggle="modal"
                                data-target="#addModal"
                                style="width: 100px; height: 40px; margin-right: 10px ">
                            <i class="fas fa-duotone fa-plus"></i>
                        </button>

                    </div>


                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Mã</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Loại giày</th>
                                    <th>Màu sắc</th>
                                    <th>Kích cỡ</th>
                                    <th>Chất liệu</th>
                                    <th>Đế giày</th>
                                    <th>Ảnh nền</th>
                                    <th>Giá</th>
                                    <th>Số lượng</th>
                                    <th>Trạng thái</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>STT</th>
                                    <th>Mã</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Loại giày</th>
                                    <th>Màu sắc</th>
                                    <th>Kích cỡ</th>
                                    <th>Chất liệu</th>
                                    <th>Đế giày</th>
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
                                        <th>${i.index+1}</th>
                                        <th>${pro.sanPham.ma}</th>
                                        <td>${pro.sanPham.tenSanPham}</td>
                                        <td>${pro.sanPham.loaiGiay.tenTheLoai}</td>
                                        <td>${pro.mauSac.tenMau}</td>
                                        <td>${pro.kichCo.size}</td>
                                        <td>${pro.chatLieu.tenChatLieu}</td>
                                        <td>${pro.deGiay.loaiDe}</td>
                                        <td><img style="height: 100px" width="100px" src="${pro.photo}"></td>
                                        <td>${pro.donGia}</td>
                                        <td>${pro.soLuong}</td>
                                        <td>${pro.trangThai==1?"còn hàng":"hết hàng"}</td>
                                        <td>
                                            <div class="button-group">
                                                <a class="btn btn-outline-primary"
                                                   role="button" >
                                                    <span class="fas fa-duotone fa-wrench"></span>
                                                </a>
                                                <a class="btn btn-outline-primary"
                                                   role="button"><i class="fas fa-light fa-trash"></i></a>
                                            </div>
                                        </td>

                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <div class="modal" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header text-center">
                        <h4 class="modal-title w-100 font-weight-bold">Thêm sản phẩm</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">x</span>
                        </button>
                    </div>
                    <div class="modal-body mx-3">
                        <form:form method="post" action="/product/add" modelAttribute="product"
                                   enctype="multipart/form-data" id="form-1">
                        <div class="md-form mb-3" style="margin-top: 10px">
                            <input type="text" class="input-control" name="ma"
                                   id="productAddId" value="${maZen}" readonly>
                        </div>
                        <div class="md-form mb-3" style="margin-top: 10px">
                            <input type="text" class="input-control" placeholder="Nhập tên sản phẩm"
                                   name="tenSanPham" id="productAddName" style="border: 2px solid!important;">
                            <span class="error-message"></span>
                        </div>
                        <div class="md-form mb-3" style="margin-top: 10px">
                            <input type="text" class="input-control" placeholder="Nhập giá sản phẩm"
                                   name="price" id="productAddPrice" style="border: 2px solid!important;">
                            <span class="error-message"></span>
                        </div>

                        <div class="input-group mb-3">
                            Loại giày:<select name="loaiGiay" required>
                            <c:forEach var="item" items="${loaiDay}">
                                <option value="${item.id}">${item.tenTheLoai}</option>
                            </c:forEach>
                        </select><br>
                        </div>

                        <div class="mb-3">
                            <label for="formFileAdd" class="form-label">Chọn ảnh:</label>
                            <input class="form-control" type="file" name="file" id="formFileAdd"
                                   accept="upload/jpeg, upload/png" required>
                        </div>

                        <label>Trạng thái:</label>
                        <div class="form-check-inline">
                            <input class="form-check-input" type="radio" id="flexRadioDefault"
                                   value=1 name="trangThai" required>
                            <label class="form-check-label" for="flexRadioDefault">
                                Còn hàng
                            </label>
                        </div>
                        <div class="form-check-inline">
                            <input class="form-check-input" type="radio" id="flexRadioDefault21"
                                   value=0 name="trangThai" required>
                            <label class="form-check-label" for="flexRadioDefault21">
                                Hết hàng
                            </label>
                        </div>
                    </div>
                    <div class="modal-footer d-flex justify-content-center">
                        <button class="btn btn-outline-primary" type="submit">Thêm</button>
                    </div>
                    </form:form>
                </div>
            </div>
        </div>
<%--        Update sản phẩm--%>

        <div class="modal" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header text-center">
                        <h4 class="modal-title w-100 font-weight-bold">Cập nhật sản phẩm</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">x</span>
                        </button>
                    </div>
                    <div class="modal-body mx-3">
                        <form:form method="post" action="/product/update/${productUpdate.idProduct}" modelAttribute="product"
                                   enctype="multipart/form-data" id="form-2">
                        <div class="md-form mb-3" style="margin-top: 10px">
                            <input type="text" class="form-control" placeholder="Nhập mã sản phẩm" name="idProduct"
                                   value="${productUpdate.idProduct}" readonly>
                        </div>
                        <div class="md-form mb-3" style="margin-top: 10px">
                            <input type="text" class="input-control" placeholder="Nhập tên sản phẩm"
                                   name="tenSanPham" value="${productUpdate.tenSanPham}" id="productUpdateName">
                            <span class="error-message"></span>
                        </div>
                        <div class="md-form mb-3" style="margin-top: 10px">
                            <input type="text" class="input-control" placeholder="Nhập giá sản phẩm"
                                   name="price" value="${productUpdate.price}" id="productUpdatePrice">
                            <span class="error-message"></span>
                        </div>

                        <div class="input-group mb-3">
                            Loại giày:<select name="loaiGiay" required>
                            <c:forEach var="item" items="${loaiDay}">
                                <option value="${item.id}" ${item.id==productUpdate.loaiGiay.id?'selected':''}>${item.tenTheLoai}</option>
                            </c:forEach>
                        </select><br>
                        </div>

                        <div>
                            <label for="formFile" class="form-label">Chọn ảnh:</label>
                            <input class="form-control" type="file" name="file" id="formFile"
                                   accept="image/jpeg, image/png">
                            <input type="hidden" id="fileData" name="fileData" value="${productUpdate.photo}"/>

                            <div class="image-input-wrapper">
                                <img src="${productUpdate.photo}" alt="Ảnh sản phẩm" width="200">
                            </div>

                        </div>

                        <label>Trạng thái:</label>
                        <div class="form-check-inline">
                            <input class="form-check-input" type="radio" id="flexRadioDefault1"
                                   value="1" name="trangThai"
                                   required ${productUpdate.trangThai == '1' ? 'checked' : ''}>
                            <label class="form-check-label" for="flexRadioDefault1">
                                Còn hàng
                            </label>
                        </div>
                        <div class="form-check-inline">
                            <input class="form-check-input" type="radio" id="flexRadioDefault2"
                                   value="0" name="trangThai" ${productUpdate.trangThai == '0' ? 'checked' : ''}>
                            <label class="form-check-label" for="flexRadioDefault2">
                                Hết hàng
                            </label>
                        </div>
                    </div>
                    <div class="modal-footer d-flex justify-content-center">
                        <button class="btn btn-outline-primary" type="submit">Cập nhật</button>
                    </div>
                    </form:form>
                </div>
            </div>
        </div>
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
<script src="../../js/custom-js.js"></script>
<script>
    Validator({
        form: '#form-1',
        rules: [
            Validator.isRequired('#productAddPrice'),
            Validator.isRequired('#productAddName')
        ]

    });
    Validator({
        form: '#form-2',
        rules: [
            Validator.isRequired('#productUpdatePrice'),
            Validator.isRequired('#productUpdateName')
        ]

    })
</script>

</body>

</html>