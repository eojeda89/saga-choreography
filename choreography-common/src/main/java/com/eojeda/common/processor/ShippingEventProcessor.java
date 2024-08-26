package com.eojeda.common.processor;

import com.eojeda.common.events.DomainEvent;
import com.eojeda.common.events.payment.PaymentEvent;
import com.eojeda.common.events.shipping.ShippingEvent;
import reactor.core.publisher.Mono;

public interface ShippingEventProcessor<R extends DomainEvent> extends EventProcessor<ShippingEvent, R> {
    @Override
    default Mono<R> process(ShippingEvent event) {
        return switch (event) {
            case ShippingEvent.Scheduled e -> handle(e);
        };
    }

    Mono<R> handle(ShippingEvent.Scheduled event);
}
