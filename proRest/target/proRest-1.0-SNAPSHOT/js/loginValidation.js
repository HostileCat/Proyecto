import * as registerValidation from "./module/loginModule.js";

document.addEventListener("DOMContentLoaded", function () {
    

    let emailInput = document.querySelector("#emailInput");
    let passwordInput = document.querySelector("#passwordInput");


    emailInput.addEventListener('input', (event) =>{
        registerValidation.validarCorreo(event, emailInput);
    });
    
    passwordInput.addEventListener('input', (event) =>{
        registerValidation.validarContrasena(event, passwordInput);
    });

    
    
    let registerForm = document.querySelector('#loginForm');
    let submitButton = document.querySelector('#submitButton');
    
    registerForm.addEventListener('submit', (event) =>{
        registerValidation.validarEnvio(event, submitButton);
    });
    
    
});






