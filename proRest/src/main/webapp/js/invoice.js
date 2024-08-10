document.addEventListener("DOMContentLoaded", function() {
            const invoiceButton = document.querySelector("#invoiceButton");

            invoiceButton.addEventListener("click", () => {

                window.print();
            });
        });