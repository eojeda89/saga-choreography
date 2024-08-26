package com.eojeda.common.publisher;

import com.eojeda.common.events.DomainEvent;
import reactor.core.publisher.Flux;

public interface EventPublisher<T extends DomainEvent> {

    Flux<T> publish();
}
