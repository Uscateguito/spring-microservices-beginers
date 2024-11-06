package com.microservice.service.repository;

import com.microservice.service.model.ProviderModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends MongoRepository<ProviderModel, String> {
    ProviderModel findByCorreo(String correo);
    boolean deleteByCorreo(String correo);
}
