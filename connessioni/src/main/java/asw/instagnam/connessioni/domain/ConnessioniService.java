package asw.instagnam.connessioni.domain;

import asw.instagnam.common.api.event.events.ConnessioneCreatedEvent;
import asw.instagnam.common.api.event.events.DomainEvent;
import asw.instagnam.common.api.event.producer.DomainEventProducer;
import asw.instagnam.connessioni.domain.entities.Connessione;
import asw.instagnam.connessioni.domain.repositories.ConnessioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class ConnessioniService {

	private final ConnessioniRepository connessioniRepository;
	private final DomainEventProducer domainEventProducer;

	@Autowired
	public ConnessioniService(ConnessioniRepository connessioniRepository, DomainEventProducer domainEventProducer) {
		this.connessioniRepository = connessioniRepository;
		this.domainEventProducer = domainEventProducer;
	}

    public boolean existsConnessione(String follower,String followed) {
    	return connessioniRepository.existsByFollowerAndFollowed(follower, followed);
    }
    
    
	public Connessione createConnessione(String follower, String followed) {
		Connessione connessione = new Connessione(getLongIdFromUUID(), follower, followed); 
		connessione = connessioniRepository.save(connessione);
		DomainEvent event = new ConnessioneCreatedEvent(connessione.getUuid(), connessione.getFollower(), connessione.getFollowed());
		domainEventProducer.produce(event);
		return connessione;
	}

 	public Connessione getConnessione(Long id) {
		Connessione connessione = connessioniRepository.findByUuid(id);;
		return connessione;
	}

 	public Collection<Connessione> getConnessioni() {
		Collection<Connessione> connessioni = connessioniRepository.findAll();
		return connessioni;
	}

	public Collection<Connessione> getConnessioniByFollower(String follower) {
		Collection<Connessione> connessioni = connessioniRepository.findAllByFollower(follower);
		return connessioni;
	}

	
	private Long getLongIdFromUUID() {
		return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
	}


}
