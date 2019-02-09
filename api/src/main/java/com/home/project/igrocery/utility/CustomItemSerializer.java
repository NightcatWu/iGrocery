package com.home.project.igrocery.utility;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.home.project.igrocery.entity.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
            jsonGenerator.writeStringField("id", String.valueOf(item.getId()));
            jsonGenerator.writeStringField("name", item.getName());
            jsonGenerator.writeStringField("bought", String.valueOf(item.isBought()));
            jsonGenerator.writeStringField("boughtWho", item.getBoughtWho());

            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();

    }
}
