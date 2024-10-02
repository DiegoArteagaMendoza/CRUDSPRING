document.getElementById('registroForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const nombre = document.getElementById('nombre').value;
    const apellido = document.getElementById('apellido').value;
    const rut = document.getElementById('rut').value;
    const email = document.getElementById('email').value;
    const telefono = document.getElementById('telefono').value;
    const rol = document.getElementById('rol').value;
    const password = document.getElementById('password').value;

    const datos = {
        nombre: nombre,
        apellido: apellido,
        rut: rut,
        email: email,
        telefono: telefono,
        rol: rol,
        password: password
    };

    fetch('http://localhost:8080/user/create', {  // Cambia esta URL según tu configuración
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    })
    .then(response => {
        if (response.ok) {
            alert("Registro exitoso");
        } else {
            alert("Error en el registro");
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert("Error al conectar con la API");
    });
});
