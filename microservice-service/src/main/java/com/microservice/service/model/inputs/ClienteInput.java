package com.microservice.service.model.inputs;

public record ClienteInput(
        String nombre,
        String correo,
        int edad,
        String foto,
        String descripcion,
        String alojamientoId,
        String transporteId
) {
}
