package RW.JuomaPeli.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RW.JuomaPeli.domain.Game;
import RW.JuomaPeli.domain.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gRepo;
	@Autowired
	private CardService cService;
	
	public Game setUpGame(String code) {
		Game game = new Game(code);
		//Jatko kehitys pelaaja määrään, mennään nyt neljällä alkuun
		game.setCards(cService.dealCards(4));
		return gRepo.save(game);
	}
	// TODO ManyToMany fiksit
}
