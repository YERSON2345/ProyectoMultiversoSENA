function eliminar() {
    Swal.fire({
        title: "¿Quieres eliminar este registro?",
        text: "Estos cambios no serán reversibles",
        icon: 'question',
        footer: 'Si pasan 10sec se cerrara esta ventana',
        backdrop: true,
        timer: 10000,
        timerProgressBar: true,
        allowOutsideClick: false,
        allowEscapeKey: false,
        allowEnterKey: false,
        stopKeydownProgation: true,
        showConfirmButton: true,
        confirmButtonText:'<a href="proveedor?condicion=eliminar&id=${proveedor.getIdProveedor()}">Sí, deseo eliminar</a>',
        showCancelButton:true,
        cancelButtonText: 'No, no deseo eliminar'
    });
}