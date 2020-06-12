package asw.instagnam.ricette.producer;

import asw.instagnam.common.api.event.events.DomainEvent;
import asw.instagnam.common.api.event.producer.DomainEventProducer;
import asw.instagnam.common.api.event.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class RicetteEventProducer implements DomainEventProducer {

	private final KafkaTemplate<String, DomainEvent> template;

	@Autowired
	public RicetteEventProducer(KafkaTemplate<String, DomainEvent> template) {
		this.template = template;
	}

	@Override
	public void produce(DomainEvent event) {
		template.send(getTopic(), event);
	}

	@Override
	public String getTopic() {
		return Topic.ricette;
	}

}
