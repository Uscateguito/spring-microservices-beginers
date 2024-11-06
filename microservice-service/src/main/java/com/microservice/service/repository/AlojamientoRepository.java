package com.microservice.service.repository;

import com.microservice.service.model.AlojamientoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlojamientoRepository extends MongoRepository<AlojamientoModel, String> {

}
