$(document).ready(function () {
    $('.btn-kich-co').click(function () {
        var productId = $(this).data('product-kich-co-id');
        console.log(productId);
        $.ajax({
            url: "/kich-co/view-update",
            type: "GET",
            data: {id: productId},
            success: function (data) {
                $('#kichCoModal .modal-body').html(data);
                $('#kichCoModal').modal('show');
            },
            error: function () {
                alert("Lỗi khi tải thuộc tính.");
            }
        });
    });
});
$(document).ready(function () {
    $('.btn-mau-sac').click(function () {
        var productId = $(this).data('product-id');
        console.log(productId);
        $.ajax({
            url: "/mau-sac/view-update",
            type: "GET",
            data: {id: productId},
            success: function (data) {
                $('#mauSacModal .modal-body').html(data);
                $('#mauSacModal').modal('show');
            },
            error: function () {
                alert("Lỗi khi tải thuộc tính.");
            }
        });
    });
});
$(document).ready(function () {
    $('.btn-thuong-hieu').click(function () {
        var productId = $(this).data('product-id');
        console.log(productId);
        $.ajax({
            url: "/thuong-hieu/view-update",
            type: "GET",
            data: {id: productId},
            success: function (data) {
                $('#thuongHieuModal .modal-body').html(data);
                $('#thuongHieuModal').modal('show');
            },
            error: function () {
                alert("Lỗi khi tải thuộc tính.");
            }
        });
    });
});
$(document).ready(function () {
    $('.btn-chat-lieu').click(function () {
        var productId = $(this).data('product-id');
        console.log(productId);
        $.ajax({
            url: "/chat-lieu/view-update",
            type: "GET",
            data: {id: productId},
            success: function (data) {
                $('#chatLieuModal .modal-body').html(data);
                $('#chatLieuModal').modal('show');
            },
            error: function () {
                alert("Lỗi khi tải thuộc tính.");
            }
        });
    });
});
$(document).ready(function () {
    $('.btn-de-giay').click(function () {
        var productId = $(this).data('product-id');
        console.log(productId);
        $.ajax({
            url: "/de-giay/view-update",
            type: "GET",
            data: {id: productId},
            success: function (data) {
                $('#deGiayModal .modal-body').html(data);
                $('#deGiayModal').modal('show');
            },
            error: function () {
                alert("Lỗi khi tải thuộc tính.");
            }
        });
    });
});
$(document).ready(function () {
    $('.btn-loai-giay').click(function () {
        var productId = $(this).data('product-id');
        console.log(productId);
        $.ajax({
            url: "/loai-giay/view-update",
            type: "GET",
            data: {id: productId},
            success: function (data) {
                $('#loaiDayModal .modal-body').html(data);
                $('#loaiDayModal').modal('show');
            },
            error: function () {
                alert("Lỗi khi tải thuộc tính.");
            }
        });
    });
});