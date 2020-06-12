package asw.instagnam.ricetteseguite.consumer;

import asw.instagnam.common.api.event.events.DomainEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface DomainEventConsumer {
	void onEvent(ConsumerRecord<String, DomainEvent> record);
}
