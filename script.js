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

// menu hamburguesa

document.addEventListener('DOMContentLoaded', function () {
  const hamburgerMenu = document.getElementById('hamburger-menu');
  const mobileNav = document.getElementById('mobile-nav');

  hamburgerMenu.addEventListener('click', function () {
      mobileNav.classList.toggle('show');
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
  const mainMenu = document.getElementById('main__menu')
  const arrow = document.getElementById('arrow')
  const mainSelectCategory = document.getElementById('main__selectCategory');
  const mainSelectDish = document.getElementById('main__selectDish');

  arrow.addEventListener('click', function () {
    mainSelectCategory.classList.toggle('show');
    mainSelectDish.classList.toggle('show');
    arrow.classList.toggle('show');
    mainMenu.classList.toggle('show');
  });
});

// modal
document.addEventListener('DOMContentLoaded', function () {
  const dishItems = document.querySelectorAll(".edit__item");

  const modal = document.querySelector('#modal');
  const modalClose = document.querySelector('#modal-close');
  const modalTitle = document.querySelector('#modal-title');
  const modalDescription = document.querySelector('#modal-description');
  const modalDelete = document.querySelector('#modal-delete');
  const modalCancel = document.querySelector('#modal-cancel');

  // Añadir evento de clic a cada item de plato
  dishItems.forEach(item => {
      item.addEventListener('click', () => {
          const dishId = item.getAttribute('data-id');
          // Aquí podrías hacer una llamada para obtener los detalles del plato
          modalTitle.textContent = `Eliminar Plato ${dishId}`;
          modalDescription.textContent = `Descripción del Plato ${dishId}`;

          modal.style.display = 'flex';
      });
  });

  // Función para cerrar el modal
  const closeModal = () => {
      modal.style.display = 'none';
  };

  // Añadir eventos de clic para cerrar el modal
  modalClose.addEventListener('click', closeModal);
  modalCancel.addEventListener('click', closeModal);

  // Evento de clic para el botón de eliminar
  modalDelete.addEventListener('click', () => {
      // Aquí puedes añadir la lógica para eliminar el plato
      alert('Plato eliminado');
      closeModal();
  });

  // Ocultar el modal si se hace clic fuera del contenido del modal
  window.addEventListener('click', (event) => {
      if (event.target === modal) {
          closeModal();
      }
  });
});


