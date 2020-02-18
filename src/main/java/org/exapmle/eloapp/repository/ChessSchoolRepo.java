package org.exapmle.eloapp.repository;

import org.exapmle.eloapp.domain.ChessSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ChessSchoolRepo extends JpaRepository {
    Optional<ChessSchool> findByName(String name);
    Optional<ChessSchool> findById(Long id);
}
