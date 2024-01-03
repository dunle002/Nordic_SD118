<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 25/12/2023
  Time: 8:32 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .custom-dropdown {
            position: relative;
            display: inline-block;
        }

        .custom-dropdown input {
            width: 200px;
            padding: 5px;
            border: 1px solid #ccc;
        }

        .custom-dropdown ul {
            position: absolute;
            top: 100%;
            left: 0;
            width: 100%;
            list-style-type: none;
            padding: 0;
            margin: 0;
            background-color: #fff;
            border: 1px solid #ccc;
            display: block;
        }

        .custom-dropdown ul li {
            padding: 5px;
            display: block;
            cursor: pointer;
        }

        .custom-dropdown ul li:hover {
            background-color: #f4f4f4;
        }

        table {
            border-collapse: collapse;
        }

        td {
            border: 1px solid black;
            padding: 5px;
        }
    </style>
    <link href="../../vendor/fontawesome-free/css/all.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="../../css/sb-admin-2.css" rel="stylesheet">

    <link href="../../vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <link href="../../vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    <link href="../../css/css/mixins/select2.css" rel="stylesheet" type="text/css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#selectA, #selectB').change(function() {
                var optionsA = $('#selectA').val();
                var optionsB = $('#selectB').val();

                $('#formContainer').empty(); // Xóa nội dung cũ

                if (optionsA && optionsB) {
                    for (var i = 0; i < optionsA.length; i++) {
                        var divA = $('<div>').text(optionsA[i]);
                        var hasChild = false; // Biến để kiểm tra xem A có phần tử B con hay không

                        for (var j = 0; j < optionsB.length; j++) {
                            var divB = $('<div>').text(optionsB[j]);

                            // Tạo trường input trong form
                            // var inputField = $('<input>').attr({
                            //     type: 'text',
                            //     name: 'data[' + optionsA[i] + '][' + optionsB[j] + ']'
                            // });
                            // divB.append(inputField);

                            // Tạo nút xóa
                            var deleteButton = $('<button>').text('Delete');
                            deleteButton.click((function(divA) {
                                return function() {
                                    $(this).parent().remove(); // Xóa phần tử B

                                    // Kiểm tra xem A còn phần tử B con hay không
                                    if (divA.find('div').length === 0) {
                                        divA.remove(); // Xóa phần tử A nếu không còn phần tử B
                                    }
                                }
                            })(divA));
                            divB.append(deleteButton);
                            hasChild = true;

                            divA.append(divB);
                        }

                        if (hasChild) {
                            $('#formContainer').append(divA);
                        }
                    }
                }
            });
        });
        function toggleDropdown() {
            var dropdown = document.querySelector(".custom-dropdown ul");
            dropdown.style.display = dropdown.style.display === "none" ? "block" : "none";
        }

        function selectValue(liElement) {
            var inputElement = liElement.parentNode.parentNode.querySelector("input");
            inputElement.value = liElement.innerText;
        }
        function filterDropdown(event) {
            var inputText = event.target.value.toLowerCase();
            var dropdownItems = document.querySelectorAll(".custom-dropdown ul li");

            dropdownItems.forEach(function(item) {
                var itemText = item.innerText.toLowerCase();
                if (itemText.indexOf(inputText) > -1) {
                    item.style.display = "block";
                } else {
                    item.style.display = "none";
                }
            });
        }

        $(document).ready(function() {
            $('#my-select, #kichco-select').change(function() {
                var selectedColors = $('#my-select').val();
                var selectedSizes = $('#kichco-select').val();
                $('.card-header h6').text('SẢN PHẨM');
                $('tbody').empty();

                if (selectedColors && selectedColors.length > 0 && selectedSizes && selectedSizes.length > 0) {
                    for (var i = 0; i < selectedColors.length; i++) {
                        var color = selectedColors[i];
                        for (var j = 0; j < selectedSizes.length; j++) {
                            var size = selectedSizes[j];
                            var tr = createTableRow(color, size);
                            $('tbody').append(tr);
                        }
                    }
                }
            });

            function createTableRow(color, size) {
                var tr = $('<tr>');
                var checkbox = $('<input>').attr('type', 'checkbox');
                var productName = $('<th>').text('Sản phẩm ' + color + ' - ' + size);
                var priceInput = $('<input>').attr('type', 'text').addClass('form-control').attr('value', '150000').attr('aria-label', 'Giá').attr('aria-describedby', 'addon-wrapping').attr('name', 'ma');
                var quantityInput = $('<input>').attr('type', 'text').addClass('form-control').attr('value', '10').attr('aria-label', 'Số lượng').attr('aria-describedby', 'addon-wrapping').attr('name', 'ma');
                var status = $('<th>').text('Trạng thái');
                var deleteIcon = $('<i>').addClass('fa fa-trash').attr('aria-hidden', 'true');
                var deleteCell = $('<th>').append(deleteIcon);
                var imageCell = $('<td>').attr('rowspan', '2').css('text-align', 'center').append(
                    $('<input>').attr('type', 'file').addClass('input-images').attr('multiple', true).css('display', 'none'),
                    $('<label>').addClass('label-images').append($('<i>').addClass('fas fa-upload')),
                    $('<div>').addClass('imageContainer')
                );

                tr.append(
                    $('<th>').append(checkbox),
                    productName,
                    priceInput,
                    quantityInput,
                    status,
                    deleteCell,
                    imageCell
                );

                return tr;
            }
        });
    </script>
