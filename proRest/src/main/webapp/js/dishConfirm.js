document.addEventListener("DOMContentLoaded", function () {
    let formEliminar = document.querySelector('#formEliminar');       
    
    if(formEliminar !== null){
        formEliminar.addEventListener('submit', function(event) {
            event.preventDefault();
            // Mostrar un mensaje de confirmación al usuario

            const confirmContainer = document.querySelector('#confirm');    
            confirmContainer.classList.add("show");

            let question = confirmContainer.querySelector("#question");    
            question.textContent = "¿Está seguro de eliminar la categoria?";

            confirmContainer.querySelector("#yesBtn").addEventListener('click', ()=>{    
                confirmContainer.classList.remove("show");        
                formEliminar.submit();        
            });


            confirmContainer.querySelector("#noBtn").addEventListener('click', ()=>{    
                confirmContainer.classList.remove("show");        
            });
        });  
    }
});

