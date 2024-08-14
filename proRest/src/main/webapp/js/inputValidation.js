const validarLetras = (event, letterInput) =>{
    const regexLetras = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]*$/;
    
    let mensajeError = document.createElement("span");
    mensajeError.setAttribute("id", "errorNombre");
    mensajeError.setAttribute("class", "mensajeError");
    mensajeError.textContent = "El nombre solo debe tener letras y espacios";
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
};



const cantidadLetras = (event, letterInput) =>{
    let mensajeError = document.createElement("span");
    mensajeError.setAttribute("id", "errorNombre");
    mensajeError.setAttribute("class", "mensajeError");
    mensajeError.textContent = "El nombre no debe tener mas de 200 caracteres";
    const padre = letterInput.parentElement;

    let errorExistente = document.querySelector("#errorNombre");
      
    if (letterInput.value.length >= 3 && letterInput.value.length <= 10) {
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
};


const validarCorreo = (event, emailInput) => {
    const regexCorreo = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    
    let mensajeError = document.createElement("span");
    mensajeError.setAttribute("id", "errorCorreo");
    mensajeError.setAttribute("class", "mensajeError");
    mensajeError.textContent = "El correo no es válido";
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
    mensajeError.textContent = "La contraseña debe tener al menor una letra mayúscula, una letra minúscula y un número";
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

const confirmarContrasena = (passwordInput, confirmInput) => {
    
    let mensajeError = document.createElement("span");
    mensajeError.setAttribute("id", "errorConfirmar");
    mensajeError.setAttribute("class", "mensajeError");
    mensajeError.textContent = "Las contraseñas no coinciden. Por favor, verifica que ambas coincidan.";
    const padre = confirmInput.parentElement;

    let errorExistente = document.querySelector("#errorConfirmar");
    
    if (passwordInput.value === confirmInput.value) {
        confirmInput.classList.remove("input__error");
        if (errorExistente !== null) {
            padre.removeChild(errorExistente);
        }
    }else{
        confirmInput.classList.add("input__error");
        if (errorExistente === null) {
            padre.appendChild(mensajeError);
        }
    }  
};

const validarEnvio = (event, submitButton) => {
    
    let todosLosCampos = document.querySelectorAll(".register__input");
    
    let campoVacio = false;
    
    todosLosCampos.forEach(input =>{
        if (input.value.trim() === '') {
            campoVacio = true;
        }
    });
    
    let mensajeError = document.createElement("span");
    mensajeError.setAttribute("id", "errorEnviar");
    mensajeError.setAttribute("class", "mensajeError");
    mensajeError.textContent = "Hay algún campo vacío";
    
    const padre = submitButton.parentElement;
    let errorExistente = document.querySelector("#errorEnviar");
    
    
    if(campoVacio){
        if (errorExistente === null) {
            padre.appendChild(mensajeError);
        }
    } else{
        if (errorExistente !== null) {
            padre.removeChild(mensajeError);
        }
    }  
    
    let mensajesError = document.querySelectorAll(".mensajeError");

    if(mensajesError !== null){
        event.preventDefault();
        submitButton.classList.add("disabled");
    } else{
        submitButton.classList.remove("disabled");
    }
};



export { validarLetras, cantidadLetras, validarCorreo, validarContrasena, confirmarContrasena, validarEnvio };


