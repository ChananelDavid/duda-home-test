package com.duda.home.test.util;

import com.duda.home.test.model.Grade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.BiMap;

import javax.persistence.AttributeConverter;
import java.io.IOException;

public class BiMapConverter implements AttributeConverter<BiMap<Long, Long>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(BiMap<Long, Long> attribute) {
        String customerInfoJson = null;
        try {
            customerInfoJson = objectMapper.writeValueAsString(attribute);
        } catch (final JsonProcessingException e) {
        }

        return customerInfoJson;
    }

    @Override
    public BiMap<Long, Long> convertToEntityAttribute(String attribute) {

        BiMap<Long, Long> customerInfo = null;
        try {
            customerInfo = objectMapper.readValue(attribute, BiMap.class);
        } catch (final IOException e) {
        }

        return customerInfo;
    }
}
