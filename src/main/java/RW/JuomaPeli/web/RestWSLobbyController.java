package RW.JuomaPeli.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import RW.JuomaPeli.domain.Player;
import RW.JuomaPeli.domain.PlayerRepository;

@RestController
public class RestWSLobbyController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	@Autowired
	private PlayerRepository pRepo;
	
	@DeleteMapping("/wsapi/lobby")
	public void removePlayer(@RequestBody Player player) {
		try {
			pRepo.deleteById(player.getId());
			messagingTemplate.convertAndSend("/lobby/" + player.getCode(), pRepo.findByCode(player.getCode()));
		}
		catch(IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	/*
	 * Vastaanottaa DELETE kutsun, poistaa pelaajan kannasta kokonaan
	 * ja palauttaa poistetun pelaajan koodilla luodun listan pelaajista,
	 * - /topic/<koodi> kanavan tilaajille
	 * 
	 * Frontin puolella SockJS/WebSocket .onClose metodilla, luodaan tarvittava koodi
	 * fetch kutsuun ja beforeunload event listenerillä yritetään taata, että koodi ajetaan
	 * kun käyttäjä sulkee selaimen
	 */
	
}


