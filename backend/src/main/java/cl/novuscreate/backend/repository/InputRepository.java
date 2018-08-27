package cl.novuscreate.backend.repository;

import cl.novuscreate.backend.entity.Input;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputRepository extends JpaRepository<Input, Integer> {
}
