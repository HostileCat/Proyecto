import * as dateValidation from "./module/dateModule.js"

document.addEventListener('DOMContentLoaded', function () {
    let form = document.querySelector(".section__form");
    let button = document.querySelector(".section__addButton");

    const clienteInput = document.querySelector("#nombreCliente");
    
    const fechaReserva = document.querySelector('#fechaReserva');
    const horaReserva = document.querySelector('#horaReserva');
    
    fechaReserva.addEventListener('blur', (event) =>{
        dateValidation.validarFecha(event, fechaReserva);
       
    });
    
    horaReserva.addEventListener('blur', (event) =>{
        dateValidation.validarHora(event, horaReserva);
        
    });
    
    
    
    form.addEventListener('submit', (event) =>{
        dateValidation.validarEnvio(event, button);
    });   
    
});

