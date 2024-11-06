package com.cloud.gentebuenagente.servicios_servicios;

//import com.cloud.gentebuenagente.servicios_servicios.utils.DataLoader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
public class ServiciosServiciosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiciosServiciosApplication.class, args);
	}

//	@Bean
//	CommandLineRunner cargarDatos(DataLoader dataLoader) {
//		return args -> dataLoader.cargarDatos();
//	}
}
