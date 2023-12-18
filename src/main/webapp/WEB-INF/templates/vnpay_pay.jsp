<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Tạo mới đơn hàng</title>
    <!-- Bootstrap core CSS -->
    <link href="/vnpay_jsp/assets/bootstrap.min.css" rel="stylesheet"/>
    <!-- Custom styles for this template -->
    <link href="/vnpay_jsp/assets/jumbotron-narrow.css" rel="stylesheet">
    <script src="/vnpay_jsp/assets/jquery-1.11.3.min.js"></script>
<%--    <style><%@include file="jumbotron-narrow.css"%></style>--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
</head>

<body>

<div class="container">
    <div class="header clearfix">

        <h3 class="text-muted">VNPAY DEMO</h3>
    </div>
    <h3>Tạo mới đơn hàng</h3>
    <div class="table-responsive">
        <form id="frmCreateOrder" method="get">
            <div class="form-group">
                <label for="amount">Số tiền</label>
                <input class="form-control" data-val="true" data-val-number="The field Amount must be a number." data-val-required="The Amount field is required." id="amount" max="100000000" min="1" name="amount" type="number" value="10000" />
            </div>
            <h4>Chọn phương thức thanh toán</h4>
            <div class="form-group">
                <h5>Cách 1: Chuyển hướng sang Cổng VNPAY chọn phương thức thanh toán</h5>
                <input type="radio" Checked="True" id="bankCode" name="bankCode" value="">
                <label for="bankCode">Cổng thanh toán VNPAYQR</label><br>

                <h5>Cách 2: Tách phương thức tại site của đơn vị kết nối</h5>
                <input type="radio" id="bankCode" name="bankCode" value="VNPAYQR">
                <label for="bankCode">Thanh toán bằng ứng dụng hỗ trợ VNPAYQR</label><br>

                <input type="radio" id="bankCode" name="bankCode" value="VNBANK">
                <label for="bankCode">Thanh toán qua thẻ ATM/Tài khoản nội địa</label><br>

                <input type="radio" id="bankCode" name="bankCode" value="INTCARD">
                <label for="bankCode">Thanh toán qua thẻ quốc tế</label><br>

            </div>
            <div class="form-group">
                <h5>Chọn ngôn ngữ giao diện thanh toán:</h5>
                <input type="radio" id="language" Checked="True" name="language" value="vn">
                <label for="language">Tiếng việt</label><br>
                <input type="radio" id="language" name="language" value="en">
                <label for="language">Tiếng anh</label><br>

            </div>
            <a class="btn btn-default" href="${url}">Thanh toán</a>
        </form>
    </div>
    <p>
        &nbsp;
    </p>
    <footer class="footer">
        <p>&copy; VNPAY 2020</p>
    </footer>
</div>

<link href="https://pay.vnpay.vn/lib/vnpay/vnpay.css" rel="stylesheet" />
<script src="https://pay.vnpay.vn/lib/vnpay/vnpay.min.js"></script>
<script type="text/javascript">
    $("#frmCreateOrder").submit(function () {
        var postData = $("#frmCreateOrder").serialize();
        var submitUrl = $("#frmCreateOrder").attr("action");
        $.ajax({
            type: "POST",
            url: submitUrl,
            data: postData,
            dataType: 'JSON',
            success: function (x) {
                if (x.code === '00') {
                    if (window.vnpay) {
                        vnpay.open({width: 768, height: 600, url: x.data});
                    } else {
                        location.href = x.data;
                    }
                    return false;
                } else {
                    alert(x.Message);
                }
            }
        });
        return false;
    });
</script>
</body>
</html>