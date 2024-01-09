<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<form:form action="/detail/chi-tiet/update-gia" method="post">
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <button class="btn-primary" type="submit"
                style="width: 100px; height: 40px; float: right; border-radius: 1px; display: flex; align-items: center; margin-left: 10px">
            <span style="text-align: center; margin-left: 5px">Chỉnh sửa</span>
        </button>
        <a class="btn-primary" id="editButton"
           style="width: 240px; height: 40px; float: right; border-radius: 1px; display: flex; align-items: center;">
            <span style="text-align: center; margin-left: 5px">Chỉnh sửa số lượng và giá chung</span>
        </a>

        <h6 class="m-0 font-weight-bold text-primary">Chi tiết sản phẩm</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">

            <table class="table table-bordered" id="dataTable1" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th></th>
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
                    <th></th>
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
                <c:forEach items="${productct}" var="pro" varStatus="i">
                    <tr>
                        <th><input type="checkbox" name="id-check" value="${pro.idProductDetail}"></th>
                        <th>${i.index+1}</th>
                        <th><input type="text" name="donGia"
                                   value="<fmt:formatNumber value='${pro.donGia}' pattern='#,###' />"/></th>
                        <td><input type="text" name="soLuong"
                                   value="<fmt:formatNumber value='${pro.soLuong}' pattern='#,###' />"/></td>
                        <td>${pro.mauSac.tenMau}</td>
                        <td>${pro.kichCo.size}</td>
                        <td>${pro.chatLieu.tenChatLieu}</td>
                        <td>${pro.deGiay.loaiDe}</td>
                        <td>
                            <a class="btn btn-primary btn-chi-tiet"  data-product-id="${pro.idProductDetail}"
                            >
                                <i class="fa fa-wrench" aria-hidden="true"></i>
                            </a>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>


    </div>
</div>
<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
     aria-labelledby="productDetailModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document" style="max-width: 50%;
                                            margin: 0 auto;">
        <div class="modal-content" style="width: 100%">
            <div class="modal-header">
                <h5 class="modal-title" id="productDetailModalLabel">Chỉnh sửa số lượng và giá chung</h5>
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
</form:form>

<div class="modal fade" id="chiTietSpModal" tabindex="-1" role="dialog"
     aria-labelledby="productDetailModalLabel" aria-hidden="true"

>
    <div class="modal-dialog" role="document" style="max-width: 50%;
                                            margin: 0 auto;">
        <div class="modal-content" style="width: 100%">
            <div class="modal-header">
                <h5 class="modal-title">Chi Tiết Sản Phẩm</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form:form method="post" action="/detail/chi-tiet/update" modelAttribute="chiTietUpdate"
                       enctype="multipart/form-data">
                <div class="modal-body" style="width: 100%">

                </div>
            </form:form>
        </div>
    </div>
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
    <c:if test="${not empty alertType}">
    window.onload = function () {
        alert("${alertMessage}");
    };
    </c:if>


    $(document).ready(function () {
        $('#dataTable1').DataTable();
    });

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
    $(document).ready(function () {
        $(document).on("click", ".btn-chi-tiet", function(event) {
            event.preventDefault();
            var productId = $(this).data('product-id');
            $.ajax({
                url: "/detail/detai-update/view",
                type: "GET",
                data: {id: productId},
                success: function (data) {
                    $('#chiTietSpModal .modal-body').html(data);
                    $('#chiTietSpModal').modal('show');
                },
                error: function () {
                    alert("Lỗi khi tải sản phẩm.");
                }
            });
        });
    });
</script>

<!-- Custom scripts for all pages-->
<%--<script src="../../js/custom-js.js"></script>--%>


</body>
</html>