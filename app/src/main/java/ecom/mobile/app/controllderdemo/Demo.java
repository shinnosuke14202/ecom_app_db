package ecom.mobile.app.controllderdemo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Demo {

    @GetMapping("/test")
    public String test() {
        return "siuuu Hello World";
    }

    @GetMapping("/dtl")
    public String hello() {
        return "Hello Long";
    }

}
