package asw.instagnam.common.api.event.producer;

import asw.instagnam.common.api.event.events.DomainEvent;

public interface DomainEventProducer {
	void produce(DomainEvent event);

	String getTopic();
}
