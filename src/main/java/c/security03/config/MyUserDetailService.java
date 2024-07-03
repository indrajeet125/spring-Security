package c.security03.config;

import c.security03.model.MyUser;
import c.security03.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    MyRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = repo.findByUsername(username);
        if (user.isPresent()) {
            var userObj = user.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .authorities(getRoles(userObj))
                    .build();

        } else
            return (UserDetails) new UsernameNotFoundException(username);

    }

    private String[] getRoles(MyUser userObj) {
        if (userObj.getRole() == null)
            return new String[]{"USER"};
        else
            return userObj.getRole().split(",");
    }
}
