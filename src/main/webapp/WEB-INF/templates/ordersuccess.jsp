<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/12/2023
  Time: 3:59 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="body py-5">
    <div class="container">
        <div class="w-50 m-auto">
            <!-- Thêm lớp "my-4" để tạo ra khoảng cách trên và dưới tiêu đề trang -->
            <h1 class="my-3 text-success text-center">Thanh toán thành công</h1>
            <!-- Sử dụng lớp "alert" và "alert-danger" để tạo ra thông báo lỗi -->
            <h2 class="my-2">Chi tiết đơn hàng</h2>
            <!-- Sử dụng lớp "table" và "table-bordered" để tạo ra bảng hiển thị thông tin chi tiết đơn hàng -->
            <table class="table table-bordered">
                <tbody>
<%--                <tr>--%>
<%--                    <td>Thông tin đơn hàng:</td>--%>
<%--                    <td><span>${orderId}</span></td>--%>
<%--                </tr>--%>
                <tr>
                    <td>Tổng tiền:</td>
                    <td><span>${totalPrice}</span></td>
                </tr>
<%--                <tr>--%>
<%--                    <td>Thời gian thanh toán:</td>--%>
<%--                    <td><span>${paymentTime}</span></td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td>Mã giao dịch:</td>--%>
<%--                    <td><span>${transactionId}</span></td>--%>
<%--                </tr>--%>
                </tbody>
            </table>
            <a href="/" class="btn btn-primary">Về trang chủ</a>
        </div>
    </div>
</div>
</body>
</html>
