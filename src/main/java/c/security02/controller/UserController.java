package c.security02.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping()
    public  String getuser0Post(){
        return  "user/0Post";
    }
    @GetMapping()
    public  String getuser0Get(){
        return  "user/0Get";
    }
    @GetMapping("/get")
    public  String getuser1(){
        return  "user/get";
    }

    @GetMapping("/get/get")
    public  String getuser2(){
        return  "user/get/get";
    }

}
