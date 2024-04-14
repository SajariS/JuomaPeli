package RW.JuomaPeli.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RW.JuomaPeli.domain.*;
import RW.JuomaPeli.domain.Character;

@Service
public class CharacterService {
	
	@Autowired
	private CharacterRepository cRepo;

	public Character createNewCharacter(Player player) {
		Random random = new Random();
		//TODO Generoi nimi
		String name = "Pirkko";
		int age = random.nextInt(100 - 18 + 1) + 18;
		return cRepo.save(new Character(name, age, player));
	}
}
