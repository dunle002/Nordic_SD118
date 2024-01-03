// function Validator(options) {
//     function validate(inputElement, validationRules) {
//         const errorIcon = inputElement.parentElement.querySelector(".error-icon");
//         const errorMessage = validationRules.test(inputElement.value);
//         console.log(errorMessage);
//
//         if (errorMessage) {
//             errorIcon.setAttribute("data-original-title", errorMessage);
//             $(errorIcon).tooltip("show"); // Hiển thị tooltip
//
//             // Xóa các tooltip khác
//             const otherInputElements = Array.from(formElement.querySelectorAll(validationRules.selector)).filter(
//                 (el) => el !== inputElement
//             );
//             otherInputElements.forEach((otherInputElement) => {
//                 const otherErrorIcon = otherInputElement.parentElement.querySelector(".error-icon");
//                 $(otherErrorIcon).tooltip("hide");
//             });
//         } else {
//             errorIcon.setAttribute("data-original-title", "");
//             $(errorIcon).tooltip("hide"); // Ẩn tooltip
//         }
//     }
//
//     const formElement = document.querySelector(options.form);
//
//     if (formElement) {
//         options.validationRules.forEach(function (rules) {
//             const inputElement = formElement.querySelector(rules.selector);
//
//             if (inputElement) {
//
//                 inputElement.addEventListener("blur", function () {
//                     console.log(inputElement);
//                     validate(inputElement, rules);
//                 });
//
//                 inputElement.addEventListener("focus", function () {
//                     const errorIcon = inputElement.parentElement.querySelector(".error-icon");
//                     $(errorIcon).tooltip("hide"); // Ẩn tooltip khi người dùng tập trung vào phần tử input khác
//                 });
//             }
//         });
//     }
// }
//
// Validator.isRequired = function (selector) {
//     return {
//         selector: selector,
//         test: function (value) {
//             if (selector === "#productAddName" || selector === "#productAddDescribe") {
//                 return value.trim() ? undefined : "Vui lòng nhập trường này";
//             } else if (selector === "#productAddPrice" || selector === "#productAddQuantity") {
//                 if (isNaN(value)) {
//                     return "Vui lòng nhập số";
//                 } else if (value === "") {
//                     return "Vui lòng nhập trường này";
//                 } else if (value <= 0) {
//                     return "Vui lòng nhập số lớn hơn 0";
//                 }
//             }
//             return undefined; // Trả về undefined nếu không có lỗi
//         },
//     };
// };
// //truyền id input cần dc validate
// const validator = new Validator({
//     form: '#form-add-1',
//     validationRules: [
//         Validator.isRequired('#productAddPrice'),
//         Validator.isRequired('#productAddQuantity'),
//         Validator.isRequired('#productAddDescribe'),
//         Validator.isRequired('#productAddName')
//     ]
// });
//
//
// //js hiện tên file ảnh
// const fileInputs = document.querySelectorAll('.custom-file-input');
// const labelElements = document.querySelectorAll('.custom-file-label');
//
// fileInputs.forEach((input, index) => {
//     input.addEventListener('change', function () {
//         const fileName = input.files[0].name;
//         labelElements[index].textContent = fileName;
//     });
// });
//
//
// // Mảng lưu trữ các lựa chọn đã được chọn
// $(document).ready(function () {
//     $('#my-select').select2({
//         placeholder: 'Chọn màu sắc',
//         allowClear: true,
//     });
// });
//
// $(document).ready(function () {
//     $('#chatlieu-select').select2({
//         placeholder: 'Chọn chất liệu',
//         allowClear: true,
//     });
// });
//lấy 1 sản phẩm


var currencyInputs = document.getElementsByClassName('currency-input');
for (var i = 0; i < currencyInputs.length; i++) {
    var currencyInput = currencyInputs[i];
    var value = currencyInput.value;
    var formattedValue = new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(value);
    currencyInput.value = formattedValue.replace(/₫/g, ''); // Loại bỏ chữ 'đ'
}


// $(document).ready(function () {
//     // Bắt sự kiện submit của form
//     $('#myForm').submit(function (event) {
//         // Ngăn chặn hành vi mặc định của form
//         // event.preventDefault();
//
//         // Chuyển đổi dữ liệu trong form thành chuỗi dữ liệu định dạng URL-encoded
//         var formData = $(this).serialize();
//
//         // Gửi yêu cầu AJAX
//         $.ajax({
//             url: $(this).attr("action"),
//             type: "POST", // Sử dụng "POST" thay vì $(this).attr("POST")
//             data: formData,
//             success: function (data) {
//                 console.log(data);
//                 alert("Thêm thất bại");
//             },
//             error: function () {
//                 alert("Thêm thành công");
//             }
//         });
//     });
// });