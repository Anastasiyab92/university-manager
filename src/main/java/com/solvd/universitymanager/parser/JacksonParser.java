package com.solvd.universitymanager.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.solvd.universitymanager.domain.core.University;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;

public class JacksonParser {

    private static final Logger LOGGER = LogManager.getLogger(JacksonParser.class);

    public static void main(String[] args) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());

            InputStream inputStream = JacksonParser.class.getClassLoader().getResourceAsStream("university.json");

            if (inputStream == null) {
                throw new IllegalArgumentException("File not found! Check if university.json is in resources.");
            }

            University university = objectMapper.readValue(inputStream, University.class);

            LOGGER.info("University name: {}\n University address: {}\n List of faculties: {}",
                    university.getName(), university.getAddress(), university.getFaculties());

        } catch (Exception e) {
            LOGGER.error("Can't read the file", e);
        }
    }
}
