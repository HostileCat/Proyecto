// Función para configurar el manejo del formulario
function validarEnvio(event, pedidoForm) {
    let todosLosCampos = document.querySelectorAll(".input__error");
    let pedido = document.querySelector("#platos-input");
    
    console.log(pedido);
    
    let inputError = false;
    let pedidoVacio = false;
    
    if (todosLosCampos.length > 0) {
        inputError = true;
    }
    if (pedido.value === "" || pedido.value === "[]") {
        pedidoVacio = true;
    }
   
    
    let mensajeError = document.createElement("span");
    mensajeError.setAttribute("id", "errorEnviar");
    mensajeError.setAttribute("class", "mensajeError");
    mensajeError.classList.add("mensajeError--envio");
    
    if (inputError){
       mensajeError.textContent = "Las cantidades ingresadas en uno o más campos no son válidas.";
    } else if(pedidoVacio){
       mensajeError.textContent = "El pedido esta vacío";        
    }
    
    const contenedor = pedidoForm.parentElement;
    let errorExistente = document.querySelector("#errorEnviar");
    

    if(inputError || pedidoVacio){
        if (errorExistente === null) {
            contenedor.appendChild(mensajeError);
        } else{
            contenedor.removeChild(errorExistente);
            contenedor.appendChild(mensajeError);
        }
    } else{
        if (errorExistente !== null) {
            console.log(mensajeError);
            contenedor.removeChild(errorExistente);
        }
    }  
    
    let mensajesError = document.querySelectorAll(".mensajeError");
    
    console.log(mensajesError);

    if(mensajesError.length > 0){
        event.preventDefault();

    } else{
        alert("Registro exitoso.");
    }
}



function validarNumeros(event){
    if (!(event.keyCode >= 48 && event.keyCode <= 57)) {
        event.preventDefault();
        
    } 
}

function cantidadNumeros(event, cantidadPlato){
    if (cantidadPlato.value.length <= 0 || cantidadPlato.value.length >= 6) {
        cantidadPlato.classList.add("input__error");
    } else{
        cantidadPlato.classList.remove("input__error");
    }
}




// Función para configurar el manejo del modal
function mostrarModal() {
    const modal = document.getElementById('modal');
    const modalForm = document.getElementById('modal-form');
    const detallesTextarea = document.getElementById('detalles');
    const aceptarDetalleButton = document.getElementById('aceptar-detalle');
    let currentRow;

    const showModal = () => {
        if (currentRow) {
            let detalleInput = currentRow.querySelector('#detalleText');
            detallesTextarea.value = detalleInput.value;
        }
        modal.classList.add("show");
    };

    const closeModal = () => {
        modal.classList.remove("show");
        detallesTextarea.value = '';
    };

    modalForm.addEventListener('submit', event => {
        event.preventDefault();
    });

    aceptarDetalleButton.addEventListener('click', () => {
        if (currentRow) {
            let detalleInput = currentRow.querySelector('#detalleText');
            detalleInput.value = detallesTextarea.value;
            const detalleButton = currentRow.querySelector('#detallePlato');
            detalleButton.classList.toggle("lleno", detalleInput.value);
        }
        actualizarTotalPedido();
        closeModal();
    });

    document.querySelectorAll('#close').forEach(closeButton => {
        closeButton.addEventListener('click', closeModal);
    });

    return { setCurrentRow: (row) => { currentRow = row; }, showModal };
}

// Función para manejar la lógica de los platos
function agregarPlatos() {
    const { setCurrentRow, showModal } = mostrarModal();
    const listaBody = document.querySelector('#lista');

    function agregarPlatoLista(plato, precio, id) {
        const existingRow = Array.from(listaBody.querySelectorAll(".item__container"))
            .find(row => row.children[0].value === id);

        if (existingRow) {
            const cantidadInput = existingRow.querySelector('#cantidadPlato');
            const total = existingRow.querySelector('#totalPlato');
            cantidadInput.value = parseInt(cantidadInput.value) + 1;
            total.textContent = precio * cantidadInput.value;
        } else {
            const itemContainer = document.createElement("div");
            itemContainer.setAttribute("class", "item__container");

            itemContainer.innerHTML = `
                <input type="hidden" id="idPlato" name="idPlato" value="${id}">
                <p class="grid__item" id="nombrePlato">${plato}</p>
                <p class="grid__item" id="precioPlato">${precio}</p>
                <input class="grid__item grid__item-number" type="text" id="cantidadPlato" name="cantidadPlato" value="1">
                <input type="hidden" id="detalleText" name="detalleText" value="">
                <button class="detalle__plato" id="detallePlato">Detalle</button>
                <p class="grid__item" id="totalPlato">${precio}</p>
                <button class="remover__plato" id="removerPlato">Remover</button>
            `;
            
            listaBody.appendChild(itemContainer);
        }

        actualizarTotalPedido();
        adjuntarItems();
    }

    function adjuntarItems() {
        document.querySelectorAll('.item__container').forEach(item => {
            const cantidadItem = item.querySelector(".grid__item-number");
            const totalItem = item.querySelector("#totalPlato");
            const precioPlato = item.querySelector("#precioPlato");
            const detallePlato = item.querySelector("#detallePlato");
            const removerPlato = item.querySelector("#removerPlato");

            cantidadItem.addEventListener('input', () => {
                totalItem.textContent = precioPlato.textContent * cantidadItem.value;
                actualizarTotalPedido();
            });
            detallePlato.addEventListener('click', () => {
                setCurrentRow(item);
                showModal();
            });
            removerPlato.addEventListener('click', () => {
                item.remove();
                actualizarTotalPedido();
            });
        });
    }

    document.querySelectorAll('.agregar__plato').forEach(button => {
        button.addEventListener('click', () => {
            const plato = button.dataset.plato;
            const precio = button.dataset.precio;
            const id = button.dataset.id;
            agregarPlatoLista(plato, precio, id);
        });
    });

    adjuntarItems();
}

// Función para actualizar el total del pedido
function actualizarTotalPedido() {
    const listaBody = document.querySelector('#lista');
    const totalPedidoElement = document.getElementById('totalPedido');
    const totalInput = document.getElementById('total-input');
    const platosInput = document.getElementById('platos-input');

    let total = 0;
    const platos = [];
    
    listaBody.querySelectorAll('.item__container').forEach(row => {
        const cantidad = row.querySelector('#cantidadPlato').value;
        const precio = row.querySelector('#totalPlato').textContent;
        total += parseInt(precio);
        platos.push({
            id: parseInt(row.querySelector("#idPlato").value),
            nombre: row.querySelector("#nombrePlato").textContent,
            precio: parseInt(row.querySelector("#precioPlato").textContent),
            cantidad: parseInt(cantidad),
            detalle: row.querySelector('#detalleText').value
        });
    });

    totalPedidoElement.textContent = total;
    totalInput.value = total;
    platosInput.value = JSON.stringify(platos);
}

export { validarEnvio, validarNumeros, cantidadNumeros, agregarPlatos };
