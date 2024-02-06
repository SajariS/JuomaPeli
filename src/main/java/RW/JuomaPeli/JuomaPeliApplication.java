package RW.JuomaPeli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import RW.JuomaPeli.domain.Card;
import RW.JuomaPeli.domain.CardRepository;

@SpringBootApplication
public class JuomaPeliApplication {

	public static void main(String[] args) {
		SpringApplication.run(JuomaPeliApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo (CardRepository cRepo) {
		return (args) -> {
			cRepo.save(new Card("Testi", "Testidesc", false));
		};
	}

}
