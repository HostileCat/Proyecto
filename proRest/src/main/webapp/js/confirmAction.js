import * as confirmAction from "./module/confirmModule.js"

document.addEventListener("DOMContentLoaded", function () {
    
    let formCancelar = document.querySelector('#cancelarReserva');       
    
    if(formCancelar !== null){
        formCancelar.addEventListener('submit', function(event) {
            confirmAction.cancelarReserva(event, formCancelar);
        });  
    }
    
    let formConfirmar = document.querySelector('#confirmarReserva');       
    
    if(formConfirmar !== null){
        formConfirmar.addEventListener('submit', function(event) {
            confirmAction.confirmarReserva(event, formConfirmar);
        });  
    }
    
    let formTerminar = document.querySelector('#formTerminar');       
    
    if(formTerminar !== null){
        formTerminar.addEventListener('submit', function(event) {
            confirmAction.terminarReserva(event, formTerminar);
        });  
    }  
});





