package com.eojeda.common.processor;

import com.eojeda.common.events.DomainEvent;
import com.eojeda.common.events.order.OrderEvent;
import reactor.core.publisher.Mono;

public interface OrderEventProcessor<R extends DomainEvent> extends EventProcessor<OrderEvent, R> {
    @Override
    default Mono<R> process(OrderEvent event) {
        return switch (event) {
            case OrderEvent.Created e -> handle(e);
            case OrderEvent.Cancelled e -> handle(e);
            case OrderEvent.Completed e -> handle(e);
        };
    }

    Mono<R> handle(OrderEvent.Created event);
    Mono<R> handle(OrderEvent.Cancelled event);
    Mono<R> handle(OrderEvent.Completed event);
}