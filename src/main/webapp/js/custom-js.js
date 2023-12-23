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
            if (selector === "#productAddName" || selector === "#productUpdateName") {
                return value.trim() ? undefined : "Vui lòng nhập trường này";
            } else if (selector === "#productAddPrice" || selector === "#productUpdatePrice") {
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

const validationRules = [
    Validator.isRequired('#productAddPrice'),
    Validator.isRequired('#productAddName')
];

const validator = new Validator({
    form: '#form-add-1',
    validationRules: validationRules
});
