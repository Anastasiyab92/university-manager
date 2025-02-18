package com.solvd.universitymanager.parser;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class XMLValidator {

    public static void main(String[] args) {
        String schemaPath = "src/main/resources/structures/university.xsd";
        String xmlFile = "src/main/resources/structures/university.xml";
        if (validateXMLSchema(schemaPath, xmlFile)) {
            System.out.println("XML is valid!");
        } else
            System.out.println("XML is NOT valid!");


    }

    public static boolean validateXMLSchema(String xsdPath, String fileXml) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(fileXml)));
            return true;
        } catch (Exception e) {
            System.out.println("Validate error: " + e.getMessage());
            return false;
        }
    }
}
