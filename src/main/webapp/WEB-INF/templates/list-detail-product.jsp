<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Load Product to Modal</title>
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
<body>

<div class="table-responsive">
    <table class="table table-bordered" id="dataTable1" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th>STT</th>
            <th>Đơn giá</th>
            <th>Số lượng</th>
            <th>Màu sắc</th>
            <th>Kích cỡ</th>
            <th>Chất liệu</th>
            <th>Đế giày</th>
            <th>Action</th>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <th>STT</th>
            <th>Đơn giá</th>
            <th>Số lượng</th>
            <th>Màu sắc</th>
            <th>Kích cỡ</th>
            <th>Chất liệu</th>
            <th>Đế giày</th>
            <th>Action</th>
        </tr>
        </tfoot>
        <tbody>
        <c:forEach items="${productct.children}" var="pro" varStatus="i">
            <tr>
                <th>${i.index+1}</th>
                <th>${pro.donGia}</th>
                <td>${pro.soLuong}</td>
                <td>${pro.mauSac.tenMau}</td>
                <td>${pro.kichCo.size}</td>
                <td>${pro.chatLieu.tenChatLieu}</td>
                <td>${pro.deGiay.loaiDe}</td>
                <td>
                    <a class="btn btn-primary"
                       >
                        <i class="fa fa-wrench" aria-hidden="true"></i>
                    </a>
                </td>

            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>


<script src="../../vendor/jquery/jquery.min.js"></script>
<script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="../../vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="../../js/sb-admin-2.js"></script>


<script src="../../vendor/datatables/jquery.dataTables.min.js"></script>
<script src="../../vendor/datatables/dataTables.bootstrap4.min.js"></script>


<script>
    $(document).ready(function () {
        $('#dataTable1').DataTable();
    });
</script>

<!-- Custom scripts for all pages-->
<%--<script src="../../js/custom-js.js"></script>--%>


</body>
</html>