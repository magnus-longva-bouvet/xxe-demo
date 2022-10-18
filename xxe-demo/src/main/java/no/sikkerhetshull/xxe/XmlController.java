package no.sikkerhetshull.xxe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
public class XmlController {

    @Autowired
    private XmlParserService xmlParserService;

    @GetMapping("/")
    public String getData() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "<form method=\"POST\" action=\"/hello\">\n" +
                "  <label for=\"fname\">Payload:</label><br>\n" +
                "  <textarea id=\"fname\" name=\"fname\" value=\"John\" rows=\"20\" cols=\"50\"></textarea><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> \n" +
                "</body>\n" +
                "</html>\n" +
                "\n";
    }

    @PostMapping(value = "/hello", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String postData(@RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType, @RequestBody String xmlString) throws TransformerException, SAXException, IOException {
        if (contentType.equals("application/x-www-form-urlencoded")) {
            String result = java.net.URLDecoder.decode(xmlString, StandardCharsets.UTF_8.name());
            xmlString = result.substring("fname=".length());
        }
            return xmlParserService.parse(xmlString);
    }
}
