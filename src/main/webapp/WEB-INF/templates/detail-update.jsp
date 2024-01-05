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

<div class="card-body">
    <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

            <div class="container" id="form-add-1">
                <input type="hidden"
                       value="${productct.idProduct}"
                       name="idProduct">
                <div class="row">
                    <div class="col-6">
                        <div class="input-group flex-nowrap">
                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i
                                                        class="fas fa-solid fa-id-card"></i></span>
                            </div>
                            <input type="text" class="form-control"
                                   value="${productct.ma}"
                                   aria-label="Username" aria-describedby="addon-wrapping" name="ma" readonly>
                        </div>
                        <br>
                        <div class="input-group flex-nowrap">
                            <div class="input-group-prepend">
                                                    <span class="input-group-text"><i
                                                            class="fas fa-solid fa-file-signature"></i></span>
                            </div>

                            <input type="text" class="form-control"
                                   placeholder="Nhập tên sản phẩm"
                                   aria-label="Username" aria-describedby="addon-wrapping" name="tenSanPham"
                                   id="productAddName" value="${productct.tenSanPham}">

                            <span class="error-icon" data-toggle="tooltip" data-placement="right" title=""></span>
                        </div>
                        <br>


                    </div>
                    <div class="col-6">

                        <div class="input-group flex-nowrap">
                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i
                                                        class="fas fa-solid fa-id-card"></i></span>
                            </div>
                            <select class="form-control"
                                    name="loaiGiay">
                                <option selected disabled>Chọn loại giày</option>
                                <c:forEach var="item" items="${listLoai}">
                                    <option value="${item.id}" ${item.id==productct.loaiGiay.id?'selected':''}>${item.tenTheLoai}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="input-group flex-nowrap" style="padding-top: 25px">
                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i
                                                        class="fas fa-solid fa-id-card"></i></span>
                            </div>
                            <select class="form-control"
                                    name="thuongHieu">
                                <option selected disabled>Chọn thương hiệu</option>
                                <c:forEach var="item" items="${listThuongHieu}">
                                    <option value="${item.id}" ${item.id==productct.thuongHieu.id?'selected':''}>${item.tenThuongHieu}</option>
                                </c:forEach>
                            </select>
                        </div>


                        </div>

                        <div class="input-group col-12" style="padding-bottom: 10px; width: 100%">
                            <div class="input-group-prepend">
                                                    <span class="input-group-text"
                                                    ><i class="fas fa-solid fa-upload"></i></span>
                            </div>
                            <div class="custom-file">
                                <input type="file" class="custom-file-input"
                                       aria-describedby="inputGroupFileAddon01" name="image3" id="imageNumber2">
                                <label class="custom-file-label" for="imageNumber2">Chọn ảnh</label>
                                <input type="hidden"
                                       value="${productct.imgMain}"
                                       name="fileData" readonly>
                            </div>

                        </div>

                    <div class="input-group col-12">
                        <div class="input-group-prepend">
                            <span class="input-group-text">Mô tả sản phẩm</span>
                        </div>
                        <textarea class="form-control" aria-label="With textarea" name="moTa"
                                  id="productAddDescribe">${productct.moTa}</textarea>
                        <span class="error-icon" data-toggle="tooltip" data-placement="right"
                              title=""></span>

                    </div>
                    <div style="padding-left: 7px;padding-top: 10px">
                        <label>Trạng thái:</label>
                        <div class="form-check-inline">
                            <input class="form-check-input" type="radio"
                                   value=1 name="trangThai" required ${1==productct.trangThai?'checked':''}>
                            <label class="form-check-label">
                                Hiển thị
                            </label>
                        </div>
                        <div class="form-check-inline">
                            <input class="form-check-input" type="radio"
                                   value=0 name="trangThai" required ${0==productct.trangThai?'checked':''}>
                            <label class="form-check-label">
                                Không hiển thị
                            </label>
                        </div>

                    </div>

                </div>
                <div class="d-flex justify-content-center">
                    <button class="btn btn-outline-primary" type="submit">Sửa</button>
                </div>
            </div>

        </table>
    </div>
</div>


<script src="../../vendor/jquery/jquery.min.js"></script>
<script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="../../vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<%--<script src="../../js/custom-js.js"></script>--%>
<script>
    // const fileInputs = document.querySelectorAll('.custom-file-input');
    // const labelElements = document.querySelectorAll('.custom-file-label');
    //
    // fileInputs.forEach((input, index) => {
    //     input.addEventListener('change', function () {
    //         const fileName = input.files[0].name;
    //         labelElements[index].textContent = fileName;
    //     });
    // });

    // $(document).ready(function () {
    //     // Bắt sự kiện submit của form
    //     $('#myForm').submit(function (event) {
    //         console.log(event);
    //         // Ngăn chặn hành vi mặc định của form
    //         event.preventDefault();
    //
    //         // Chuyển đổi dữ liệu trong form thành chuỗi dữ liệu định dạng URL-encoded
    //         var formData = $(this).serialize();
    //
    //         // Gửi yêu cầu AJAX sử dụng $.post()
    //         $.post($(this).attr("action"), formData)
    //             .done(function (data) {
    //                 console.log(data);
    //                 alert("Thêm thất bại");
    //             })
    //             .fail(function () {
    //                 alert("Thêm thành công");
    //             });
    //     });
    // });
</script>


</body>
</html>