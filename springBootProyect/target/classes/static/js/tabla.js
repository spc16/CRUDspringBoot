$(document).ready(function() {
    cargarUsuarios();

});

async function cargarUsuarios(){
    try{
        const request = await fetch('/listar', {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
        let alumnos = await request.json();
        let listadoHTML = "";
        for(let alumno of alumnos){
            let alumnoHTML = '<tr><th scope="row">' + alumno.id + '</th><td>' + alumno.nombre + '</td><td>' + alumno.apellido + '</td><td>' + alumno.nota + '</td></tr>';
            listadoHTML += alumnoHTML;
        }
        document.querySelector("#notas tbody").innerHTML = listadoHTML;
    }catch(e){
        console.log(e);
    }
}

async function guardarAlumno(){
    const nombre = document.getElementById('nombre').value;
    const apellido = document.getElementById('apellido').value;
    const nota = document.getElementById('nota').value;

    try {
    const request = await fetch(`/insertar/${nombre}/${apellido}/${nota}`, {
        method: 'GET'
    });

    cargarUsuarios();
    } catch (e) {
        console.log(e);
    }




}

async function eliminarAlumno(){
    const id = document.getElementById('id').value;
    try {
        const request = await fetch(`/eliminar/${id}`, {
            method: 'DELETE'
        });

    cargarUsuarios();
    } catch (e) {
        console.log(e);
    }
}



    async function actualizarAlumno(){
        const id = document.getElementById('id').value;
        const nombre = document.getElementById('nombre').value;
        const apellido = document.getElementById('apellido').value;
        const nota = document.getElementById('nota').value;

        const nuevaNota = {
            id: id,
            Nombre: nombre,
            Apellidos: apellido,
            Nota: nota
            }

        try {
            const request = await fetch(`/modificar/${nombre}/${apellido}/${nota}/${id}`, {
                method: 'PUT',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'

                },
                body: JSON.stringify(nuevaNota)

            });

            cargarUsuarios();
            } catch (e) {
                console.log(e);
            }
    }