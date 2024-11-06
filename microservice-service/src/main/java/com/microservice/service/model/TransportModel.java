package com.microservice.service.model;

import com.microservice.service.model.patrones.Servicio;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document("Transporte")
public class TransportModel implements Servicio {
    
    @Id
    private String id;

    private String tipo; // e.g., taxi, bus, tren
    private int capacidad; // en personas
    private String operador;
    private float precio;
    private float calificacion;
    private String origen;
    private String destino;
    private String fechaSalida;
    private String horaSalida;
    private int duracionEstimada; // en minutos

    @DBRef
    private ProviderModel proveedor;

}
