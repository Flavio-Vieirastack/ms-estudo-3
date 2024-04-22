package com.msclients.msclients.Core.Utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiObjectMapper<T> {

    @Autowired
    private ObjectMapper mapper;

    @PostConstruct
    private void init() {
        System.out.println("Init mapper");
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public T dtoToModel(Object dto, Class<T> model) {
        return mapper.convertValue(dto, model);
    }
    public T convert(Object from, Class<T> to) {
        return mapper.convertValue(from, to);
    }

    public T modelToUpdatedModel(Object model, T updatedModel) {
        try {
            return mapper.updateValue(updatedModel, model);
        } catch (JsonMappingException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
