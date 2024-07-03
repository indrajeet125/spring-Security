package c.security02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping()
    public String getadmin0() {
        return "admin/";
    }

    @GetMapping("/get")
    public String getadmin1() {
        return "admin/get";
    }

    @GetMapping("/get/get")
    public String getadmin2() {
        return "admin/get/get";
    }

}
