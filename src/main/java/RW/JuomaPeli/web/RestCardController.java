package RW.JuomaPeli.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import RW.JuomaPeli.domain.*;

@RestController
public class RestCardController {
	
	@Autowired
	private CardRepository cRepo;
	
	
	//Tällä hetkellä palauttaa ja pyytää suoraan entityjä, tulevaisuudessa vaihtuu DTO:si
	@GetMapping("/api/cards")
	public ResponseEntity<List<Card>> cardListRest() {
		List<Card> cards = (List<Card>) cRepo.findAll();
		return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
	}
	
	@PostMapping("/api/cards")
	public ResponseEntity<Card> addCard(@RequestBody Card card) {
		Card addedCard = cRepo.save(card);
		return new ResponseEntity<Card>(addedCard, HttpStatus.OK);
	}
}
