package com.eojeda.common.processor;

import com.eojeda.common.events.DomainEvent;
import com.eojeda.common.events.inventory.InventoryEvent;
import reactor.core.publisher.Mono;

public interface InventoryEventProcessor<R extends DomainEvent> extends EventProcessor<InventoryEvent, R> {
    @Override
    default Mono<R> process(InventoryEvent event) {
        return switch (event) {
            case InventoryEvent.Deducted e -> handle(e);
            case InventoryEvent.Declined e -> handle(e);
            case InventoryEvent.Restore e -> handle(e);
        };
    }

    Mono<R> handle(InventoryEvent.Deducted event);
    Mono<R> handle(InventoryEvent.Declined event);
    Mono<R> handle(InventoryEvent.Restore event);
}
