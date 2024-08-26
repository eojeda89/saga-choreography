package com.eojeda.common.events.shipping;

import com.eojeda.common.events.DomainEvent;
import com.eojeda.common.events.OrderSaga;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

sealed public interface ShippingEvent extends DomainEvent, OrderSaga {
    @Builder
    record Scheduled(UUID orderId, UUID shipmentId, Instant expectedDelivery, Instant createdAt) implements ShippingEvent{}
}
