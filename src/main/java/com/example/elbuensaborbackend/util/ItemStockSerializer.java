package com.example.elbuensaborbackend.util;

import com.example.elbuensaborbackend.models.entities.ItemStock;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ItemStockSerializer extends JsonSerializer<ItemStock> {
    @Override
    public void serialize(ItemStock itemStock, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (itemStock.getName().equals(itemStock.getFather().getName())) {
            // Si los nombres son iguales, evita serializar la propiedad 'father'
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", itemStock.getId());
            jsonGenerator.writeStringField("name", itemStock.getName());
            jsonGenerator.writeBooleanField("active", itemStock.isActive());
            jsonGenerator.writeStringField("father", itemStock.getName());
            jsonGenerator.writeEndObject();
        } else {
            // Si los nombres no son iguales, serializa normalmente
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", itemStock.getId());
            jsonGenerator.writeStringField("name", itemStock.getName());
            jsonGenerator.writeBooleanField("active", itemStock.isActive());
            jsonGenerator.writeObjectField("father", itemStock.getFather());
            jsonGenerator.writeEndObject();
        }
    }
}