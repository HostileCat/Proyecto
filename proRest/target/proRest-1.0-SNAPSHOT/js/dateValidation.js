document.addEventListener('DOMContentLoaded', function () {
    let form = document.querySelector(".section__form");
    let button = document.querySelector(".section__addButton");

    const clienteInput = document.querySelector("#nombreCliente");
    
    const fechaReserva = document.querySelector('#fechaReserva');
    const horaReserva = document.querySelector('#horaReserva');
    
    fechaReserva.addEventListener('input', (event) =>{
        //registerValidation.cantidadLetras(event, fechaReserva);
        const today = new Date();
        const startDate = new Date(today);
        const endDate = new Date(today);
        endDate.setDate(today.getDate() + 7); // Limitar a una semana desde hoy

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
        
        
        
        // Validar fecha
        if (fecha < startDate || fecha > endDate) {
            isValid = false;
            let errorMessage = document.createElement("span");
            errorMessage.setAttribute("class", "errorMessage");
            console.log(errorMessage);
            errorMessage.setAttribute("id", "errorFecha");
            errorMessage.textContent = `La fecha no puede pasar de ${fechaCompletaFinal}, ni ser una fecha anterior a la actual`;
            let padre = fechaReserva.parentElement;
            
            padre.appendChild(errorMessage);
        }

    });
    
    horaReserva.addEventListener('input', (event) =>{
        const hora = new Date(`1970-01-01T${horaReserva.value}:00`);
        const horaInicio = new Date('1970-01-01T11:00:00');
        const horaFin = new Date('1970-01-01T23:00:00');
        
        
        // Validar hora
        if (hora < horaInicio || hora > horaFin) {
            isValid = false;
            let errorMessage = document.createElement("span");
            errorMessage.setAttribute("class", "errorMessage");
            console.log(errorMessage);
            errorMessage.setAttribute("id", "errorHora");
            errorMessage.textContent = `La hora debe estar entre las 11:00 AM y las 11:00 PM.`;
            let padre = horaReserva.parentElement;
            
            padre.appendChild(errorMessage);
        }
    }
    
    
    
    form.addEventListener('submit', (event) =>{
        const fechaReserva = document.querySelector('#fechaReserva');
        const horaReserva = document.querySelector('#horaReserva');
                
        const today = new Date();
        const startDate = new Date(today);
        const endDate = new Date(today);
        endDate.setDate(today.getDate() + 7); // Limitar a una semana desde hoy

        // Configurar fechas para comparación
        startDate.setHours(0, 0, 0, 0);
        endDate.setHours(23, 59, 59, 999);

        // Obtener fecha y hora como objeto Date
        const fecha = new Date(fechaReserva.value);
        const hora = new Date(`1970-01-01T${horaReserva.value}:00`);
        const horaInicio = new Date('1970-01-01T11:00:00');
        const horaFin = new Date('1970-01-01T23:00:00');

        let isValid = true;

        const fechaCompletaFinal = endDate.toLocaleDateString('es-ES', { 
            year: 'numeric', 
            month: '2-digit', 
            day: '2-digit' 
        });
        
        
        
        // Validar fecha
        if (fecha < startDate || fecha > endDate) {
            isValid = false;
            let errorMessage = document.createElement("span");
            errorMessage.setAttribute("class", "errorMessage");
            console.log(errorMessage);
            errorMessage.setAttribute("id", "errorFecha");
            errorMessage.textContent = `La fecha no puede pasar de ${fechaCompletaFinal}, ni ser una fecha anterior a la actual`;
            let padre = fechaReserva.parentElement;
            
            padre.appendChild(errorMessage);
        }

        // Validar hora
        if (hora < horaInicio || hora > horaFin) {
            isValid = false;
            let errorMessage = document.createElement("span");
            errorMessage.setAttribute("class", "errorMessage");
            console.log(errorMessage);
            errorMessage.setAttribute("id", "errorHora");
            errorMessage.textContent = `La hora debe estar entre las 11:00 AM y las 11:00 PM.`;
            let padre = horaReserva.parentElement;
            
            padre.appendChild(errorMessage);
        }

        // Mostrar mensaje de error o enviar formulario
        if (isValid) {
            
            document.getElementById('section__form').submit(); // Enviar el formulario
        }
    });   
    
});

