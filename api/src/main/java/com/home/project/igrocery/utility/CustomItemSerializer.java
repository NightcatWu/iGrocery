package com.home.project.igrocery.utility;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.home.project.igrocery.entity.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomItemSerializer extends StdSerializer<List<Item>> {

    public CustomItemSerializer() {
        this (null);
    }

    public CustomItemSerializer(Class<List<Item>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Item> items,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartArray();
        for (Item item : items) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("Item id", String.valueOf(item.getId()));
            jsonGenerator.writeStringField("Item name", item.getName());
            jsonGenerator.writeStringField("Who bought", item.getBoughtWho());
            //jsonGenerator.writeStringField("Event id", String.valueOf(item.getEvents().getId()));

            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();

    }
}
