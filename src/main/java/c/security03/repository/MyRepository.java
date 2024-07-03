package c.security03.repository;

import c.security03.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MyRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByUsername(String userName);
}
