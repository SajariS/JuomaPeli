package RW.JuomaPeli.web;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import RW.JuomaPeli.domain.Courier;

@Controller
public class WebSocketController {

	// Ohjain vastaanottaa clientistä JSON muodossa olion
	// ja palauttaa sen kaikille websocket "tilaajille"
	// Vastaanotto on /topic/input
	// Lähetys /app/courier
	@MessageMapping("/courier")
	@SendTo("/topic/input")
	public Courier sendCourier(Courier courier) {
		return courier;
	}
}
