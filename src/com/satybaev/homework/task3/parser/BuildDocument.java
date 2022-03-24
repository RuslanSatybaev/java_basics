package com.satybaev.homework.task3.parser;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class BuildDocument {

    public static Document buildDocument() throws Exception {
        File file = new File("src/com/satybaev/documents/gameplay2.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder().parse(file);
    }
}