</head>
<body>
<h2>Generate Form</h2>
<p>Select options for A:</p>
<select id="selectA" multiple>
    <option value="Đỏ">A1</option>
    <option value="Vàng">A2</option>
    <option value="Cam">A3</option>
</select>

<p>Select options for B:</p>
<select id="selectB" multiple>
    <option value="11">11</option>
    <option value="12">12</option>
    <option value="13">13</option>
</select>



<br/><br/>


<h2>Generated Form:</h2>
<div id="formContainer"></div>

<div class="custom-dropdown">
    <input type="text" name="selectedValue" placeholder="Chọn giá trị" onclick="toggleDropdown()" oninput="filterDropdown(event)">
    <ul>
        <li onclick="selectValue(this)">Tùy chọn 1</li>
        <li onclick="selectValue(this)">Tùy chọn 2</li>
        <li onclick="selectValue(this)">Tùy chọn 3</li>
    </ul>
</div>

<div class="card-body">
    <div class="table-responsive" id="myForm">
<form:form method="post" action="/product/add" modelAttribute="product" enctype="multipart/form-data">
        <table class="table table-bordered"  width="100%" cellspacing="0">
            <button id="submitButton" type="button">Submit</button>
        </table>
</form:form>
    </div>
</div>

<table>


<thead>
<tr>
    <th></th>
    <th>Tên sản phẩm</th>
    <th>Màu sắc</th>
    <th>Kích cỡ</th>
    <th>Giá</th>
    <th>Số lượng</th>
    <th>Trạng thái</th>
    <th rowspan="2">Ảnh</th> <!-- Chỉ có một ô thẻ ảnh cho cả hai hàng -->
</tr>
</thead>
<tbody>


<!-- ... -->
</tbody>
</table>

<div class="row" style="padding-top: 20px">
    <div class="col-md-6">
        <div class="input-group flex-nowrap">
            <div class="input-group-prepend">
                <span class="input-group-text">Màu sắc</span>
            </div>
            <select id="my-select" multiple name="mauSac"
                    class="form-control">
                <option value="Đỏ">A1</option>
                <option value="Vàng">A2</option>
                <option value="Cam">A3</option>
            </select>


        </div>
    </div>
    <div class="col-md-6">
        <div class="input-group flex-nowrap">
            <div class="input-group-prepend">
                <span class="input-group-text">Kích cỡ</span>
            </div>
            <select class="form-control" id="kichco-select" multiple
                    aria-label="Username"
                    aria-describedby="addon-wrapping"
                    name="kichCo">
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
            </select>
        </div>
    </div>
</div>
<form:form method="post" action="/add" modelAttribute="product">
<%--    phần class product--%>
    <input type="text" name="ten">
    <input type="text" name="ma">

<%--phần class detail--%>
    <select id="my-select" multiple name="mauSac"
            class="form-control">
        <option value="Đỏ">A1</option>
        <option value="Vàng">A2</option>
        <option value="Cam">A3</option>
    </select>
    <input type="text" name="maDetail">
    <input type="text" name="maDetail">
    <input type="text" name="tenDetail">
    <input type="text" name="tenDetail">
    <input type="file" name="file" multiple>
    <button type="submit">add</button>
</form:form>


</body>
</html>
