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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/dropzone/5.9.2/min/dropzone.min.css"/>

    <!-- Các tệp JavaScript của Dropzone.js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/dropzone/5.9.2/min/dropzone.min.js"></script>
    <style>
        .image-container {
            position: relative;
            display: inline-block;
        }

        .image-container img {
            display: block;
            margin: 5px auto;
            border-radius: 1px;
            border: solid blue 2px;
        }

        .image-container .btn-primary {
            position: absolute;
            left: 50%;
            transform: translateX(-50%);
            bottom: 10px;
            width: 100px;
            height: 30px;
            text-align: center;
            background-color: blue;
            color: white;
            line-height: 30px;
            cursor: pointer;
        }
    </style>

</head>
<body>

<div class="card-body">
    <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            <input type="hidden"
                   value="${listCt.idProductDetail}"
                   name="idProductDetail">
            <input type="hidden"
                   value="${listCt.sanPham.idProduct}"
                   name="sanPham">
            <input type="hidden"
                   value="${listCt.soLuong}"
                   name="soLuong">
            <input type="hidden" name="donGia"
                   value="${listCt.donGia}">
            <div class="container" id="form-add-1">
                <div class="row">
                    <div class="col-6">
                        <div class="input-group flex-nowrap" style="padding-top: 25px">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Chất liệu</span>
                            </div>
                            <select class="form-control"
                                    name="chatLieu">
                                <option selected disabled>Chọn chất liệu</option>
                                <c:forEach var="item" items="${chatLieuList}">
                                    <option value="${item.id}" ${item.id==listCt.chatLieu.id?'selected':''}>${item.tenChatLieu}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <div class="input-group flex-nowrap">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Màu sắc</span>
                            </div>
                            <select class="form-control"
                                    name="mauSac">
                                <option selected disabled>Chọn màu sắc</option>
                                <c:forEach var="item" items="${mauSacList}">
                                    <option value="${item.id}" ${item.id==listCt.mauSac.id?'selected':''}>${item.tenMau}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="input-group flex-nowrap" style="padding-top: 25px">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Kích cỡ</span>
                            </div>
                            <select class="form-control"
                                    name="kichCo">
                                <option selected disabled>Chọn size</option>
                                <c:forEach var="item" items="${coList}">
                                    <option value="${item.id}" ${item.id==listCt.kichCo.id?'selected':''}>${item.size}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="input-group flex-nowrap" style="padding-top: 25px">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Đế giày</span>
                            </div>
                            <select class="form-control"
                                    name="deGiay">
                                <option selected disabled>Chọn đế giày</option>
                                <c:forEach var="item" items="${deGiayList}">
                                    <option value="${item.id}" ${item.id==listCt.deGiay.id?'selected':''}>${item.loaiDe}</option>
                                </c:forEach>
                            </select>
                        </div>

                    </div>

                </div>
                <div class="d-flex justify-content-center" style="padding-top: 15px;  position: relative;">

                    <c:forEach items="${listCt.image}" var="pro">
                        <div class="image-container">
                            <img src="${pro.url}" width="200px" height="200px" onclick="handleImageClick(event)">
                            <input type="file" name="fileAnh" style="display: none;"
                                   onchange="handleImageChange(event)">
                            <input type="hidden" name="idImage" value="${pro.idImages}">
                            <input type="hidden" name="imageURL" value="">
                            <a class="btn-primary" onclick="sendFormData(event)">Chỉnh sửa</a>
                        </div>
                    </c:forEach>


                </div>

                <div class="d-flex justify-content-center" style="padding-top: 20px">
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
    function handleImageChange(event) {
        var image = event.target.previousElementSibling;

        if (event.target.files && event.target.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                image.src = e.target.result;
            }

            reader.readAsDataURL(event.target.files[0]);
        }
    }

    function handleImageClick(event) {
        var fileInput = event.target.nextElementSibling;
        fileInput.click();
    }

    function sendFormData(event) {
        var container = event.target.parentNode;
        var form = container.previousElementSibling; // Lấy form bên ngoài

        var inputId = document.createElement("input");
        inputId.type = "hidden";
        inputId.name = "idImage";
        inputId.value = container.dataset.imageId; // Giá trị của thuộc tính data-image-id trong container

        var inputURL = document.createElement("input");
        inputURL.type = "hidden";
        inputURL.name = "imageURL";

        // Lấy đường dẫn và tên tệp tin từ input[type=file]
        var fileInput = container.querySelector("input[type=file]");
        var filePath = fileInput.value;
        var fileName = filePath.split("\\").pop(); // Trích xuất tên tệp tin từ đường dẫn

        // Định dạng lại giá trị của imageURL
        inputURL.value = "../../images/" + fileName;
        form.appendChild(inputId);
        form.appendChild(inputURL);
        form.submit();
    }
</script>


</body>
</html>