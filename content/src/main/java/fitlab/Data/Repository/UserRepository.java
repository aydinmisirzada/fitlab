package fitlab.Data.Repository;

import fitlab.Data.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  UserRepository extends JpaRepository<User, Integer> {
//    User findByUsername(String username);
    Optional<User> findByUsername(String username);
//    User findByEmailAndUsername(String email, String username);
}

