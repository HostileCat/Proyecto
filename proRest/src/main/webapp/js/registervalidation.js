import * as registerValidation from "./module/registerModule.js";

document.addEventListener("DOMContentLoaded", function () {
    
    let letterInput = document.querySelector("#letterInput");
    let emailInput = document.querySelector("#emailInput");
    let passwordInput = document.querySelector("#passwordInput");
    let confirmInput = document.querySelector("#confirmInput");
    
    letterInput.addEventListener('keypress', (event) =>{
        registerValidation.validarLetras(event, letterInput);
    });
    
    letterInput.addEventListener('input', (event) =>{
        registerValidation.cantidadLetras(event, letterInput);
    });
    
    emailInput.addEventListener('input', (event) =>{
        registerValidation.validarCorreo(event, emailInput);
    });
    
    passwordInput.addEventListener('input', (event) =>{
        registerValidation.validarContrasena(event, passwordInput);
    });
    
    confirmInput.addEventListener('input', (event) =>{
        registerValidation.confirmarContrasena(passwordInput, confirmInput);
    });
    
    
    let registerForm = document.querySelector('#registerForm');
    let submitButton = document.querySelector('#submitButton');
    
    registerForm.addEventListener('submit', (event) =>{
        registerValidation.validarEnvio(event, submitButton);
    });
    
    
});


