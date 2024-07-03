package c.security03.config;


import c.security03.jsonwebtoken.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    final
    MyUserDetailService myUserDetailService;
    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfiguration(MyUserDetailService myUserDetailService) {
        this.myUserDetailService = myUserDetailService;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                registry -> {
                    registry.requestMatchers("/home/**", "/register/**","/authenticate").permitAll();
                    registry.requestMatchers("/admin/**").hasAuthority("ADMIN");
                    registry.requestMatchers("/user/**").hasAnyAuthority("ADMIN", "USER");
                    registry.anyRequest().authenticated();
                })
                .addFilterBefore(jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class) ;

        http.csrf(AbstractHttpConfigurer::disable);

        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }


    @Bean
    UserDetailsService userDetailsService() {
        return myUserDetailService;
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(15);
    }
    @Bean
    AuthenticationManager authenticationManager(){
        return new ProviderManager(authenticationProvider());
    }

}

