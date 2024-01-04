function Validator(options) {
    function validate(inputElement, validationRules) {
        const errorIcon = inputElement.parentElement.querySelector(".error-icon");
        const errorMessage = validationRules.test(inputElement.value);
        console.log(errorMessage);

        if (errorMessage) {
            errorIcon.setAttribute("data-original-title", errorMessage);
            $(errorIcon).tooltip("show"); // Hiển thị tooltip

            // Xóa các tooltip khác
            const otherInputElements = Array.from(formElement.querySelectorAll(validationRules.selector)).filter(
                (el) => el !== inputElement
            );
            otherInputElements.forEach((otherInputElement) => {
                const otherErrorIcon = otherInputElement.parentElement.querySelector(".error-icon");
                $(otherErrorIcon).tooltip("hide");
            });
        } else {
            errorIcon.setAttribute("data-original-title", "");
            $(errorIcon).tooltip("hide"); // Ẩn tooltip
        }
    }

    const formElement = document.querySelector(options.form);

    if (formElement) {
        options.validationRules.forEach(function (rules) {
            const inputElement = formElement.querySelector(rules.selector);

            if (inputElement) {

                inputElement.addEventListener("blur", function () {
                    console.log(inputElement);
                    validate(inputElement, rules);
                });

                inputElement.addEventListener("focus", function () {
                    const errorIcon = inputElement.parentElement.querySelector(".error-icon");
                    $(errorIcon).tooltip("hide"); // Ẩn tooltip khi người dùng tập trung vào phần tử input khác
                });
            }
        });
    }
}

Validator.isRequired = function (selector) {
    return {
        selector: selector,
        test: function (value) {
            if (selector === "#productAddName" || selector === "#productAddDescribe") {
                return value.trim() ? undefined : "Vui lòng nhập trường này";
            } else if (selector === "#productAddPrice" || selector === "#productAddQuantity") {
                if (isNaN(value)) {
                    return "Vui lòng nhập số";
                } else if (value === "") {
                    return "Vui lòng nhập trường này";
                } else if (value <= 0) {
                    return "Vui lòng nhập số lớn hơn 0";
                }
            }
            return undefined; // Trả về undefined nếu không có lỗi
        },
    };
};
//truyền id input cần dc validate
const validator = new Validator({
    form: '#form-add-1',
    validationRules: [
        Validator.isRequired('#productAddPrice'),
        Validator.isRequired('#productAddQuantity'),
        Validator.isRequired('#productAddDescribe'),
        Validator.isRequired('#productAddName')
    ]
});


//js hiện tên file ảnh
const fileInputs = document.querySelectorAll('.custom-file-input');
const labelElements = document.querySelectorAll('.custom-file-label');

fileInputs.forEach((input, index) => {
    input.addEventListener('change', function () {
        const fileName = input.files[0].name;
        labelElements[index].textContent = fileName;
    });
});


// Mảng lưu trữ các lựa chọn đã được chọn
$(document).ready(function () {
    $('#my-select').select2({
        placeholder: 'Chọn màu sắc',
        allowClear: true,
    });
});

$(document).ready(function () {
    $('#chatlieu-select').select2({
        placeholder: 'Chọn chất liệu',
        allowClear: true,
    });
});
$(document).ready(function () {
    $('#kichco-select').select2({
        placeholder: 'Chọn kích cỡ',
        allowClear: true,
    });
});
$(document).ready(function () {
    $('#loaiday-select').select2({
        placeholder: 'Chọn kích cỡ',
        allowClear: true,
    });
});
$(document).ready(function () {
    $('#degiay-select').select2({
        placeholder: 'Chọn đế giày',
        allowClear: true,
    });
});

//lấy 1 sản phẩm
$(document).ready(function () {
    $('.btn-detail').click(function () {
        var productId = $(this).data('product-detail-id');
        $.ajax({
            url: "/product/productDetail",
            type: "GET",
            data: {id: productId},
            success: function (data) {
                $('#productDetailModal .modal-body').html(data);
                $('#productDetailModal').modal('show');
            },
            error: function () {
                alert("Lỗi khi tải chi tiết sản phẩm.");
            }
        });
    });
});
//load nhiều ảnh


$(document).ready(function () {
    $(document).on('change', '.input-images', function () {
        var files = $(this)[0].files;
        var imageContainer = $(this).siblings('.imageContainer');

        if (files.length > 3) {
            alert('Vui lòng chọn không quá 3 ảnh.');
            $(this).val(''); // Xóa tất cả các tệp đã chọn
            return;
        }

        if (files.length > 0) {
            for (var i = 0; i < files.length; i++) {
                var file = files[i];
                var reader = new FileReader();

                reader.onload = function (e) {
                    var image = $('<img>').attr('src', e.target.result);
                    var deleteIcon = $('<i>').addClass('fa fa-minus-circle delete-icon');

                    var imageWrapper = $('<div>').addClass('image-wrapper');
                    imageWrapper.append(image);
                    imageWrapper.append(deleteIcon);

                    imageContainer.append(imageWrapper);
                };

                reader.readAsDataURL(file);
            }
        }
    });

    // Các sự kiện xóa ảnh không thay đổi

    $(document).on('mouseenter', '.image-wrapper', function () {
        $(this).find('.delete-icon').show();
    });

    $(document).on('mouseleave', '.image-wrapper', function () {
        $(this).find('.delete-icon').hide();
    });

    $(document).on('click', '.delete-icon', function () {
        $(this).closest('.image-wrapper').remove();
    });
});


