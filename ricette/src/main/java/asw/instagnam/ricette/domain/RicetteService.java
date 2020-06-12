package asw.instagnam.ricette.domain;

import asw.instagnam.common.api.event.events.DomainEvent;
import asw.instagnam.common.api.event.events.RicettaCreatedEvent;
import asw.instagnam.ricette.domain.entities.RicettaCompleta;
import asw.instagnam.ricette.domain.repositories.RicetteRepository;
import asw.instagnam.ricette.producer.RicetteEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RicetteService {

	private final RicetteRepository ricetteRepository;
	private final RicetteEventProducer domainEventProducer;

	@Autowired
	public RicetteService(RicetteRepository ricetteRepository, RicetteEventProducer domainEventProducer) {
		this.ricetteRepository = ricetteRepository;
		this.domainEventProducer = domainEventProducer;
	}

	public RicettaCompleta createRicetta(String autore, String titolo, String preparazione) {
		RicettaCompleta ricetta = new RicettaCompleta(autore, titolo, preparazione); 
		ricetta = ricetteRepository.save(ricetta);
		DomainEvent event = new RicettaCreatedEvent(ricetta.getId(), ricetta.getAutore(), ricetta.getTitolo());
		domainEventProducer.produce(event);
		return ricetta;
	}

 	public RicettaCompleta getRicetta(Long id) {
		return ricetteRepository.findById(id).orElse(null);
	}

	public Collection<RicettaCompleta> getRicette() {
		return ricetteRepository.findAll();
	}

	public Collection<RicettaCompleta> getRicetteByAutore(String autore) {
		return ricetteRepository.findAllByAutore(autore);
	}

}
