package com.microservice.service.model.inputs;

public record ProveedorInput(
        String nombre,
        String correo,
        int edad,
        String foto,
        String descripcion,
        String telefono,
        String pagWeb,
        String contactoRedes,
        String alojamientoId,
        String transportesId
) {

}
