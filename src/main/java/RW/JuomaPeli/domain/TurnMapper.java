package RW.JuomaPeli.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnMapper {
	
	@Autowired
	private GameRepository gRepo;
	@Autowired
	private CharacterRepository cRepo;
	@Autowired
	private PlayerRepository pRepo;
	
	//Käsittelee annetun vuoron, eli siirtää vuoron seuraavalle, vetää pakasta kortin,
	//Ja nolla valinnan falseen
	public TurnDTO handleTurn(TurnDTO oldTurn) {
		Game game = gRepo.findByCode(oldTurn.getCode());
		Long nextPlayerId = null;
		Card pulledCard = null;
		
		for(Card card : game.getCards()) {
			if(card.getId() == oldTurn.getPulledCard().getId()) {
				int index = game.getCards().indexOf(card);
				
				if(index == -1) {
					//Ei löydy TODO käsittele virhe
				}
				else if(index == game.getCards().size() - 1) {
					//Listan viimeinen kortti, tee jotain?
					//Tällä hetkellä palauta ensimmäinen kortti
					pulledCard = game.getCards().get(0);
				}
				else {
					pulledCard = game.getCards().get(index + 1);
				}
			}
		}
		
		//Siirtää vuoron seuraavalle pelaajalle, arvo -> nextPlayerId
		for(Player player : game.getPlayer()) {
			if(player.getId() == oldTurn.getPlayersTurn()) {
				int index = game.getPlayer().indexOf(player);
				
				if(index == -1) {
					//Ei löydy TODO käsittele virhe
				}
				else if(index == game.getPlayer().size() - 1) {
					//Listan viimeinen, käsittele
					nextPlayerId = game.getPlayer().get(0).getId();
				}
				else {
					//Seuraava listasta
					nextPlayerId = game.getPlayer().get(index + 1).getId();
				}
			}
		}
		
		//Palautetaan "tuore" vuoro, seuraavan pelaajan id, pelin koodi, nostettu kortti ja pelaajan valinta
		return new TurnDTO(nextPlayerId, oldTurn.getCode(), pulledCard, false);
	}
	
	//Käsittelee hahmoon liittyvät toimeenpiteet, nollaa sen jne 
	public void handleCharecterChange(TurnDTO playerTurn) {
		Player player = pRepo.findById(playerTurn.getPlayersTurn()).get();
		Character character = cRepo.findByPlayer(player);
		List<Card> cards = character.getCard();
		
		//Valinta false, eli nollataan hahmo
		if(!playerTurn.isChoice())  {
			//Ei välttämättä toimi ManyToMany kanssa, pitää testata. Jos ei toimi niin delete ja uusi alle
			character.setCard(null);
		}
		else {
			cards.add(playerTurn.getPulledCard());
			character.setCard(cards);
		}
		
		cRepo.save(character);
	}

}
