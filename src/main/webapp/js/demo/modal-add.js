$(document).ready(function() {
    $(document).on("click", "#id-kich-co", function(event) {
        event.preventDefault();
        $.ajax({
            url: "/kich-co/view",
            type: "GET",
            success: function(data) {
                $('#kichCoModal .modal-body').html(data);
                $('#kichCoModal').modal('show');
            },
            error: function() {
                alert("Lỗi khi tải kích cỡ.");
            }
        });
    });
});
$(document).ready(function() {
    $(document).on("click", "#id-chat-lieu", function(event) {
        event.preventDefault();
        $.ajax({
            url: "/chat-lieu/view",
            type: "GET",
            success: function(data) {
                $('#chatLieuModal .modal-body').html(data);
                $('#chatLieuModal').modal('show');
            },
            error: function() {
                alert("Lỗi khi tải chất liệu.");
            }
        });
    });
});
$(document).ready(function() {
    $(document).on("click", "#id-mau-sac", function(event) {
        event.preventDefault();
        $.ajax({
            url: "/mau-sac/view",
            type: "GET",
            success: function(data) {
                $('#mauSacModal .modal-body').html(data);
                $('#mauSacModal').modal('show');
            },
            error: function() {
                alert("Lỗi khi tải màu sắc.");
            }
        });
    });
});
//Đée giày
$(document).ready(function() {
    $(document).on("click", "#id-de-giay", function(event) {
        event.preventDefault();
        $.ajax({
            url: "/de-giay/view",
            type: "GET",
            success: function(data) {
                $('#deGiayModal .modal-body').html(data);
                $('#deGiayModal').modal('show');
            },
            error: function() {
                alert("Lỗi khi tải đế giày.");
            }
        });
    });
});
// Loại giày
$(document).ready(function() {
    $(document).on("click", "#id-loai-giay", function(event) {
        event.preventDefault();
        $.ajax({
            url: "/loai-giay/view",
            type: "GET",
            success: function(data) {
                $('#loaiDayModal .modal-body').html(data);
                $('#loaiDayModal').modal('show');
            },
            error: function() {
                alert("Lỗi khi tải loại giày.");
            }
        });
    });
});
// nsx
$(document).ready(function() {
    $(document).on("click", "#id-thuong-hieu", function(event) {
        event.preventDefault();
        $.ajax({
            url: "/thuong-hieu/view",
            type: "GET",
            success: function(data) {
                $('#thuongHieuModal .modal-body').html(data);
                $('#thuongHieuModal').modal('show');
            },
            error: function() {
                alert("Lỗi khi tải thương hiệu.");
            }
        });
    });
});
class NumericInput {
    constructor(inputElement) {
        this.inputElement = inputElement;
        this.maxLength = 2;

        this.inputElement.addEventListener('input', this.handleInput.bind(this));
        this.inputElement.addEventListener('keydown', this.handleKeydown.bind(this));
    }

    handleInput(event) {
        var value = event.target.value;
        var sanitizedValue = value.replace(/[^0-9]/g, '');
        var truncatedValue = sanitizedValue.slice(0, this.maxLength);
        event.target.value = truncatedValue;
    }

    handleKeydown(event) {
        var valueLength = event.target.value.length;
        var isBackspaceOrDelete = (event.key === 'Backspace' || event.key === 'Delete');

        if (valueLength >= this.maxLength && !isBackspaceOrDelete) {
            event.preventDefault();
        }
    }
}