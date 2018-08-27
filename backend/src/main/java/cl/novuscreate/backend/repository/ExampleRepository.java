package cl.novuscreate.backend.repository;

import cl.novuscreate.backend.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<Example, Integer> {
}
