$(document).ready(function () {
    $("tr #delProveedor").click(function (e) {
        e.preventDefault();
        var cod = $(this).parent().find('#codigo').val();
        swal({
            title: "Está seguro de eliminar?",
            text: "Una vez eliminado deberá agregar de nuevo!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Si, eliminar!",
            cancelButtonText: "No, cancelar!",
            closeOnConfirm: false,
            closeOnCancel: false
        },
            function (isConfirm) {
                if (isConfirm) {
                    eliminarProveedor(cod);
                    swal("Eliminado!", "Una vez eliminado deberá agregar de nuevo.", "success");
                    setTimeout(function(){
                        parent.location.href = "proveedor?condicion=consultarProveedor"
                    }, 1800);
                } else {
                    swal("Cancelled", "Cancelaste la eliminación", "error");
                }
            });
    });

    function eliminarProveedor(cod) {
        var url = "proveedor?condicion=eliminar&cod=" + cod;
        console.log("Eliminado");
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            success: function (r){

            }
        });
    }
});