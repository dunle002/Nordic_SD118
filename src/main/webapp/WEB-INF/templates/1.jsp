<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <title>Your Website</title>
</head>
<body>


<header>
    <%@include file="header.jsp" %>
    <!-- Navigation Menu, Logo, etc. -->
</header>

<main>
    <section class="content">
        <c:forEach items="${sp}" var="sp">
            <div class="card" style="width: 8rem;height: 10px">
                <img style="height: 150px" src="${sp.photo}" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">${sp.tenSanPham}</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the
                        card's
                        content.</p>
                    <a href="#" class="btn btn-primary">Go somewhere</a>
                </div>
            </div>
            <%--        <div>--%>
            <%--            <a>${sp.tenSanPham}</a>--%>
            <%--            <img src="${sp.photo}"/>--%>
            <%--        </div>--%>
        </c:forEach>
    </section>
</main>

<footer>
    <%@include file="footer.jsp" %>
</footer>

</body>
</html>
