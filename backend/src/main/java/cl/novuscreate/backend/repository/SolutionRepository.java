package cl.novuscreate.backend.repository;

import cl.novuscreate.backend.entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepository extends JpaRepository<Solution, Integer> {
}
