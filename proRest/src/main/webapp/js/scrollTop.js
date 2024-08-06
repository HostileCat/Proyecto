export const scrollArriba = function (){
    let scrollToTopBtn = document.getElementById("scrollToTopBtn");

    // Mostrar el botón cuando el usuario hace scroll hacia abajo
    window.onscroll = function() {
        if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
            scrollToTopBtn.style.display = "block";
        } else {
            scrollToTopBtn.style.display = "none";
        }
    };

    // Cuando el usuario hace clic en el botón, subir a la parte superior
    scrollToTopBtn.onclick = function() {
        document.documentElement.scrollTop = 0; 
    };
};


