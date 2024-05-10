package org.example.schemaregistry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestProducer testProducer;

    @GetMapping("/user")
    public String test() {
        testProducer.produceUser("John", 30);
        return "Message sent";
    }

}
