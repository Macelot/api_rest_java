package exemplorest003;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Exemplorest003Application {
	
	private static final Logger log = LoggerFactory.getLogger(Exemplorest003Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Exemplorest003Application.class, args);
	}
	
	@GetMapping("/")
	public String bemVindo() {
		return "Bem Vindo";
	}
	
	 @Bean
	public CommandLineRunner exemplorest001(final UsuarioRepository repository) {
		return (args) -> {
			// save a few users
			repository.save(new Usuario("Jack","jack@server.com"));
			repository.save(new Usuario("Chloe","Chloe@server.com"));
			repository.save(new Usuario("Kim","kim@server.com"));
			repository.save(new Usuario("David","david@server.com"));
			repository.save(new Usuario("Michelle","michelle@server.com"));

			// fetch all users
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Usuario usuario : repository.findAll()) {
				log.info(usuario.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Optional<Usuario> usuario = repository.findById(1L);
			log.info("User found with findById(1):");
			log.info("--------------------------------");
			log.info(usuario.toString());
			log.info("");

		};
	}
	
	
	
	

}
