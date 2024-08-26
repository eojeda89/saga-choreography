package com.eojeda.common.events.inventory;

import com.eojeda.common.events.DomainEvent;
import com.eojeda.common.events.OrderSaga;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

sealed public interface InventoryEvent extends DomainEvent, OrderSaga {
    @Builder
    record Deducted(UUID orderId, Integer inventoryId, Integer productId, Integer quantity, Instant createdAt) implements InventoryEvent{}
    @Builder
    record Restore(UUID orderId, Integer inventoryId, Integer productId, Integer quantity, Instant createdAt) implements InventoryEvent{}
    @Builder
    record Declined(UUID orderId, Integer productId, Integer quantity, String message, Instant createdAt) implements InventoryEvent{}
}
