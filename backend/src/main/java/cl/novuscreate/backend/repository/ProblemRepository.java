package cl.novuscreate.backend.repository;

import cl.novuscreate.backend.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Integer> {
}
