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
                       value="${loaiGiay.id}"
                       name="id">


                <div class="input-group flex-nowrap">
                    <div class="input-group-prepend">
                                                <span class="input-group-text"><i
                                                        class="fas fa-solid fa-id-card"></i></span>
                    </div>
                    <input type="text" class="form-control" id="numericInput"
                           value="${loaiGiay.tenTheLoai}"
                           aria-label="Username" aria-describedby="addon-wrapping" name="tenTheLoai">
                </div>

                <div class="" style="padding-left: 7px;padding-top: 10px">
                    <label>Trạng thái:</label>
                    <div class="form-check-inline">
                        <input class="form-check-input" type="radio"
                               value=1 name="trangThai" required ${1==loaiGiay.trangThai?'checked':''}>
                        <label class="form-check-label">
                            Hoạt động
                        </label>
                    </div>
                    <div class="form-check-inline">
                        <input class="form-check-input" type="radio"
                               value=0 name="trangThai" required ${0==loaiGiay.trangThai?'checked':''}>
                        <label class="form-check-label">
                            Không hoạt động
                        </label>
                    </div>

                </div>
                <div class="d-flex justify-content-center">
                    <button class="btn btn-outline-primary" type="submit">Submit</button>
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
<script src="../../js/demo/modal-add.js"></script>
<script >
    // Sử dụng lớp NumericInput
</script>


</body>
</html>