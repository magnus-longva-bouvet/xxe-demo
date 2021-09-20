package no.sikkerhetshull.xxe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import java.io.IOException;

@RestController
public class XmlController {

    @Autowired
    private XmlParserService xmlParserService;

    @PostMapping(value = "/hello", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
    public String postData(@RequestBody String xmlString) throws TransformerException, SAXException, IOException {
//        try {
            return xmlParserService.parse(xmlString);
//        } //catch (Exception e) {
//            return e.getStackTrace().toString();
//        }
    }
}
