 // opciones panel

document.addEventListener("DOMContentLoaded", function () {
  const userIcon = document.querySelector("#logUser__icon");
  const logOut = document.querySelector("#logOut");

  userIcon.addEventListener("click", function(event) {
    event.preventDefault(); // Previene el comportamiento por defecto del enlace
    if (logOut.style.display === "none" || logOut.style.display === "") {
      logOut.style.display = "flex";
    } else {
      logOut.style.display = "none";
    }
  });
});


document.addEventListener('DOMContentLoaded', function () {
  const user__icon = document.getElementById('user__icon');
  const hiddenActions = document.getElementById('hidden__actions');

  user__icon.addEventListener('click', function () {
      hiddenActions.classList.toggle('show');
  });
});

document.addEventListener('DOMContentLoaded', function () {
  const mainMenu = document.getElementById('main__menu');
  const arrow = document.getElementById('arrow');
  const mainSelectCategory = document.getElementById('main__selectCategory');
  const mainSelectDish = document.getElementById('main__selectDish');

  arrow.addEventListener('click', function () {
    mainSelectCategory.classList.toggle('show');
    mainSelectDish.classList.toggle('show');
    arrow.classList.toggle('show');
    mainMenu.classList.toggle('show');
  });
});


// menu hamburguesa

document.addEventListener('DOMContentLoaded', function () {
    const hamburgerMenu = document.getElementById('hamburger-menu');
    const mobileNav = document.getElementById('mobile-nav');

    hamburgerMenu.addEventListener('click', function () {
        mobileNav.classList.toggle('show');
    });

    document.addEventListener('click', function (event) {
        if (!mobileNav.contains(event.target) && !hamburgerMenu.contains(event.target)) {
            mobileNav.classList.remove('show');
            closeAllSubmenus();
        }
    });

    const menuLinks = document.querySelectorAll('.mobile-nav__item > p.menu-link');
    console.log(menuLinks);

    menuLinks.forEach(function (link) {
        link.addEventListener('click', function (event) {
            event.preventDefault();

            const submenu = this.nextElementSibling;
            const isOpen = submenu && submenu.classList.contains('navbar__sublist') && submenu.style.display === 'block';
            console.log(isOpen);
            closeAllSubmenus();

            if (submenu && submenu.classList.contains('navbar__sublist')) {
                if (isOpen) {
                    submenu.style.display = 'none';
                } else {
                    submenu.style.display = 'block';
                }
            }
        });
    });

    function closeAllSubmenus() {
        const submenus = document.querySelectorAll('.navbar__sublist');
        submenus.forEach(function (submenu) {
            submenu.style.display = 'none';
        });
    }
});
