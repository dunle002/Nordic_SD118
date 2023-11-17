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
    <title>Document</title>
</head>

<body>
<h1>Hello</h1>
<form:form method="post" action="/product/update" modelAttribute="product1">
    Ma:<input type="text" name="ma" value="${productUpdate.ma}"><br>
    Ten: <input type="text" name="tenSanPham" value="${productUpdate.tenSanPham}"><br>
    Loai giay:<select name="loaiGiay">
    <c:forEach var="item" items="${loaiDay}">
        <option value="${item.id}"><c:out value="${item.tenTheLoai}"/></option>
    </c:forEach>
    </select><br>
    Anh:<input type="text" name="photo" value="${productUpdate.photo}"><br>
    Gia:<input type="text" name="price" value="${productUpdate.price}"><br>
    Trang thai:<input type="text" name="trangThai" value="${productUpdate.trangThai}"><br>
    <br/>
    <input type="submit"> to upload the file!
</form:form>



</body>
</html>