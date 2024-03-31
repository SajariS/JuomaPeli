package RW.JuomaPeli.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import RW.JuomaPeli.domain.*;
import RW.JuomaPeli.dto.PlayerDTO;
import RW.JuomaPeli.service.PlayerService;


@RestController
public class RestPlayerController {
    
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerService playerService;
    
    @GetMapping("/api/players")
    public ResponseEntity<List<Player>> getPlayerList() {
        List<Player> players = (List<Player>) playerRepository.findAll();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
    
    @PostMapping("/api/players")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
    	System.out.println(player.getHost());
        if(player.getHost()) {
        	player.setGame(gameRepository.save(new Game(player.getCode())));
        }
        else  {
        	player.setGame(gameRepository.findByCode(player.getCode()));
        }
        return new ResponseEntity<>(playerRepository.save(player), HttpStatus.CREATED);
    }
    
}
