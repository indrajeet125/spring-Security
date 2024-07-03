package c.security03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping()
    public String gethome0() {
        return "home/";
    }

    @GetMapping("/get")
    public String gethome1() {
        return "home/get";
    }

    @GetMapping("/get/get")
    public String gethome2() {
        return "home/get/get";
    }

}
