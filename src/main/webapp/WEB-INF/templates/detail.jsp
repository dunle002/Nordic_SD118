<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
          integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

</head>
<style>
    * {
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }
    .container {
        display: flex;
        flex-wrap: wrap;
    }

    body {
        font-family: sans-serif;

    }

    .container {
        max-width: 75%;
        margin: auto;
        height: 80vh;
        margin-top: 5%;
        background: white;
        box-shadow: 5px 5px 10px 3px rgba(0, 0, 0, 0.3);
    }
    /*.back-button {*/
    /*    padding: 10px 15px;*/
    /*    background-color: #007bff;*/
    /*    color: #fff;*/
    /*    text-decoration: none;*/
    /*    border: none;*/
    /*    cursor: pointer;*/
    /*    border-radius: 5px;*/
    /*    width: 70px;*/
    /*    height:50px;*/
    /*}*/

    .left, .right {
        width: 50%;
        padding: 30px;
    }

    .flex {
        display: flex;
        justify-content: space-between;
    }

    .flex1 {
        display: flex;
    }

    .main_image {
        width: auto;
        height: auto;
    }

    .option img {
        width: 75px;
        height: 75px;
        padding: 10px;
    }

    .right {
        padding: 50px 100px 50px 50px;
    }

    h3 {
        color: #af827d;
        margin: 20px 0 20px 0;
        font-size: 25px;
    }

    h5,
    p,
    small {
        color: #837D7C;
    }

    h4 {
        color: red;
    }

    p {
        margin: 20px 0 50px 0;
        line-height: 25px;
    }

    h5 {
        font-size: 15px;
    }

    label,
    .add span,
    .color span {
        width: 25px;
        height: 25px;
        background: #000;
        border-radius: 50%;
        margin: 20px 10px 20px 0;
    }

    .color span:nth-child(2) {
        background: #EDEDED;
    }

    .color span:nth-child(3) {
        background: #D5D6D8;
    }

    .color span:nth-child(4) {
        background: #EFE0DE;
    }

    .color span:nth-child(5) {
        background: #AB8ED1;
    }

    .color span:nth-child(6) {
        background: #F04D44;
    }

    .add label,
    .add span {
        background: none;
        border: 1px solid #C1908B;
        color: #C1908B;
        text-align: center;
        line-height: 25px;
    }

    .add label {
        padding: 10px 30px 0 20px;
        border-radius: 50px;
        line-height: 0;
    }

    button {
        width: 100%;
        padding: 10px;
        border: none;
        outline: none;
        background: #C1908B;
        color: white;
        margin-top: 20%;
        border-radius: 30px;
    }

    @media only screen and (max-width: 768px) {
        .container {
            max-width: 90%;
            margin: auto;
            height: auto;
        }

        .left, .right {
            width: 100%;
        }

        .container {
            flex-direction: column;
        }
    }

    @media only screen and (max-width: 511px) {
        .container {
            max-width: 100%;
            height: auto;
            padding: 10px;
        }

        .left, .right {
            padding: 0;
        }

        .option {
            display: flex;
            flex-wrap: wrap;
        }
    }
</style>
<body>
<section>


    <div class="container flex">
        <div class="left">
            <div class="main_image">
                <img src="${spt.hinhAnh}" class="slide" style="width: 600px;height:650px">
            </div>
        </div>
        <div class="right" style="margin-top: -150px">
            <button onclick="goBack()" class="back-button" style="width: 50px;margin-left: -10px"> <i style='font-size:24px' class='fas'>&#xf060;</i></button>

            <script>
                function goBack() {
                    window.history.back();
                }
            </script>
            <h3>${spt.sanPham.tenSanPham}</h3>
            <h4 style="font-size: larger">
                <small style="font-size: larger">Price:</small>
                ${spt.donGia}
            </h4>


            <p>${spt.moTa}</p>
            <h5>Color-Product:</h5>
            <div class="color flex1">
                <p>${spt.mauSac.tenMau}</p>
            </div>
            <h5>Size:</h5>
            <p>${spt.kichCo.kichCo}</p>
            <h5>Number</h5>
            <div class="add flex1">
                <span>-</span>
                <label>1</label>
                <span>+</span>
            </div>

            <button style="margin-top: -50px">Add to Cart</button>
        </div>
    </div>
</section>
<script>
    function img(anything) {
        document.querySelector('.slide').src = anything;
    }

    function change(change) {
        const line = document.querySelector('.home');
        line.style.background = change;
    }

    <button onclick="goBack()" class="back-button">Back</button>

    <script>
        function goBack() {
        window.history.back();
    }
</script>

</script>
</body>

</html>