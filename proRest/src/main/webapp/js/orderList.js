import { scrollArriba } from "./scrollTop.js";

document.addEventListener('DOMContentLoaded', () => {
    
    document.querySelector("#pedidoForm").addEventListener('submit', ()=>{
        alert("Pedido enviado");
    });
    
    scrollArriba();
    
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
    let currentRow;

    const showModal = () => {
        if (currentRow) {
            let detalleInput = currentRow.querySelector('#detalleText');
            
            detallesTextarea.value = detalleInput.value;
        }
        
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
        if (currentRow) {
            let detalleInput = currentRow.querySelector('#detalleText');
            detalleInput.value = detallesTextarea.value;
            if (detalleInput.value){
                let detalleButton = currentRow.querySelector('#detallePlato');
                detalleButton.classList.add("lleno");
            } else {
                let detalleButton = currentRow.querySelector('#detallePlato');
                detalleButton.classList.remove("lleno");
            }
        }
        actualizarTotalPedido();
        closeModal();
    });

    document.querySelectorAll('#close').forEach(closeButton => {
        closeButton.addEventListener('click', () => {
            closeModal();
        });
    });
    
    const listaBody = document.querySelector('#lista');

    const totalPedidoElement = document.getElementById('totalPedido');
    const totalInput = document.getElementById('total-input');
    const platosInput = document.getElementById('platos-input');
    
    function agregarPlatoLista(plato, precio, id) {
        
        const existingRow = Array.from(listaBody.querySelectorAll(".item__container")).find(row => row.children[0].value === id);
        console.log(existingRow);
        console.log(id);
        if (existingRow) {
            const cantidadInput = existingRow.querySelector('#cantidadPlato');
            const total = existingRow.querySelector('#totalPlato');
            cantidadInput.value = parseInt(cantidadInput.value) + 1;
            total.textContent = precio * cantidadInput.value;
        } else{
            const itemContainer = document.createElement("div");
            itemContainer.setAttribute("class", "item__container");

            const idPlato = document.createElement("input");
            const nombrePlato = document.createElement("p");
            const precioPlato = document.createElement("p");
            const cantidadPlato = document.createElement("input");
            const detalleText = document.createElement("input");
            const detallePlato = document.createElement("button");
            const totalPlato = document.createElement("p");
            const accionPlato = document.createElement("button");

            idPlato.setAttribute("type", "hidden");
            idPlato.setAttribute("id", "idPlato");
            idPlato.setAttribute("name", "idPlato");
            idPlato.setAttribute("value", id);

            nombrePlato.setAttribute("class", "grid__item");
            nombrePlato.setAttribute("id", "nombrePlato");
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

            detalleText.setAttribute("type", "hidden");
            detalleText.setAttribute("id", "detalleText");
            detalleText.setAttribute("name", "detalleText");
            detalleText.setAttribute("value", "");

            detallePlato.setAttribute("class", "detalle__plato");
            detallePlato.setAttribute("id", "detallePlato");
            detallePlato.textContent = "Detalle";

            totalPlato.setAttribute("class", "grid__item");
            totalPlato.setAttribute("id", "totalPlato");
            totalPlato.textContent = precio * cantidadPlato.value;

            accionPlato.setAttribute("class", "remover__plato");
            accionPlato.setAttribute("id", "removerPlato");
            accionPlato.textContent = "Remover";

            itemContainer.appendChild(idPlato);
            itemContainer.appendChild(nombrePlato);
            itemContainer.appendChild(precioPlato);
            itemContainer.appendChild(cantidadPlato);
            itemContainer.appendChild(detalleText);
            itemContainer.appendChild(detallePlato);
            itemContainer.appendChild(totalPlato);
            itemContainer.appendChild(accionPlato);

            listaBody.appendChild(itemContainer);
        }
        

        
        
        actualizarTotalPedido();
        // acciones en los items
        
        const itemsContainer = document.querySelectorAll('.item__container');
    
        itemsContainer.forEach(item => {

            const cantidadItem = item.querySelector(".grid__item-number");
            const totalItem = item.querySelector("#totalPlato");
            const precioPlato = item.querySelector(("#precioPlato"));
            const detallePlato = item.querySelector(("#detallePlato"));
            const removerPlato = item.querySelector(("#removerPlato"));

            console.log(itemsContainer);
            console.log(detallePlato);
            console.log(cantidadItem.value);

            cantidadItem.addEventListener('input', () => {
                totalItem.textContent = precioPlato.textContent * cantidadItem.value;
                actualizarTotalPedido();
            });
            detallePlato.addEventListener('click', () => {
                currentRow = item;
                showModal();
            });
            removerPlato.addEventListener('click', () =>{
                item.remove();
            });
        });
    }
    
    function actualizarTotalPedido() {
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
        console.log(platos);
        totalPedidoElement.textContent = total;
        totalInput.value = total;
        platosInput.value = JSON.stringify(platos);
    }
});


