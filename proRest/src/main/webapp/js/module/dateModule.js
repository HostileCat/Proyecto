const validarFecha = (event, fechaReserva) =>{
    const today = new Date();
    const startDate = new Date(today);
    const endDate = new Date(today);
    endDate.setDate(today.getDate() + 20); // Limitar a una semana desde hoy

    // Configurar fechas para comparación
    startDate.setHours(0, 0, 0, 0);
    endDate.setHours(23, 59, 59, 999);

    // Obtener fecha y hora como objeto Date
    const fecha = new Date(fechaReserva.value);
        

    let isValid = true;
    const fechaCompletaFinal = endDate.toLocaleDateString('es-ES', { 
        year: 'numeric', 
        month: '2-digit', 
        day: '2-digit' 
    });
        
    let errorMessage = document.createElement("span");
    errorMessage.setAttribute("class", "errorMessage");
    errorMessage.setAttribute("id", "errorFecha");
    errorMessage.textContent = `La fecha no puede pasar de ${fechaCompletaFinal}, ni ser una fecha anterior a la actual`;
    let padre = fechaReserva.parentElement;
    
    let errorExistente = document.querySelector("#errorFecha");
    // Validar fecha
    if (fecha < startDate || fecha > endDate) {        
        fechaReserva.classList.add("input__error");   
        if (errorExistente === null) {
            padre.appendChild(errorMessage);
        }
    } else{
        fechaReserva.classList.remove("input__error");   
        if (errorExistente !== null) {
            padre.removeChild(errorExistente);
        }
    }    
};

const validarHora = (event, horaReserva) =>{
    const hora = new Date(`1970-01-01T${horaReserva.value}:00`);
    const horaInicio = new Date('1970-01-01T11:00:00');
    const horaFin = new Date('1970-01-01T23:00:00');
       
    let errorMessage = document.createElement("span");
    errorMessage.setAttribute("class", "errorMessage");
    errorMessage.setAttribute("id", "errorHora");
    errorMessage.textContent = `La hora debe estar entre las 11:00 AM y las 11:00 PM.`;
    let padre = horaReserva.parentElement;    
    
    let errorExistente = document.querySelector("#errorHora");
    
    // Validar hora
    if (hora < horaInicio || hora > horaFin) {
        horaReserva.classList.add("input__error");   
        if (errorExistente === null) {
            padre.appendChild(errorMessage);
        }
    } else{
        horaReserva.classList.remove("input__error");   
        if (errorExistente !== null) {
            padre.removeChild(errorExistente);
        }
    }
};

const validarEnvio = (event, submitButton) => {
    let todosLosCampos = document.querySelectorAll(".add__input");
    
    let campoVacio = false;
    
    todosLosCampos.forEach(input =>{
        if (input.value.trim() === '') {
            campoVacio = true;
        }
    });
    
    let errorMessage = document.createElement("span");
    errorMessage.setAttribute("id", "errorEnviar");
    errorMessage.setAttribute("class", "errorMessage");
    errorMessage.classList.add("errorMessage--submit");
    errorMessage.textContent = "Completa todos los campos antes de enviar.";
    
    const contenedor = submitButton.parentElement;
    let errorExistente = document.querySelector("#errorEnviar");
    
    if(campoVacio){
        if (errorExistente === null) {
            contenedor.prepend(errorMessage);
        }
    } else{
        if (errorExistente !== null) {
            console.log(errorMessage);
            contenedor.removeChild(errorExistente);
        }
    }
    
    let mensajesError = document.querySelectorAll(".errorMessage");
    
    console.log(mensajesError);

    if(mensajesError.length > 0){
        event.preventDefault();

    } else{
        alert("Registro exitoso.");
    }
};


export { validarFecha, validarHora, validarEnvio };


