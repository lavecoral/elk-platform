package me.lavecoral.elk.auth.repository;

import me.lavecoral.elk.auth.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author lave
 * @date 2021/4/1 01:12
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findByName(String name);
}
