package org.example.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.common.error.exception.InternalServerErrorException;

import java.util.Map;

@Slf4j
public class JsonConvertor {
    public static Map convertJsonToMap(String value) {
        try {
            value = value.replace("json", "").replace("```", "");
            System.out.println(value);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(value, Map.class);
        } catch (Exception e) {
            log.error("Json으로 컨버팅 실패");
            throw InternalServerErrorException.EXCEPTION;
        }
    }
}
