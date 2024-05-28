document.addEventListener("DOMContentLoaded", function() {
    const userIcon = document.getElementById("userIcon");
    const subitem = document.getElementById("subitem");

    userIcon.addEventListener("click", function(event) {
        event.preventDefault(); // Previene el comportamiento por defecto del enlace
        if (subitem.style.display === "none" || subitem.style.display === "") {
            subitem.style.display = "flex";
        } else {
            subitem.style.display = "none";
        }
    });
});


document.addEventListener('DOMContentLoaded', function () {
    const hamburgerMenu = document.getElementById('hamburger-menu');
    const mobileNav = document.getElementById('mobile-nav');

    hamburgerMenu.addEventListener('click', function () {
        mobileNav.classList.toggle('show');
    });
});

document.addEventListener('DOMContentLoaded', function () {
    const circle = document.getElementById('circle');
    const hiddenActions = document.getElementById('hidden__actions');

    circle.addEventListener('click', function () {
        hiddenActions.classList.toggle('show');
    });
});