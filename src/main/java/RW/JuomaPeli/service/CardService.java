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
        Collections.shuffle(allCards);

        List<Card> dealtCards = new ArrayList<>();
        int totalCardsToDeal = numberOfPlayers * 6;

        for (int i = 0; i < totalCardsToDeal; i++) {
            dealtCards.add(allCards.get(i));
        }

        return dealtCards;
    }
	
}
