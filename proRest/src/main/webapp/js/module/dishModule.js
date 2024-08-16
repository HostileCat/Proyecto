const validarLetras = (event, letterInput) =>{
    const regexLetras = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]*$/;
    
    const id = letterInput.getAttribute('id');
    
    let mensajeError = document.createElement("span");
    
    mensajeError.setAttribute("class", "mensajeError");
    
    let errorExistente;
    if(id === "nombrePlato"){
        mensajeError.setAttribute("id", "errorNombre");
        mensajeError.textContent = "El nombre solo debe tener letras y espacios.";
        errorExistente = document.querySelector("#errorNombre");
    } else if(id === "descripcionPlato"){
        mensajeError.setAttribute("id", "errorDescripcion");
        mensajeError.textContent = "La descripción solo debe tener letras y espacios.";
        errorExistente = document.querySelector("#errorDescripcion");
    }
    
    const padre = letterInput.parentElement;
    
        
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
};



const cantidadLetras = (event, letterInput) =>{
    let mensajeError = document.createElement("span");
    
    const id = letterInput.getAttribute('id');
    mensajeError.setAttribute("class", "mensajeError");
    
    let errorExistente;
    if(id === "nombrePlato"){
        mensajeError.setAttribute("id", "errorNombre");
        mensajeError.textContent = "El nombre no debe tener mas de 40 caracteres.";
        errorExistente = document.querySelector("#errorNombre");
    } else if(id === "descripcionPlato"){
        mensajeError.setAttribute("id", "errorDescripcion");
        mensajeError.textContent = "La descripción debe tener un máximo de 200 caracteres.";
        errorExistente = document.querySelector("#errorDescripcion");
    }
    
    const padre = letterInput.parentElement;
      
    if (letterInput.value.length >= 0 && letterInput.value.length <= 40 && id === "nombrePlato") {
        letterInput.classList.remove("input__error");
        if (errorExistente !== null) {
            padre.removeChild(errorExistente);
        }
    } else if (letterInput.value.length >= 0 && letterInput.value.length <= 200 && id === "descripcionPlato") {
        letterInput.classList.remove("input__error");
        if (errorExistente !== null) {
            padre.removeChild(errorExistente);
        }
    } else{
        letterInput.classList.add("input__error");
        if (errorExistente === null) {
            padre.appendChild(mensajeError);
        }
    }    
};


const validarNumeros = (event, precioPlato) =>{
    
    let mensajeError = document.createElement("span");
    mensajeError.setAttribute("id", "errorPrecio");
    mensajeError.setAttribute("class", "mensajeError");
    mensajeError.textContent = "El precio solo debe tener numeros.";
    const padre = precioPlato.parentElement;

    let errorExistente = document.querySelector("#errorPrecio");
    
    
    if (!(event.keyCode >= 48 && event.keyCode <= 57)) {
        event.preventDefault();
        precioPlato.classList.add("input__error");
        if (errorExistente === null) {
            padre.appendChild(mensajeError);
        }
    } else{
        precioPlato.classList.remove("input__error");
        if (errorExistente !== null) {
            padre.removeChild(errorExistente);
        }
    }

};


const cantidadNumeros = (event, precioPlato) =>{
    let mensajeError = document.createElement("span");
    mensajeError.setAttribute("id", "errorPrecio");
    mensajeError.setAttribute("class", "mensajeError");
    mensajeError.textContent = "El precio no debe tener mas de 6 caracteres.";
    const padre = precioPlato.parentElement;

    let errorExistente = document.querySelector("#errorPrecio");
      
    if (precioPlato.value.length >= 0 && precioPlato.value.length <= 6) {
        precioPlato.classList.remove("input__error");
        if (errorExistente !== null) {
            padre.removeChild(errorExistente);
        }
    }else{
        precioPlato.classList.add("input__error");
        if (errorExistente === null) {
            padre.appendChild(mensajeError);
        }
    }    
};



const validarEnvio = (event, submitButton) => {
    
    let todosLosCampos = document.querySelectorAll(".add__input");
    
    let campoVacio = false;
    
    
    
    todosLosCampos.forEach(input =>{
        console.log(input.value);
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

};



export { validarLetras, cantidadLetras, validarNumeros, cantidadNumeros, validarEnvio };






