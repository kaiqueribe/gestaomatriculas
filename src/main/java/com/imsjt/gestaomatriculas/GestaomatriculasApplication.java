package com.imsjt.gestaomatriculas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(info = @Info(title = "IMSJT", version = "1", description = "API para gestão de matrículas"))
@SpringBootApplication
public class GestaomatriculasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaomatriculasApplication.class, args);
	}

}
