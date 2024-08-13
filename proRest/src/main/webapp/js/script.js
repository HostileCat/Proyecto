import * as userOptions from './userIcon.js'


document.addEventListener("DOMContentLoaded", function () {
  const userIcon = document.querySelector("#logUser__icon");
  const profileOptions = document.querySelector("#profileOptions");
  console.log(userIcon);
  if(userIcon !== null){
      userOptions.showUserOptions(userIcon, profileOptions);
  }
  
  const user__icon = document.querySelector('#user__icon');
  const hiddenActions = document.querySelector('#hidden__actions');
  console.log(user__icon);
  if(user__icon !== null){
      userOptions.showUserActions(user__icon, hiddenActions);
  }

    
    
    
    
    const hamburgerMenu = document.querySelector('#hamburger-menu');
const mobileNav = document.querySelector('#mobile-nav');

// Toggle para mostrar/ocultar el menú móvil
hamburgerMenu.addEventListener('click', function () {
    mobileNav.classList.toggle('show');
});

// Cerrar el menú móvil si se hace clic fuera de él
document.addEventListener('click', function (event) {
    if (!mobileNav.contains(event.target) && !hamburgerMenu.contains(event.target)) {
        mobileNav.classList.remove('show');
        closeAllSubmenus(); // Cerrar todos los submenús
    }
});

// Seleccionar todos los enlaces que tienen submenús
const menuLinks = document.querySelectorAll('.mobile-nav__item > p.menu-link');
console.log(menuLinks);

menuLinks.forEach(function (link) {
    link.addEventListener('click', function (event) {
        event.preventDefault();

        const submenu = this.nextElementSibling;
        const isOpen = submenu && submenu.classList.contains('show');
        console.log(isOpen);
        closeAllSubmenus(); // Cerrar todos los submenús antes de abrir uno nuevo

        if (submenu && submenu.classList.contains('navbar__sublist')) {
            if (isOpen) {
                submenu.classList.remove('show');
            } else {
                submenu.classList.add('show');
            }
        }
    });
});

// Función para cerrar todos los submenús
function closeAllSubmenus() {
    const submenus = document.querySelectorAll('.navbar__sublist');
    submenus.forEach(function (submenu) {
        submenu.classList.remove('show');
    });
}

});

