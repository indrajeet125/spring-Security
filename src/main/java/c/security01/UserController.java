package c.security01;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/")
    public ResponseEntity<String> home() {
        String msg="you successfully login ";
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
}

