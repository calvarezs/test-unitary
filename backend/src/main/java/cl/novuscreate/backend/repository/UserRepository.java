package cl.novuscreate.backend.repository;

import cl.novuscreate.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
