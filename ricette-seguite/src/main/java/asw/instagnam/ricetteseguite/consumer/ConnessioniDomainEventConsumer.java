package asw.instagnam.ricetteseguite.consumer;

import asw.instagnam.common.api.event.events.ConnessioneCreatedEvent;
import asw.instagnam.common.api.event.Topic;
import asw.instagnam.common.api.event.events.DomainEvent;
import asw.instagnam.ricetteseguite.domain.RicetteSeguiteService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class ConnessioniDomainEventConsumer implements DomainEventConsumer {

	private final RicetteSeguiteService service;

	@Autowired
	public ConnessioniDomainEventConsumer(RicetteSeguiteService ricetteSeguiteService) {
		this.service = ricetteSeguiteService;
	}

	@KafkaListener(topics = Topic.connessioni)
	public void onEvent(ConsumerRecord<String, DomainEvent> evt) {
		if(evt.value().getClass().equals(ConnessioneCreatedEvent.class)){
			ConnessioneCreatedEvent event = (ConnessioneCreatedEvent) evt.value();
			service.addConnessione(event.getFollowed(), event.getFollower());
		}
	}
}
