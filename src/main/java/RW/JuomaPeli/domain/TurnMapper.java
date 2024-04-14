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
	@Autowired
	private GameMapper gMapper;
	@Autowired
	private CharacterMapper cMapper;
	
	//Käsittelee annetun vuoron, eli siirtää vuoron seuraavalle, vetää pakasta kortin,
	//Ja nolla valinnan falseen
	// TODO Korjaa ManyToMany fiksiin
	public TurnDTO handleTurn(TurnDTO oldTurn) {
		GameDTO gameDto = gMapper.GameToDto(gRepo.findByCode(oldTurn.getCode()));
		Long nextPlayerId = null;
		Card pulledCard = null;
		
		for(Card card : gameDto.getCards()) {
			if(card.getId() == oldTurn.getPulledCard().getId()) {
				int index = gameDto.getCards().indexOf(card);
				
				if(index == -1) {
					//Ei löydy TODO käsittele virhe
				}
				else if(index == gameDto.getCards().size() - 1) {
					//Listan viimeinen kortti, tee jotain?
					//Tällä hetkellä palauta ensimmäinen kortti
					pulledCard = gameDto.getCards().get(0);
					System.out.println(pulledCard.getId());
				}
				else {
					pulledCard = gameDto.getCards().get(index + 1);
					System.out.println(pulledCard.getId());
				}
			}
		}
		
		//Siirtää vuoron seuraavalle pelaajalle, arvo -> nextPlayerId
		for(Player player : gameDto.getPlayers()) {
			if(player.getId() == oldTurn.getPlayersTurn()) {
				int index = gameDto.getPlayers().indexOf(player);
				
				if(index == -1) {
					//Ei löydy TODO käsittele virhe
				}
				else if(index == gameDto.getPlayers().size() - 1) {
					//Listan viimeinen, käsittele
					nextPlayerId = gameDto.getPlayers().get(0).getId();
				}
				else {
					//Seuraava listasta
					nextPlayerId = gameDto.getPlayers().get(index + 1).getId();
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
		
		//Valinta false, eli nollataan hahmo
		if(!playerTurn.isChoice())  {
			//Ei välttämättä toimi ManyToMany kanssa, pitää testata. Jos ei toimi niin delete ja uusi alle
			character.getCharacterCard().clear();
		}
		else {
			//karvalakki korjaus paskaan sekoitukseen :D
			//Jos lisättävä kortti on jo valmiiksi hahmon "omistuksessa" skipataan lisäys
			//Näin vältytään kaatuilu
			boolean exists = false;
			for(Card card : character.getCharacterCard()) {
				if(card.getId() == playerTurn.getPulledCard().getId()) {
					exists = true;
					System.out.println("Kopio!");
					break;
				}
			}
			
			if(!exists) {
				character.getCharacterCard().add(playerTurn.getPulledCard());
			}
		}
		
		cRepo.save(character);
	}
	
	public TurnDTO handleStart(String code) {
		GameDTO gameDto = gMapper.GameToDto(gRepo.findByCode(code));
		System.out.println(gameDto.getCards().size());
		Player firstPlayer = gameDto.getPlayers().get(0);
		return new TurnDTO(firstPlayer.getId(), code, gameDto.getCards().get(0), false);

	}

}
