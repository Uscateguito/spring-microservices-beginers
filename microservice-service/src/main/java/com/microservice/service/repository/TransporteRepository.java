package com.microservice.service.repository;


import com.microservice.service.model.TransportModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransporteRepository extends MongoRepository<TransportModel, String> {
}
