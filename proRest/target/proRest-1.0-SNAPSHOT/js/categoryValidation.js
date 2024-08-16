document.addEventListener("DOMContentLoaded", function () {
    let letterInput = document.querySelector("#letterInput");
    
    letterInput.addEventListener('keypress', (event) =>{
        const regexLetras = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]*$/;
        console.log(event);
        let mensajeError = document.createElement("span");
        mensajeError.setAttribute("id", "errorNombre");
        mensajeError.setAttribute("class", "mensajeError");
        mensajeError.textContent = "El nombre solo debe tener letras y espacios.";
        const padre = letterInput.parentElement;

        let errorExistente = document.querySelector("#errorNombre");

        if (!(regexLetras.test(event.key))) {
            event.preventDefault();
            letterInput.classList.add("input__error");
            if (errorExistente === null) {
                padre.appendChild(mensajeError);
            }
        } else{
            letterInput.classList.remove("input__error");
            if (errorExistente !== null) {
                padre.removeChild(errorExistente);
            }
        }
    });
    
    letterInput.addEventListener('input', (event) =>{
        let mensajeError = document.createElement("span");
        mensajeError.setAttribute("id", "errorNombre");
        mensajeError.setAttribute("class", "mensajeError");
        mensajeError.textContent = "El nombre no debe tener mas de 40 caracteres.";
        const padre = letterInput.parentElement;

        let errorExistente = document.querySelector("#errorNombre");

        if (letterInput.value.length >= 0 && letterInput.value.length <= 40) {
            letterInput.classList.remove("input__error");
            if (errorExistente !== null) {
                padre.removeChild(errorExistente);
            }
        }else{
            letterInput.classList.add("input__error");
            if (errorExistente === null) {
                padre.appendChild(mensajeError);
            }
        }    
    });
    
    let categoryForm = document.querySelector('#categoryForm');
    let submitButton = document.querySelector('#submitButton');
    
    categoryForm.addEventListener('submit', (event) =>{
        let todosLosCampos = document.querySelectorAll(".add__input");
    
        let campoVacio = false;

        todosLosCampos.forEach(input =>{
            if (input.value.trim() === '') {
                campoVacio = true;
            }
        });

        let mensajeError = document.createElement("span");
        mensajeError.setAttribute("id", "errorEnviar");
        mensajeError.setAttribute("class", "mensajeError");
        mensajeError.classList.add("mensajeError--envio");
        mensajeError.textContent = "Completa todos los campos antes de enviar.";

        const contenedor = submitButton.parentElement;
        let errorExistente = document.querySelector("#errorEnviar");


        if(campoVacio){
            if (errorExistente === null) {
                contenedor.prepend(mensajeError);
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
    });
});

