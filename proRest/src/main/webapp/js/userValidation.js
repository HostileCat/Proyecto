import * as userValidation from "./module/userModule.js";

document.addEventListener("DOMContentLoaded", function () {
    
    let letterInput = document.querySelector("#letterInput");
    let emailInput = document.querySelector("#emailInput");
    let passwordInput = document.querySelector("#passwordInput");
    let confirmInput = document.querySelector("#confirmInput");
    
    letterInput.addEventListener('keypress', (event) =>{
        userValidation.validarLetras(event, letterInput);
    });
    
    letterInput.addEventListener('input', (event) =>{
        userValidation.cantidadLetras(event, letterInput);
    });
    
    emailInput.addEventListener('input', (event) =>{
        userValidation.validarCorreo(event, emailInput);
    });
    
    
    if(passwordInput !== null){
        passwordInput.addEventListener('input', (event) =>{
            userValidation.validarContrasena(event, passwordInput);
        });
    }
    
    if(confirmInput !== null){
        confirmInput.addEventListener('input', (event) =>{
            userValidation.confirmarContrasena(passwordInput, confirmInput);
        });
    }
    
    
    
    let userForm = document.querySelector('#userForm');
    let submitButton = document.querySelector('#submitButton');
    
    userForm.addEventListener('submit', (event) =>{
        userValidation.validarEnvio(event, submitButton);
    });
    
    
});