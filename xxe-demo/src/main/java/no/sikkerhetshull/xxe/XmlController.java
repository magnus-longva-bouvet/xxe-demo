package no.sikkerhetshull.xxe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
public class XmlController {

    private final RestTemplate restTemplate;
    private final HttpEntity<String> entity;
    @Autowired
    private XmlParserService xmlParserService;

    public XmlController() {
        this.restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "hilsen Magnus");
        this.entity = new HttpEntity<String>(null, headers);
    }

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

    @GetMapping("/weather_api_status")
    public String getWeatherApiStatus() {
        String url = "https://api.met.no/weatherapi/locationforecast/2.0/status.json";
        ResponseEntity<String> respEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return respEntity.getBody() +"<br><br> hentet fra api.met.no<br>" + respEntity.getHeaders().get("Date");
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
