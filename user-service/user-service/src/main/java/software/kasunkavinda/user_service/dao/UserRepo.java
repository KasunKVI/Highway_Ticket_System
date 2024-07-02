package software.kasunkavinda.user_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import software.kasunkavinda.user_service.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
}
