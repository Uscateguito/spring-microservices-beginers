package com.microservice.service.repository;

import com.microservice.service.model.intermedias.Alojamiento_Proveedor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface Alojamiento_ProveedorRepository extends MongoRepository<Alojamiento_Proveedor, String> {

    List<Alojamiento_Proveedor> findAllByProveedor_Correo(String correo);
    int countAllByProveedor_Correo(String correo);
}
