package br.com.casadocodigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class CasadocodigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasadocodigoApplication.class, args);
	}

}
