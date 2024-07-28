document.addEventListener('DOMContentLoaded', function () {
    // Seleccionar los elementos de entrada y vista
    const nombrePlato = document.getElementById('nombrePlato');
    const descripcionPlato = document.getElementById('descripcionPlato');
    const precioPlato = document.getElementById('precioPlato');
    const imagenPlato = document.getElementById('imagenPlato');
    
    console.log(imagenPlato);
    
    const vistaNombre = document.getElementById('vistaNombre');
    const vistaDescripcion = document.getElementById('vistaDescripcion');
    const vistaPrecio = document.getElementById('vistaPrecio');
    const vistaImg = document.getElementById('vistaImg');
    
    // Actualizar la vista en tiempo real
    nombrePlato.addEventListener('input', function () {
        vistaNombre.textContent = nombrePlato.value || vistaNombre.textContent;
    });
    
    descripcionPlato.addEventListener('input', function () {
        vistaDescripcion.textContent = descripcionPlato.value || vistaDescripcion.textContent;
    });
    
    precioPlato.addEventListener('input', function () {
        vistaPrecio.textContent = precioPlato.value ? `$${precioPlato.value}` : vistaPrecio.textContent;
    });
    
    imagenPlato.addEventListener('change', function () {
        const file = imagenPlato.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function (e) {
                vistaImg.style.backgroundImage = `url(${e.target.result})`;
                vistaImg.style.backgroundSize = 'cover';
                vistaImg.style.backgroundPosition = 'center';
            };
            reader.readAsDataURL(file);
        } else {
            vistaImg.style.backgroundImage = '';
        }
    });
});


