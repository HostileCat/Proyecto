// Obtener la URL actual
const url = new URL(window.location.href);

// Obtener el parámetro 'id'
const id = url.searchParams.get('id');

const inputId = document.getElementById('categoryId');
if (id !== null) {
    inputId.value = id;
}

