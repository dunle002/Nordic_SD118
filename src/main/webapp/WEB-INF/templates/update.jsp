<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Update</title>
</head>

<body>
<h1>Hello</h1>
<form:form method="post" action="/product/update/${id}" modelAttribute="product">
<%--    Id:<input type="text" name="id" value="${productUpdate.id}" readonly="true"><br>--%>
    Ma:<input type="text" name="ma" value="${productUpdate.ma}"><br>
    Ten: <input type="text" name="tenSanPham" value="${productUpdate.tenSanPham}"><br>
    Loai giay:<select name="loaiGiay">
    <c:forEach var="item" items="${loaiDay}">
        <option value="${item.id}" ${item.id==productUpdate.loaiGiay.id?'selected':''}>${item.tenTheLoai}</option>
    </c:forEach>
    </select><br>
    Anh:<input type="text" name="photo" value="${productUpdate.photo}" ><br>
    Gia:<input type="text" name="price" value="${productUpdate.price}"><br>
    Trang thai:<input type="text" name="trangThai" value="${productUpdate.trangThai}"><br>
    <br/>
    <input type="submit" value="update"> to upload the file!
</form:form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Ma</th>
        <th scope="col">Ten</th>
        <th scope="col">Loai day</th>
        <th scope="col">Anh</th>
        <th scope="col"><a href="?field=price">Gia</a></th>
        <th scope="col">Trang thai</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${product.content}" var="pro">
        <tr>
            <th>${pro.ma}</th>
            <td>${pro.tenSanPham}</td>
            <td>${pro.loaiGiay.tenTheLoai}</td>
            <td><img style="height: 100px" width="100px" src="${pro.photo}"></td>
            <td>${pro.price}</td>
            <td>${pro.trangThai}</td>
            <td><a class="btn btn-primary" href="/product/get/${pro.id}" role="button">Update</a></td>
            <td><a class="btn btn-primary" href="/product/delete/${pro.id}" role="button">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">

    <ul class="pagination">
        <li class="page-item"><a class="page-link" href="/product/crud?page=0">Fist</a></li>
        <c:forEach begin="0" end="${product.totalPages - 1}" varStatus="loop">
            <li class="page-item">
                <c:url value="/product/crud" var="pageUrl">
                    <c:param name="page" value="${loop.index}"/>
                </c:url>
                <a class="page-link" href="${pageUrl}">
                        ${loop.index + 1}
                </a>
            </li>
        </c:forEach>
        <li class="page-item"><a class="page-link" href="/product/crud?page=${product.totalPages-1}">Last</a></li>
    </ul>
</nav>


</body>
</html>