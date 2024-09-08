package com.example.elbuensaborbackend.deprecated;

import com.example.elbuensaborbackend.models.entities.ItemStock;
import com.example.elbuensaborbackend.services.ItemStockService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
@Deprecated
public class ItemStockDeserializer extends StdDeserializer<ItemStock> {

    @Autowired
    private ItemStockService itemStockService;

    public ItemStockDeserializer() {
        this(null);
    }

    public ItemStockDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ItemStock deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
//        if(node.get("father").isTextual()){
//            System.out.println(node);
//            try {
//                return new ItemStock(node.get("name").asText(),
//                        node.get("active").asBoolean(),
//                        itemStockService.getByName(node.get("father").asText()));
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
        ItemStock father = jsonParser.getCodec().treeToValue(node.get("father"), ItemStock.class);
        System.out.println(node);
        return new ItemStock(node.get("name").asText(),
                node.get("active").asBoolean(),
                null);
    }
}
