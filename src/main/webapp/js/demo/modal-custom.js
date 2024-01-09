
var currencyInputs = document.getElementsByClassName('currency-input');
for (var i = 0; i < currencyInputs.length; i++) {
    var currencyInput = currencyInputs[i];
    var value = currencyInput.value;
    var formattedValue = new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(value);
    currencyInput.value = formattedValue.replace(/₫/g, ''); // Loại bỏ chữ 'đ'
}

