package asw.instagnam.ricette.rest;

import asw.instagnam.ricette.domain.entities.Ricetta;
import asw.instagnam.ricette.domain.entities.RicettaCompleta;
import asw.instagnam.ricette.domain.RicetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
public class RicetteController {

	@Autowired 
	private RicetteService ricetteService; 

	private final Logger logger = Logger.getLogger(RicetteController.class.toString()); 

	/* Crea un nuovo ristorante. 
	* la richiesta contiene nel corpo autore e titolo */ 
	@PostMapping("/ricette")
	public RicettaCompleta createRicetta(@RequestBody CreateRicettaRequest request) {
		String autore = request.getAutore();
		String titolo = request.getTitolo();
		String preparazione = request.getPreparazione();
		if(!ricetteService.existsRicetta(autore, titolo)) {
		logger.info("REST CALL: createRicetta " + autore + ", " + titolo + ", " + preparazione); 
		RicettaCompleta ricetta = ricetteService.createRicetta(autore, titolo, preparazione);
		return ricetta; }
		else {
			throw new ResponseStatusException(
				HttpStatus.BAD_REQUEST, "La ricetta è stata già inserita"
			);
		}
	}	

	/* Trova la ricetta con ricettaId. */ 
	@GetMapping("/ricette/{ricettaId}")
	public RicettaCompleta getRicetta(@PathVariable Long ricettaId) {
		logger.info("REST CALL: getRicetta " + ricettaId); 
		RicettaCompleta ricetta = ricetteService.getRicetta(ricettaId);
		if (ricetta!=null) {
			return ricetta;
		} else {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "Ricetta not found"
			);
		}
	}

	/* Trova tutte le ricette (in formato breve) (o tutte le ricette di autore). */ 
	@GetMapping("/ricette")
	public Collection<Ricetta> getRicette(@RequestParam(value="autore", required=false) String autore) {
		Collection<RicettaCompleta> ricette = null; 
		if (autore==null) {
			logger.info("REST CALL: getRicette"); 
			ricette = ricetteService.getRicette();
		} else {
			logger.info("REST CALL: getRicette " + autore); 
			ricette = ricetteService.getRicetteByAutore(autore);
		}
		return toRicetteBrevi(ricette);
	}
	
	/* Converte una collezione di ricette (in formato completo), in una collezione di ricette (in formato breve). */ 
	private Collection<Ricetta> toRicetteBrevi(Collection<RicettaCompleta> ricetteComplete) {
		Collection<Ricetta> ricette = 
			ricetteComplete
				.stream()
				.map(r -> new Ricetta(r))
				.collect(Collectors.toList());
		return ricette; 
	}

}
