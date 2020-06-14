package asw.instagnam.ricetteseguite.consumer;

import asw.instagnam.common.api.event.events.DomainEvent;
import asw.instagnam.common.api.event.events.RicettaCreatedEvent;
import asw.instagnam.common.api.event.Topic;
import asw.instagnam.ricetteseguite.domain.RicetteSeguiteService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RicetteDomainEventConsumer implements DomainEventConsumer {

	private final RicetteSeguiteService service;

	@Autowired
	public RicetteDomainEventConsumer(RicetteSeguiteService ricetteSeguiteService) {
		this.service = ricetteSeguiteService;
	}

	@KafkaListener(topics = Topic.ricette)
	public void onEvent(ConsumerRecord<String, DomainEvent> evt) {
		if(evt.value().getClass().equals(RicettaCreatedEvent.class)){
			RicettaCreatedEvent event = (RicettaCreatedEvent) evt.value();
			service.addRicetta(event.getId(), event.getAutore(), event.getTitolo());
		}
	}

}