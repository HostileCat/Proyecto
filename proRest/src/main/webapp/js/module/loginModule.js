const validarCorreo = (event, emailInput) => {
    const regexCorreo = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    
    let mensajeError = document.createElement("span");
    mensajeError.setAttribute("id", "errorCorreo");
    mensajeError.setAttribute("class", "mensajeError");
    mensajeError.textContent = "El correo no es válido.";
    const padre = emailInput.parentElement;

    let errorExistente = document.querySelector("#errorCorreo");
    
    if (regexCorreo.test(emailInput.value)) {
        emailInput.classList.remove("input__error");
        if (errorExistente !== null) {
            padre.removeChild(errorExistente);
        }
    }else{
        emailInput.classList.add("input__error");
        if (errorExistente === null) {
            padre.appendChild(mensajeError);
        }
    }  
};

const validarContrasena = (event, passwordInput) => {
    const regexContrasena = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;

    
    let mensajeError = document.createElement("span");
    mensajeError.setAttribute("id", "errorContrasena");
    mensajeError.setAttribute("class", "mensajeError");
    mensajeError.textContent = "La contraseña debe tener mínimo 8 caracteres, tener al menos una letra mayúscula, una letra minúscula y un número.";
    const padre = passwordInput.parentElement;

    let errorExistente = document.querySelector("#errorContrasena");
    
    if (regexContrasena.test(passwordInput.value)) {
        passwordInput.classList.remove("input__error");
        if (errorExistente !== null) {
            padre.removeChild(errorExistente);
        }
    }else{
        passwordInput.classList.add("input__error");
        if (errorExistente === null) {
            padre.appendChild(mensajeError);
        }
    }  
};


const validarEnvio = (event, submitButton) => {
    
    let todosLosCampos = document.querySelectorAll(".login__input");
    
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
    
    console.log(contenedor);
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

    } 
};



export { validarCorreo, validarContrasena, validarEnvio };


