<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <title>Your Website</title>

    <style>
        .error-message {
            display: block;
            margin-top: 5px;
        }
    </style>
</head>
<body>
<form:form method="post" action="/product-detail/add" modelAttribute="productDetail">

<div class="input-group mb-3">
    Sản phẩm:<select name="sanPham">
    <c:forEach var="item" items="${danhSach.sanPham}">
        <option value="${item.id}"> ${item.tenSanPham} </option>
    </c:forEach>
</select><br>

    <div class="input-group mb-3">
        Màu sắc:<select name="mauSac">
        <c:forEach var="item" items="${danhSach.mauSac}">
            <option value="${item.id}"> ${item.tenMau} </option>
        </c:forEach>
    </select><br>

        <div class="input-group mb-3">
            Kích cỡ:<select name="kichCo">
            <c:forEach var="item" items="${danhSach.kichCo}">
                <option value="${item.id}"> ${item.size} </option>
            </c:forEach>
        </select><br>

            <div class="input-group mb-3">
                Chất liệu:<select name="chatLieu">
                <c:forEach var="item" items="${danhSach.chatLieu}">
                    <option value="${item.id}"> ${item.tenChatLieu} </option>
                </c:forEach>
            </select><br>

                <div class="input-group mb-3">
                    Đế:<select name="deGiay">
                    <c:forEach var="item" items="${danhSach.deGiay}">
                        <option value="${item.id}"> ${item.loaiDe} </option>
                    </c:forEach>
                </select><br>

                    <div class="input-group mb-3">
                        Giá:<input type="text" name="donGia">
                        <c:if test="${not empty errors.donGia}">
                            <span class="text-danger error-message">Không duoc de trong</span>
                        </c:if>
                    </div>

                    <div class="input-group mb-3">
                        Số lượng: <input type="text" name="soLuong"><br>
                        <c:if test="${not empty errors.soLuong}">
                            <span class="text-danger error-message">Khong duoc de trong</span>
                        </c:if>
                    </div>


<%--                    <div class="input-group mb-3">--%>
<%--                        Ảnh:<input type="text" name="photo"><br>--%>
<%--                        <c:if test="${not empty errors.photo}">--%>
<%--                            <span class="text-danger error-message">Khong duoc de trong</span>--%>
<%--                        </c:if>--%>
<%--                    </div>--%>

                    <div class="input-group mb-3">
                        Mô tả:<input type="text" name="moTa"><br>
                        <c:if test="${not empty errors.moTa}">
                            <span class="text-danger error-message">Khong duoc de trong</span>
                        </c:if>
                    </div>
                    <div class="input-group mb-3">
                        Trạng thái:<input type="text" name="trangThai"><br>
                        <c:if test="${not empty errors.trangThai}">
                            <span class="text-danger error-message">Khong duoc de trong</span>
                        </c:if>
                    </div>
                    <br/>

                    <input type="submit"> to upload the file!
                    </form:form>

                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Tên sản phẩm</th>
                            <th scope="col">Màu sắc</th>
                            <th scope="col">Kích cỡ</th>
                            <th scope="col">Chất liệu</th>
                            <th scope="col">Đế</th>
                            <th scope="col"><a href="?field=donGia">Gia</a></th>
                            <th scope="col">Số lượng</th>
                            <th scope="col">Ảnh</th>
                            <th scope="col">Mô tả</th>
                            <th scope="col">Trạng thái</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${product.content}" var="pro">
                            <tr>
                                <th>${pro.sanPham.tenSanPham}</th>
                                <td>${pro.mauSac.tenMau}</td>
                                <td>${pro.kichCo.size}</td>
                                <td>${pro.chatLieu.tenChatLieu}</td>
                                <td>${pro.deGiay.loaiDe}</td>
                                <td>${pro.donGia}</td>
                                <td>${pro.soLuong}</td>
                                <td><img style="height: 100px" width="100px" src="${pro.sanPham.photo}"></td>
                                <td>${pro.moTa}</td>
                                <td>${pro.trangThai==0?'hết hàng':'còn hàng'}</td>

                                <td><a class="btn btn-primary" href="/product-detail/get/${pro.id}" role="button">Update</a>
                                </td>
                                <td><a class="btn btn-primary" href="/product-detail/delete/${pro.id}" role="button">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item"><a class="page-link" href="/product/crud?page=0">Fist</a></li>
                            <c:forEach begin="0" end="${product.totalPages - 1}" varStatus="loop">
                                <li class="page-item">
                                    <c:url value="/product-detail/view" var="pageUrl">
                                        <c:param name="page" value="${loop.index}"/>
                                    </c:url>
                                    <a class="page-link" href="${pageUrl}">
                                            ${loop.index + 1}
                                    </a>
                                </li>
                            </c:forEach>
                            <li class="page-item"><a class="page-link"
                                                     href="/product/crud?page=${product.totalPages-1}">Last</a></li>
                        </ul>

                    </nav>


</body>
</html>