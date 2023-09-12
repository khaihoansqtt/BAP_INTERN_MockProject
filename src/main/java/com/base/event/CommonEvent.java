package com.base.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.Arrays;
import java.util.List;

public class CommonEvent<T extends Object> extends ApplicationEvent {
    @Getter
    List<T> contents;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public CommonEvent(Object source, T... contents) {
        super(source);
        this.contents = Arrays.asList(contents);
    }
}
