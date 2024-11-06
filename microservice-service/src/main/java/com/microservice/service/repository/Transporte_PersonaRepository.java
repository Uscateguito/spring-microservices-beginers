package com.microservice.service.repository;

import com.microservice.service.model.intermedias.Transporte_Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Transporte_PersonaRepository extends MongoRepository<Transporte_Persona, String> {

    List<Transporte_Persona> findAllByCliente_Correo(String correo);
    int countAllByCliente_Correo(String correo);
}
