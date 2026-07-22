package Spring.FitLog.domain.user.repository;

import Spring.FitLog.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserName(String userName);

    Optional<User> findByUserId(String userId);
}
