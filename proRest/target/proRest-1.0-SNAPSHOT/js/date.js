document.addEventListener('DOMContentLoaded', function () {
    let button = document.querySelector(".section__addButton");
    
    let fechaReserva = document.querySelectorAll("#fechaReserva");
    let horaReserva = document.querySelectorAll("#horaReserva");
    
    let today = new Date();
    let nextWeek = new Date();
    nextWeek.setDate(today.getDate() + 7);
    
    let fechaSeleccionada = fechaReserva.values;
    
    console.log(today);
    console.log(nextWeek);
    
    button.addEventListener('click', function(event){
        
        
        console.log(fechaReserva);
        console.log(horaReserva);
        console.log(fechaSeleccionada);
    });
});

