package br.com.receita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API - App Receitas",
				version = "1.0",
				description = "API para aplicativo de receitas.",
				contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
)
public class AppReceitaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppReceitaApplication.class, args);
	}

}
