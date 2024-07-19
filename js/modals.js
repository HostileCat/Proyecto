// modal 
document.addEventListener('DOMContentLoaded', function () {
  const editItems = document.querySelectorAll(".edit__item");

  const categoryId = document.querySelector("#categoryId");

  
    
  const modal = document.querySelector('#modal');
  const modalClose = document.querySelector('#modal-close');
  const modalTitle = document.querySelector('#modal-title');
  const modalDescription = document.querySelector('#modal-description');
  const modalDelete = document.querySelector('#modal-delete');
  const modalCancel = document.querySelector('#modal-cancel');
  
  

  // Añadir evento de clic a cada item de categoria
  editItems.forEach(item => {
      item.addEventListener('click', () => {
          const dataId = item.getAttribute('data-id');
          

          // Aquí podrías hacer una llamada para obtener los detalles de la categoria
          modalTitle.textContent = `Eliminar categoria: ${item.textContent}`;
          modalDescription.textContent = `¿Desea eliminar esta categoria?`;
          categoryId.setAttribute("value", dataId);
          modal.style.display = 'flex';
          

          
      });
  });
  
  console.log(categoryId);

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
      
      
      alert('Categoria eliminada');
      
      closeModal();
  });

  // Ocultar el modal si se hace clic fuera del contenido del modal
  window.addEventListener('click', (event) => {
      if (event.target === modal) {
          closeModal();
      }
  });
});





