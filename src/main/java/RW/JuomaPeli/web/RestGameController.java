package RW.JuomaPeli.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import RW.JuomaPeli.domain.Game;
import RW.JuomaPeli.domain.GameRepository;

@RestController
public class RestGameController {
	
	@Autowired
	private GameRepository gRepo;
	
	
	@GetMapping("/api/games/{id}")
	public ResponseEntity<Game> checkGameById(@PathVariable("id") Long id) {
		Optional<Game> game = gRepo.findById(id);
		
		if(game.isPresent()) {
			return new ResponseEntity<>(game.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
