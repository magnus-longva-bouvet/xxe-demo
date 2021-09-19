package no.sikkerhetshull.xxe;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
public class XmlParserService {

//    private static String toString(Node node) throws TransformerException
//    {
//        TransformerFactory tf = TransformerFactory.newInstance();
//        Transformer transformer = tf.newTransformer();
//        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//
//        StringWriter writer = new StringWriter();
//        transformer.transform(new DOMSource(node), new StreamResult(writer));
//        return writer.toString();
//    }

    private DocumentBuilder builder;

    public XmlParserService() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        this.builder = factory.newDocumentBuilder();
    }

    public String parse(String xml) throws IOException, SAXException, TransformerException {
        ByteArrayInputStream input = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        Document a = builder.parse(input);
        Element root = a.getDocumentElement();
        return root.getFirstChild().getTextContent();
    }
}