//tạo size dựa vào màu sắc
$(document).ready(function () {
    // Biến lưu trữ danh sách các màu đã được tạo
    var createdColors = [];
    var isInputsSelected = false;

    function checkInputsSelected() {
        var productAddName = $('#productAddName').val();
        var selectedColors = $('#my-select').val();
        var selectedSizes = $('#kichco-select').val();
        var trangThaiSelected = $('input[name="trangThai"]:checked').length > 0;

        if (productAddName && selectedColors && selectedColors.length > 0 && selectedSizes && selectedSizes.length > 0 && trangThaiSelected) {
            isInputsSelected = true;
        } else {
            isInputsSelected = false;
        }
    }


    $('#my-select, #kichco-select, #productAddName,input[name="trangThai"]').change(function () {
        var selectedColors = $('#my-select').val();
        var selectedSizes = $('#kichco-select').val();
        var productAddName = $('#productAddName').val();
        var trangThaiSelected = $('input[name="trangThai"]:checked').length > 0;
        checkInputsSelected();
        $('tbody').empty();
        createdColors = [];

        if (productAddName && selectedColors && selectedColors.length > 0 && selectedSizes && selectedSizes.length > 0 && trangThaiSelected
        ) {
            var sizeCount = 0;


            for (var i = 0; i < selectedColors.length; i++) {
                var color = selectedColors[i];

                // Kiểm tra xem màu đã được tạo hay chưa

                for (var j = 0; j < selectedSizes.length; j++) {
                    var size = selectedSizes[j];

                    var trSize = createSizeTableRow(color, size);

                    $('tbody').append(trSize);
                    sizeCount++;

                }
            }
        }


    });
    // Sự kiện delegation cho click vào spanRow

    $('tbody').on('click', '.label-images', function () {
        $(this).siblings('.input-images').click();
    });


    function createSizeTableRow(color, size) {
        if (!isInputsSelected) {
            return $(); // Trả về đối tượng jQuery rỗng nếu chưa chọn xong các input
        }
        var selectedColorOption = $('#my-select option:selected').filter(function () {
            return $(this).val() === color;
        })[0];
        var selectedColorText = selectedColorOption.text;
        var inputMau = $('<input>').attr('type', 'hidden').attr('value', $('#my-select option[value="' + color + '"]:selected').val()).attr('name', 'mauSac');
        var inputDeGiay = $('<input>').attr('type', 'hidden').attr('value', $('#degiay-select option:selected').val()).attr('name', 'deGiay');
        var inputChatGiay = $('<input>').attr('type', 'hidden').attr('value', $('#chatlieu-select option:selected').val()).attr('name', 'chatLieu');
        var inputKichCo = $('<input>').attr('type', 'hidden').attr('value', $('#kichco-select option[value="' + size + '"]:selected').val()).attr('name', 'kichCo');
        var tr = $('<tr>');
        var checkbox = $('<input>').attr('type', 'checkbox');
        var productName = $('<td>').text($('#productAddName').val() + ' [' + selectedColorText + '] [' + $('#kichco-select option[value="' + size + '"]:selected').text() + ']');
        var loaiGiayCell = $('<td>').text($('#loaiday-select option:selected').text());
        var chatLieuCell = $('<td>').text($('#chatlieu-select option:selected').text());
        var deGiayCell = $('<td>').text($('#degiay-select option:selected').text());
        var sizeCell = $('<td>').text($('#kichco-select option[value="' + size + '"]:selected').text());
        var priceInput = $('<input>').attr('type', 'text').addClass('form-control').attr('value', '150000').attr('aria-label', 'Giá').attr('aria-describedby', 'addon-wrapping').attr('name', 'donGia');
        priceInput.css('width', '100px')
        var quantityInput = $('<input>').attr('type', 'text').addClass('form-control').attr('value', '10').attr('aria-label', 'Số lượng').attr('aria-describedby', 'addon-wrapping').attr('name', 'soLuong');
        quantityInput.css('width', '80px')
        var status = $('input[name="trangThai"]:checked').next('label').text();
        var deleteIcon = $('<i>').addClass('fa fa-trash').attr('aria-hidden', 'true');
        var deleteCell = $('<td>').append(deleteIcon);
        chatLieuCell.append(inputChatGiay);
        deGiayCell.append(inputDeGiay);
        productName.append(inputKichCo);
        productName.append(inputMau);
        var thImage = createImageCell();
        tr.append(
            $('<th>').append(checkbox),
            productName,
            loaiGiayCell,
            deGiayCell,
            chatLieuCell,
            $('<td>').append(priceInput),
            $('<td>').append(quantityInput),
            $('<td>').append(status),
            deleteCell,
            $('<td>').append(thImage)
        );

        return tr;
    }

    function createImageCell() {
        var inputImages = $('<input>').attr('type', 'file').attr('name', 'fileImages').addClass('input-images').attr('multiple', true).css('display', 'none');
        var labelImages = $('<label>').addClass('label-images').append($('<i>').addClass('fas fa-upload'));
        var imagesContainer = $('<div>').addClass('imageContainer');
        var imageCell = $('<a>').append(inputImages, labelImages, imagesContainer);
        return imageCell;
    }

    $('tbody').on('click', '.fa-trash', function () {
        var row = $(this).closest('tr');
        row.remove();
    });
});

