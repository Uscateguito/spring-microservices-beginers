package com.microservice.service.model.inputs;

public record TransporteInput(

        String tipo,
        int capacidad,
        String operador,
        float precio,
        float calificacion,
        String origen,
        String destino,
        String fechaSalida,
        String horaSalida,
        int duracionEstimada,
        String proveedorCorreo
) {
}
