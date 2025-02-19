package org.example.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.common.error.exception.InternalServerErrorException;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class JsonConvertor {
    public static Map convertJsonToMap(String value) {
        try {
            Pattern pattern = Pattern.compile("\\{.*?}", Pattern.DOTALL);
            Matcher response = pattern.matcher(value);
            if (response.find()) {
                String json = response.group();
                System.out.println(json);

                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(json, Map.class);
            } else {
                throw  InternalServerErrorException.EXCEPTION;
            }
        } catch (Exception e) {
            log.error("Json으로 컨버팅 실패", e.getMessage(), e);
            throw InternalServerErrorException.EXCEPTION;
        }
    }
}
