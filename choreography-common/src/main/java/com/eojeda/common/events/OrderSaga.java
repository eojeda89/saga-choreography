package com.eojeda.common.events;

import java.util.UUID;

public interface OrderSaga extends Saga{
    UUID orderId();
}
