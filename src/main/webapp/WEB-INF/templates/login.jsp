<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login </title>
    <link rel="icon" href="../../assets1/images/create_logo_with_content_Nordic_Shoes_and_back.jpg" type="image/jpeg">
    <link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../assets1/css/login.css">
</head>
<body>
<main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
    <div class="container">
        <div class="card login-card">
            <div class="row no-gutters">
                <div class="col-md-5">
                    <img src="../../assets1/images/logo.jpg" alt="login" class="login-card-img">
                </div>
                <div class="col-md-7">
                    <div class="card-body">
                        <div class="brand-wrapper">
                           <p style="font-size: 300%;font-weight: bold">Nordic</p>
                        </div>
                        <p class="login-card-description">Login Page</p>
                        <form action="userLogin" method="post">
                            <div class="form-group">
                                <input type="email" name="email"  class="form-control" placeholder="Email address">
                            </div>
                            <div class="form-group mb-4">
                                <input type="password" name="passWord"  class="form-control" placeholder="***********">
                            </div>
                            <button class="btn btn-black col-md-12" style="background-color: black;color: white">Login</button>
                        </form>
                        <p class="login-card-footer-text" style="margin-top: 20px">Don't have an account? <a href="/register" class="text-reset">Register here</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>
