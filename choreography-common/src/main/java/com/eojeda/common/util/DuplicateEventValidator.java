package com.eojeda.common.util;

import com.eojeda.common.exception.EventAlreadyProcessedException;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Slf4j
public class DuplicateEventValidator {

    public static Function<Mono<Boolean>, Mono<Void>> emitError() {
        return mono -> mono
                .flatMap(b -> b ? Mono.error(new EventAlreadyProcessedException()) : Mono.empty())
                .doOnError(EventAlreadyProcessedException.class, ex -> log.warn("Duplicate event"))
                .then();
    }

    public static <T> Mono<T> validate(Mono<Boolean> eventValidatorPublisher, Mono<T> eventProcessingPublisher) {
        return eventValidatorPublisher.transform(emitError())
                .then(eventProcessingPublisher);
    }
}
