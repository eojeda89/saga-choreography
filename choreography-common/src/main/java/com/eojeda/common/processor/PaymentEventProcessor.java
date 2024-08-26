package com.eojeda.common.processor;

import com.eojeda.common.events.DomainEvent;
import com.eojeda.common.events.inventory.InventoryEvent;
import com.eojeda.common.events.payment.PaymentEvent;
import reactor.core.publisher.Mono;

public interface PaymentEventProcessor<R extends DomainEvent> extends EventProcessor<PaymentEvent, R>  {
    @Override
    default Mono<R> process(PaymentEvent event) {
        return switch (event) {
            case PaymentEvent.Deducted e -> handle(e);
            case PaymentEvent.Declined e -> handle(e);
            case PaymentEvent.Refunded e -> handle(e);
        };
    }

    Mono<R> handle(PaymentEvent.Deducted event);
    Mono<R> handle(PaymentEvent.Declined event);
    Mono<R> handle(PaymentEvent.Refunded event);
}
