package com.solvd.universitymanager.parser;

import com.solvd.universitymanager.domain.core.University;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;

public class JaxbParser {

    private static final Logger LOGGER = LogManager.getLogger(JaxbParser.class);

    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(University.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            InputStream inputStream = JaxbParser.class.getClassLoader().getResourceAsStream("university.xml");

            if (inputStream == null) {
                LOGGER.warn("File not found.");
            }
            University university = (University) unmarshaller.unmarshal(inputStream);
            LOGGER.info(university);
        } catch (
                JAXBException e) {
            LOGGER.error(e);
        }
    }
}
