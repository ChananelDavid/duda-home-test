package com.duda.home.test.util;

import com.duda.home.test.model.Grade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;

public class GradeConverter implements AttributeConverter<Grade, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Grade attribute) {
        String customerInfoJson = null;
        try {
            customerInfoJson = objectMapper.writeValueAsString(attribute);
        } catch (final JsonProcessingException e) {
        }

        return customerInfoJson;
    }

    @Override
    public Grade convertToEntityAttribute(String attribute) {

        Grade customerInfo = null;
        try {
            customerInfo = objectMapper.readValue(attribute, Grade.class);
        } catch (final IOException e) {
        }

        return customerInfo;
    }
}
