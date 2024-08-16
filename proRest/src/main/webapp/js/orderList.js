import { scrollArriba } from "./module/scrollTop.js";
import * as orderList from "./module/orderListModule.js";

document.addEventListener('DOMContentLoaded', () => {
    
    
    
    orderList.agregarPlatos();
    
    const addButtons = document.querySelectorAll(".agregar__plato");
    console.log(addButtons);
    if(addButtons.length > 0){
        addButtons.forEach(button =>{
            button.addEventListener('click', ()=>{
                
                
                let inputItems = document.querySelectorAll(".grid__item-number");
                console.log(inputItems);
                if(inputItems.length > 0){

                    inputItems.forEach(cantidadPlato =>{
                        cantidadPlato.addEventListener('keypress', (event) => {
                            orderList.validarNumeros(event);
                        });
                        
                        cantidadPlato.addEventListener('input', (event) => {
                            orderList.cantidadNumeros(event, cantidadPlato);
                        });
                    });

                } 
            });
        });
    }
    
    const pedidoForm = document.querySelector("#pedidoForm");
    
        
    pedidoForm.addEventListener('submit', (event) => {
        orderList.validarEnvio(event, pedidoForm);
    });    
    
    
    let pedido = document.querySelector("#platos-input");
    
    console.log(pedido);
    
    
    scrollArriba();
    
    
});


