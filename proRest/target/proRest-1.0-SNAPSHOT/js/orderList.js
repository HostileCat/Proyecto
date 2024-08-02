document.addEventListener('DOMContentLoaded', () => {
    // Agregar plato al carrito
    const agregarPlatoButtons = document.querySelectorAll('.agregar__plato');
    agregarPlatoButtons.forEach(button => {
        
        button.addEventListener('click', () => {
            const plato = button.dataset.plato;
            const precio = button.dataset.precio;
            const id = button.dataset.id;
            agregarPlatoLista(plato, precio, id);
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
    function agregarPlatoLista(plato, precio, id) {
        const listaBody = document.querySelector('#lista');
        
        const itemContainer = document.createElement("div");
        itemContainer.setAttribute("class", "item__container");
        
        const nombrePlato = document.createElement("p");
        const precioPlato = document.createElement("p");
        const cantidadPlato = document.createElement("input");
        const detallePlato = document.createElement("button");
        const totalPlato = document.createElement("p");
        const accionPlato = document.createElement("button");
        
        nombrePlato.setAttribute("class", "grid__item");
        nombrePlato.textContent = plato;
        
        precioPlato.setAttribute("class", "grid__item");
        precioPlato.setAttribute("id", "precioPlato");
        precioPlato.textContent = precio;
        
        cantidadPlato.setAttribute("class", "grid__item");
        cantidadPlato.setAttribute("id", "cantidadPlato");
        cantidadPlato.setAttribute("type", "text");
        cantidadPlato.setAttribute("name", "cantidadPlato");
        cantidadPlato.setAttribute("value", "1");        
        cantidadPlato.classList.add("grid__item-number");
        
        detallePlato.setAttribute("class", "detalle__plato");
        detallePlato.setAttribute("class", "detalle__plato");
        detallePlato.textContent = "Detalle";

        totalPlato.setAttribute("class", "grid__item");
        totalPlato.setAttribute("id", "totalPlato");
        totalPlato.textContent = precio * cantidadPlato.value;
        
        accionPlato.setAttribute("class", "remover__plato");
        accionPlato.setAttribute("data-plato", plato);
        accionPlato.setAttribute("data-precio", precio);
        accionPlato.setAttribute("data-id", id);
        accionPlato.textContent = "Remover";
        
        itemContainer.appendChild(nombrePlato);
        itemContainer.appendChild(precioPlato);
        itemContainer.appendChild(cantidadPlato);
        itemContainer.appendChild(detallePlato);
        itemContainer.appendChild(totalPlato);
        itemContainer.appendChild(accionPlato);
        
        listaBody.appendChild(itemContainer);
        
        // acciones en los items
        
        const itemsContainer = document.querySelectorAll('.item__container');
    
        itemsContainer.forEach(item => {

            const cantidadItem = item.querySelector(".grid__item-number");
            const totalItem = item.querySelector("#totalPlato");
            const precioPlato = item.querySelector(("#precioPlato"));

            console.log(itemsContainer);
            console.log(precioPlato.textContent);
            console.log(cantidadItem.value);

            cantidadItem.addEventListener('input', () => {
                totalItem.textContent = precioPlato.textContent * cantidadItem.value;
            });
            item.addEventListener('click', () => {

            });
        });
    }
});


