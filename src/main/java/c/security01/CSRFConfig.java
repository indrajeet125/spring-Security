package c.security01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class CSRFConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());

//        http.csrf(c -> c.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()));
//        http.csrf((csrf) -> csrf.csrfTokenRepository(new HttpSessionCsrfTokenRepository()));
//    http .csrf((csrf) -> csrf.csrfTokenRepository(new CustomCsrfTokenRepository()));

//        http.csrf((csrf) -> csrf.csrfTokenRequestHandler(new XorCsrfTokenRequestAttributeHandler()));
//        http.csrf((csrf) -> csrf.csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler()));

        return http.build();

    }
}
