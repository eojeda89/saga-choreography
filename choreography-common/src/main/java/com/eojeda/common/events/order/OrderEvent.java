package com.eojeda.common.events.order;

import com.eojeda.common.events.DomainEvent;
import com.eojeda.common.events.OrderSaga;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

sealed public interface OrderEvent extends DomainEvent, OrderSaga {
    @Builder
    record Created(UUID orderId, Integer productId, Integer customerId, Integer quantity, Integer unitPrice, Integer totalAmount, Instant createdAt) implements OrderEvent{}

    @Builder
    record Cancelled(UUID orderId, String message, Instant createdAt) implements OrderEvent{}

    @Builder
    record Completed(UUID orderId, String message, Instant createdAt) implements OrderEvent{}
}
