$(document).ready(function() {
    $(document).on("click", ".column-click", function(event) {
        event.preventDefault();
        var productId = $(this).data("product-id");
        console.log(productId);
        $.ajax({
            url: "/product/getDetail",
            type: "GET",
            data: {id: productId},
            success: function(data) {
                $('#productDetailAll #table-body-add').empty();
                $('#productDetailAll #table-body-add').append(data);
            },
            error: function() {
                alert("Lỗi khi tải chi tiết sản phẩm.");
            }
        });
    });
});
$(document).ready(function () {
    $('.btn-detail').click(function () {
        var productId = $(this).data('product-id');
        $.ajax({
            url: "/product/productDetail",
            type: "GET",
            data: {id: productId},
            success: function (data) {
                $('#productDetailModal .modal-body').html(data);
                $('#productDetailModal').modal('show');
            },
            error: function () {
                alert("Lỗi khi tải sản phẩm.");
            }
        });
    });
});