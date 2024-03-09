package ecom.mobile.app.controllderdemo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Demo {

    @GetMapping("/lvk")
    public String test() {
        return "Hello Kien siuuu";
    }

    @GetMapping("/dtl")
    public String hello() {
        return "Hello Long";
    }

    @GetMapping("/nmt")
    public String thridTest() { return "Hello Tien"; }

}
