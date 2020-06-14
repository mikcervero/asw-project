package asw.instagnam.connessioni.rest;

import asw.instagnam.connessioni.domain.entities.Connessione;
import asw.instagnam.connessioni.domain.ConnessioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.logging.Logger;

@RestController
public class ConnessioniController {

	@Autowired 
	private ConnessioniService connessioniService; 

	private final Logger logger = Logger.getLogger(ConnessioniController.class.toString()); 

	/* Crea una nuova connessione. 
	* la richiesta contiene nel corpo una stringa della forma follower:followed */ 
	@PostMapping("/connessioni")
	public Connessione createConnessione(@RequestBody CreateConnessioneRequest request) {
		String follower = request.getFollower();
		String followed = request.getFollowed();
		if(!connessioniService.existsConnessione(follower, followed)) {
		logger.info("REST CALL: createConnessione " + follower + ", " + followed); 
		Connessione connessione = connessioniService.createConnessione(follower, followed);
		return connessione; }
		else {
			throw new ResponseStatusException(
				HttpStatus.BAD_REQUEST, "La connessione è stata già inserita"
			);
		}
	}	

	/* Trova la connessione con connessioneId. */ 
	@GetMapping("/connessioni/{connessioneId}")
	public Connessione getConnessione(@PathVariable Long connessioneId) {
		logger.info("REST CALL: getConnessione " + connessioneId); 
		Connessione connessione = connessioniService.getConnessione(connessioneId);
		if (connessione!=null) {
			return connessione;
		} else {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "Connessione not found"
			);
		}
	}

	/* Trova tutte le connessioni (o tutte le connessioni di follower). */ 
	@GetMapping("/connessioni")
	public Collection<Connessione> getConnessioni(@RequestParam(value="follower", required=false) String follower) {
		Collection<Connessione> connessioni = null; 
		if (follower==null) {
			logger.info("REST CALL: getConnessioni"); 
			connessioni = connessioniService.getConnessioni();
		} else {
			logger.info("REST CALL: getConnessioni " + follower); 
			connessioni = connessioniService.getConnessioniByFollower(follower);
		}
		return connessioni;
	}

}
