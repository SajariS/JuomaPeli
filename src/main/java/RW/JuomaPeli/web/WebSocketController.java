package RW.JuomaPeli.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import RW.JuomaPeli.domain.Courier;

@Controller
public class WebSocketController {

	// Topic määrittää osoitteen josta käyttäjä tilaa viestejä
	// eli Vastaanotto ja samalla instanssi on /topic/input
	// Lähetys /app/courier
	//
	//Jatkokehitys, {code} on dynaaminen tila jonka käyttäjä voi "luoda"
	// ja muut voivat liittyä, eli kaksi clienttiä samalla code parametrillä voi keskustella
	@MessageMapping("/{code}")
	@SendTo("/topic/{code}")
	public Courier sendCourier(@DestinationVariable String code, Courier courier) {
		return courier;
	}
}
