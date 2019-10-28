package com.duda.home.test.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.Set;

public class SetConverter implements AttributeConverter<Set<Long>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Set<Long> attribute) {
        String customerInfoJson = null;
        try {
            customerInfoJson = objectMapper.writeValueAsString(attribute);
        } catch (final JsonProcessingException e) {
        }

        return customerInfoJson;
    }

    @Override
    public Set<Long> convertToEntityAttribute(String attribute) {

        Set<Long> customerInfo = null;
        try {
            customerInfo = objectMapper.readValue(attribute, Set.class);
        } catch (final IOException e) {
        }

        return customerInfo;
    }
}