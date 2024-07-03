package c.security03.controller;

import c.security03.config.MyUserDetailService;
import c.security03.jsonwebtoken.JwtService;
import c.security03.model.LoginForm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    final AuthenticationManager authenticationManager;
    final JwtService jwtService;
    final MyUserDetailService myUserDetailService;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtService jwtService, MyUserDetailService myUserDetailService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.myUserDetailService = myUserDetailService;
    }

    @PostMapping("/authenticate")
    public String authenticateToken(@RequestBody LoginForm loginForm) throws Exception {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.username(), loginForm.password()));
        if (authenticate.isAuthenticated()) {
            return jwtService.generateToken(myUserDetailService.loadUserByUsername(loginForm.username()));
        } else {
            System.out.println("Wrong password ");
            throw new UsernameNotFoundException("Invalid credentials");
        }
    }
}
