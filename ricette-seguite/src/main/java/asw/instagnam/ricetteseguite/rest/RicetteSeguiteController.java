package asw.instagnam.ricetteseguite.rest;

import asw.instagnam.ricetteseguite.domain.entities.Ricetta;
import asw.instagnam.ricetteseguite.domain.RicetteSeguiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.logging.Logger;

@RestController
public class RicetteSeguiteController {

	private final Logger logger = Logger.getLogger(RicetteSeguiteController.class.toString()); 

	@Autowired 
	private RicetteSeguiteService ricetteSeguiteService;

	/* Trova le ricette (in formato breve) degli utenti seguiti da utente. */ 
	@GetMapping("/ricetteseguite/{utente}")
	public Collection<Ricetta> getRicetteSeguite(@PathVariable String utente) {
		logger.info("REST CALL: getRicetteSeguite " + utente); 
		Collection<Ricetta> ricette = ricetteSeguiteService.getRicetteSeguite(utente); 
		logger.info("getRicetteSeguite(): " + ricette);
		return ricette; 
	}
	
}