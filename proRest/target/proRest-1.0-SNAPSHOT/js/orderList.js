document.addEventListener('DOMContentLoaded', () => {
    // Agregar plato al carrito
    const agregarPlatoButtons = document.querySelectorAll('.agregar__plato');
    agregarPlatoButtons.forEach(button => {
        
        button.addEventListener('click', () => {
            const plato = button.dataset.plato;
            const precio = button.dataset.precio;

            agregarPlatoLista(plato, precio);
        });
    });

    // Mostrar modal de detalles adicionales
    const modal = document.getElementById('modal');
    const modalForm = document.getElementById('modal-form');
    const detallesTextarea = document.getElementById('detalles');
    const aceptarDetalleButton = document.getElementById('aceptar-detalle');
    let currentDetalleRow;

    const showModal = () => {
        modal.style.display = 'flex';
    };

    const closeModal = () => {
        modal.style.display = 'none';
        detallesTextarea.value = '';
    };

    modalForm.addEventListener('submit', event => {
        event.preventDefault();
    });

    aceptarDetalleButton.addEventListener('click', () => {
        if (currentDetalleRow) {
            currentDetalleRow.querySelector('#detalles').textContent = detallesTextarea.value;
        }
        closeModal();
    });

    document.querySelectorAll('.close').forEach(closeButton => {
        closeButton.addEventListener('click', () => {
            closeModal();
        });
    });

    // Función para agregar plato al carrito
    function agregarPlatoLista(plato, precio) {
        const listaBody = document.querySelector('#lista');
        
        const nombrePlato = document.createElement("p");
        const precioPlato = document.createElement("p");
        const cantidadPlato = document.createElement("input");
        const detallePlato = document.createElement("p");
        const totalPlato = document.createElement("p");
        const accionPlato = document.createElement("button");
        
        nombrePlato.setAttribute("class", "grid__item");
        nombrePlato.textContent = plato;
        
        precioPlato.setAttribute("class", "grid__item");
        precioPlato.textContent = precio;
        
        cantidadPlato.setAttribute("class", "grid__item");
        cantidadPlato.setAttribute("type", "text");
        cantidadPlato.setAttribute("name", "cantidadPlato");
        cantidadPlato.setAttribute("value", "1");
        cantidadPlato.setAttribute("class", "grid__item");
        cantidadPlato.setAttribute("class", "grid__item");
        cantidadPlato.setAttribute("class", "grid__item");
        cantidadPlato.classList.add("grid__item-number");
        cantidadPlato.textContent = precio;
        
        listaBody.appendChild(listaBody) `
            
        `;

        newRow.querySelector('.detalles-button').addEventListener('click', () => {
            currentDetalleRow = newRow;
            showModal();
        });

        newRow.querySelector('.remove-button').addEventListener('click', () => {
            newRow.remove();
        });

        newRow.querySelector('input[type="number"]').addEventListener('input', (event) => {
            const cantidad = event.target.value;
            const total = cantidad * precio;
            newRow.querySelector('.total').textContent = `$${total}`;
        });

        carritoBody.appendChild(newRow);
    }
});


