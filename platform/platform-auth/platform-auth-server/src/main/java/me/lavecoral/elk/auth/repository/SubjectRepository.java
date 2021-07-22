package me.lavecoral.elk.auth.repository;

import me.lavecoral.elk.auth.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lave
 * @date 2021/7/21 23:29
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
