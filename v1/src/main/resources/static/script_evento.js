        // Mostrar el formulario al hacer clic en "Agregar Nuevo Evento"
document.getElementById('agregar-evento-btn').addEventListener('click', function () {
    const formContainer = document.getElementById('form-container');
    if (formContainer.style.display === 'none' || formContainer.style.display === '') {
        formContainer.style.display = 'block';
    } else {
        formContainer.style.display = 'none';
    }
});

// Agregar un nuevo evento al hacer clic en "Guardar Evento"
document.getElementById('guardar-evento-btn').addEventListener('click', function () {
    // Obtener los valores del formulario
    const nombre = document.getElementById('nombre').value;
    const descripcion = document.getElementById('descripcion').value;
    const fecha = document.getElementById('fecha').value;

    // Validar que los campos no estén vacíos
    if (nombre && descripcion && fecha) {
        // Crear una nueva fila para la tabla
        const newRow = document.createElement('tr');
        newRow.innerHTML = `
            <td>${nombre}</td>
            <td>${descripcion}</td>
            <td>${fecha}</td>
        `;

        // Agregar la nueva fila a la tabla
        document.getElementById('eventos-table-body').appendChild(newRow);

        // Limpiar el formulario
        document.getElementById('nombre').value = '';
        document.getElementById('descripcion').value = '';
        document.getElementById('fecha').value = '';

        // Ocultar el formulario
        document.getElementById('form-container').style.display = 'none';
    } else {
        alert('Por favor, completa todos los campos.');
    }
});