const cancelarReserva = (event, formCancelar) =>{
    event.preventDefault();

            
    // Mostrar un mensaje de confirmación al usuario
    
    const confirmContainer = document.querySelector('#confirm');    
    confirmContainer.classList.add("show");
    
    let question = confirmContainer.querySelector("#question");    
    question.textContent = "¿Está seguro de cancelar la reserva?";

    confirmContainer.querySelector("#yesBtn").addEventListener('click', ()=>{    
        confirmContainer.classList.remove("show");        
        formCancelar.submit();        
    });

    
    confirmContainer.querySelector("#noBtn").addEventListener('click', ()=>{    
        confirmContainer.classList.remove("show");        
    });
};

const confirmarReserva = (event, formConfirmar) =>{
    event.preventDefault();

            
    // Mostrar un mensaje de confirmación al usuario
    
    const confirmContainer = document.querySelector('#confirm');    
    confirmContainer.classList.add("show");
    
    let question = confirmContainer.querySelector("#question");    
    question.textContent = "¿Está seguro de confirmar la reserva?";

    confirmContainer.querySelector("#yesBtn").addEventListener('click', ()=>{    
        confirmContainer.classList.remove("show");        
        formConfirmar.submit();        
    });

    
    confirmContainer.querySelector("#noBtn").addEventListener('click', ()=>{    
        confirmContainer.classList.remove("show");        
    });
};

const terminarReserva = (event, formTerminar) =>{
    event.preventDefault();
   
    // Mostrar un mensaje de confirmación al usuario
    
    const confirmContainer = document.querySelector('#confirm');    
    confirmContainer.classList.add("show");
    
    let question = confirmContainer.querySelector("#question");    
    question.textContent = "¿Está seguro de terminar la reserva?";

    confirmContainer.querySelector("#yesBtn").addEventListener('click', ()=>{    
        confirmContainer.classList.remove("show");        
        formTerminar.submit();        
    });

    
    confirmContainer.querySelector("#noBtn").addEventListener('click', ()=>{    
        confirmContainer.classList.remove("show");        
    });
};


export { cancelarReserva, confirmarReserva, terminarReserva };