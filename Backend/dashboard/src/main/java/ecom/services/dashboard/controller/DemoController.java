package ecom.services.dashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String getHelloString(){
        return "<h1>Hello this is your Dashboard</h1>";
    }
}
