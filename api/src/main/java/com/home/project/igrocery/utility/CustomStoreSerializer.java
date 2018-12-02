package com.home.project.igrocery.utility;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.home.project.igrocery.entity.Store;

import java.io.IOException;
import java.util.List;

public class CustomStoreSerializer extends StdSerializer<List<Store>> {

    public CustomStoreSerializer() {
        this (null);
    }

    public CustomStoreSerializer(Class<List<Store>> t) {
        super(t);
    }

    @Override
    public void serialize(List<Store> stores,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartArray();
        for (Store store : stores) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("Store id", String.valueOf(store.getId()));
            jsonGenerator.writeStringField("Name", store.getName());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();

    }
}
