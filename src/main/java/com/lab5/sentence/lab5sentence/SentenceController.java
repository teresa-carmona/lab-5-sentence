package com.lab5.sentence.lab5sentence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SentenceController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/sentence")
    public @ResponseBody
    String getSentence() {
        return
                getWord("LAB-4-SUBJECT") + " "
                        + getWord("LAB-4-VERB") + " "
                        + getWord("LAB-4-ARTICLE") + " "
                        + getWord("LAB-4-ADJECTIVE") + " "
                        + getWord("LAB-4-NOUN") + "."
                ;
    }

    public String getWord(String service) {
        return (restTemplate.getForObject("http://" + service, String.class));

    }
}
