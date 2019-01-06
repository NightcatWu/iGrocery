package com.home.project.igrocery.utility;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.home.project.igrocery.entity.Event;

import java.io.IOException;
import java.util.List;

public class CustomEventSerializer extends StdSerializer<List<Event>> {

    public CustomEventSerializer() {
        this (null);
    }

    public CustomEventSerializer(Class<List<Event>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Event> events,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartArray();
        for (Event event : events) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("Event id", String.valueOf(event.getId()));
            jsonGenerator.writeStringField("Name", event.getName());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();

    }
}
