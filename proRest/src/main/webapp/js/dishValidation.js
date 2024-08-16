import * as dishValidation from "./module/dishModule.js";

document.addEventListener("DOMContentLoaded", function () {
    
    let nombrePlato = document.querySelector("#nombrePlato");
    let descripcionPlato = document.querySelector("#descripcionPlato");
    let precioPlato = document.querySelector("#precioPlato");
    //let imagenPlato = document.querySelector("#imagenPlato");
    
    nombrePlato.addEventListener('keypress', (event) =>{
        dishValidation.validarLetras(event, nombrePlato);
    });
    
    descripcionPlato.addEventListener('keypress', (event) =>{
        dishValidation.validarLetras(event, descripcionPlato);
    });
    
    nombrePlato.addEventListener('input', (event) =>{
        dishValidation.cantidadLetras(event, nombrePlato);
    });
    
    descripcionPlato.addEventListener('input', (event) =>{
        dishValidation.cantidadLetras(event, descripcionPlato);
    });
    
    precioPlato.addEventListener('keypress', (event) =>{
        dishValidation.validarNumeros(event, precioPlato);
    });
    
    precioPlato.addEventListener('input', (event) =>{
        dishValidation.cantidadNumeros(event, precioPlato);
    });
    

    let dishForm = document.querySelector('#dishForm');
    let submitButton = document.querySelector('#submitButton');
    
    dishForm.addEventListener('submit', (event) =>{
        dishValidation.validarEnvio(event, submitButton);
    });
    
    
});

