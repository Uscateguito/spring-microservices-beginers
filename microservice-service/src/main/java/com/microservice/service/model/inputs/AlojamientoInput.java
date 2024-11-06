package com.microservice.service.model.inputs;

public record AlojamientoInput(
        String nombre,
        String ubicacion,
        Float calificacion,
        Float precioPorNoche,
        String proveedorCorreo
) {
}
