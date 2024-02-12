package RW.JuomaPeli;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import RW.JuomaPeli.domain.Card;
import RW.JuomaPeli.domain.CardRepository;
import RW.JuomaPeli.domain.Character;
import RW.JuomaPeli.domain.CharacterRepository;
import RW.JuomaPeli.domain.Player;
import RW.JuomaPeli.domain.PlayerRepository;

@SpringBootApplication
public class JuomaPeliApplication {

	public static void main(String[] args) {
		SpringApplication.run(JuomaPeliApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo (CardRepository cRepo, PlayerRepository pRepo, CharacterRepository characterRepo){
		return (args) -> {
			cRepo.save(new Card("Testi", "Testidesc", false));
			pRepo.save(new Player("pelaaja"));
			characterRepo.save(new Character("Kumppani", 30, null, pRepo.findByUserName("pelaaja")));
		};
	}

}
