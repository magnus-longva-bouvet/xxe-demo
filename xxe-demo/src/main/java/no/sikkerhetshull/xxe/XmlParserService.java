package no.sikkerhetshull.xxe;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
public class XmlParserService {

    private DocumentBuilder builder;

    public XmlParserService() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        this.builder = factory.newDocumentBuilder();
    }

    public String parse(String xml) throws IOException, SAXException {
        ByteArrayInputStream input = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        Document a = builder.parse(input);
        Element root = a.getDocumentElement();
        return root.getFirstChild().getTextContent();
    }
}
