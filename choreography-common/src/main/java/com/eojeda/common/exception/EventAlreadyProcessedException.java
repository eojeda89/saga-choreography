package com.eojeda.common.exception;

public class EventAlreadyProcessedException extends RuntimeException{

    public static final String MESSAGE = "The event is already processed";

    public EventAlreadyProcessedException() {
        super(MESSAGE);
    }
}
