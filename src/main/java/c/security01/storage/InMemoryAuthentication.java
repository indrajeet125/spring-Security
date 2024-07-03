package c.security01.storage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;


public class InMemoryAuthentication  {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user3 = User
                .withUsername("user3")
                .password(passwordEncoder().encode("user3"))
                .roles("USER_ROLE")
                .build();

        UserDetails user1 = User
                .withUsername("user1")
                .password(passwordEncoder().encode("user1"))
                .roles("USER_ROLE")
                .build();


        UserDetails user2 = User
                .withUsername("user2")
                .password(passwordEncoder().encode("user2"))
                .roles("USER_ROLE")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}