package cl.novuscreate.backend.repository;

import cl.novuscreate.backend.entity.UserProblem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProblemRepository extends JpaRepository<UserProblem, Integer> {
}
