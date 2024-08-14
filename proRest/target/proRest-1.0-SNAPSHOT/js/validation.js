import * as inputValidation from "./inputValidation.js";

document.addEventListener("DOMContentLoaded", function () {
    
    let letterInput = document.querySelector("#letterInput");
    let emailInput = document.querySelector("#emailInput");
    let passwordInput = document.querySelector("#passwordInput");
    let confirmInput = document.querySelector("#confirmInput");
    
    letterInput.addEventListener('keypress', (event) =>{
        inputValidation.validarLetras(event, letterInput);
    });
    
    letterInput.addEventListener('blur', (event) =>{
        inputValidation.cantidadLetras(event, letterInput);
    });
    
    emailInput.addEventListener('blur', (event) =>{
        inputValidation.validarCorreo(event, emailInput);
    });
    
    passwordInput.addEventListener('blur', (event) =>{
        inputValidation.validarContrasena(event, passwordInput);
    });
    
    confirmInput.addEventListener('blur', (event) =>{
        inputValidation.confirmarContrasena(passwordInput, confirmInput);
    });
    
    
    let submitButton = document.querySelector('#registerForm');
    
    submitButton.addEventListener('submit', (event) =>{
        inputValidation.validarEnvio(event, submitButton);
    });
    
    
});


