package RW.JuomaPeli.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RW.JuomaPeli.domain.Card;
import RW.JuomaPeli.domain.CardRepository;

@Service
public class CardService {
	
	@Autowired
    private CardRepository cardRepository;

    public List<Card> dealCards(int numberOfPlayers) {
    	List<Card> allCards = (List<Card>) cardRepository.findAll();
    	List<Card> goodCards = new ArrayList<>();
    	List<Card> badCards = new ArrayList<>();
    	
    	for(int i = 0; i < allCards.size(); i++) {
    		Card card = allCards.get(i);
    		if(card.getGoodTrait()) {
    			goodCards.add(card);
    		}
    		else {
    			badCards.add(card);
    		}
    	}
    	
    	goodCards.addAll(badCards);
    	return goodCards;
    	
    	/*
    	 * Vedetään ns. pakasta päällimäinen kortti vuorolla, jolloin jokaiselle pelaajalle ei tavitse jakaa "kättä" suoraan
    	 * Hyvä ratkaisu, ei vaan sovi tähän 
        Collections.shuffle(goodCards);
        Collections.shuffle(badCards);

        List<List<Card>> dealtCards = new ArrayList<>();

        for (int i = 0; i < numberOfPlayers; i++) {
        	List<Card> hand = new ArrayList<>();
        	for (int j = 0; j < 3; j++) {
                hand.add(goodCards.remove(0));
            }
        	for (int j = 0; j < 3; j++) {
                hand.add(badCards.remove(0));
            }
        	dealtCards.add(hand);
        }

        return dealtCards; 
        */
    }
	
}
