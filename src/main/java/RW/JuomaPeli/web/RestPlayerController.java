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
public class RestPlayerController {
    
    @Autowired
    private PlayerRepository playerRepository;
    
    @GetMapping("/api/player")
    public ResponseEntity<List<Player>> getPlayerList() {
        List<Player> players = (List<Player>) playerRepository.findAll();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
    
    @PostMapping("/api/player")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player addedPlayer = playerRepository.save(player);
        return new ResponseEntity<>(addedPlayer, HttpStatus.CREATED);
    }
}
